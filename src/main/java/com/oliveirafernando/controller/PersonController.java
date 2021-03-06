package com.oliveirafernando.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oliveirafernando.event.ResourceCreatedEvent;
import com.oliveirafernando.model.Person;
import com.oliveirafernando.repository.PersonRepository;
import com.oliveirafernando.service.PersonService;

@RestController
@RequestMapping("/people")
public class PersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_PERSON') and #oauth2.hasScope('read')")
	public ResponseEntity<?> listAll() {
		List<Person> people = personRepository.findAll();
		if (people.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(people);
	}

	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CREATE_PERSON') and #oauth2.hasScope('write')")
	public ResponseEntity<Person> create(@Valid @RequestBody Person person, HttpServletResponse response) {
		Person createdPerson = this.personRepository.save(person);
		this.publisher.publishEvent(new ResourceCreatedEvent(this, response, createdPerson.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_PERSON') and #oauth2.hasScope('read')")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Person person = this.personRepository.findOne(id);
		if (person == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(person);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVE_PERSON') and #oauth2.hasScope('write')")
	public void remove(@PathVariable Long id) {
		personRepository.delete(id);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CREATE_PERSON') and #oauth2.hasScope('write')")
	public ResponseEntity<Person> update(@PathVariable Long id, @Valid @RequestBody Person person) {
		Person updatedPerson = this.personService.update(id, person);
		return ResponseEntity.ok(updatedPerson);
	}
	
	@PutMapping("/{id}/active")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_CREATE_PERSON') and #oauth2.hasScope('write')")
	public void updateActiveProperty(@PathVariable Long id, @RequestBody(required = true) Boolean isActive) {
		this.personService.updateActiveProperty(id, isActive);
	}
}
