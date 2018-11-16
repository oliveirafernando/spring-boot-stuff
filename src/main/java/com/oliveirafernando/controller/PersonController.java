package com.oliveirafernando.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> listAll() {
		List<Person> people = personRepository.findAll();
		if (people.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(people);
	}

	@PostMapping
	public ResponseEntity<Person> create(@Valid @RequestBody Person person, HttpServletResponse response) {
		Person createdPerson = this.personRepository.save(person);
		this.publisher.publishEvent(new ResourceCreatedEvent(this, response, createdPerson.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Person> person = this.personRepository.findById(id);
		if (!person.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(person.get());
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		personRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Person> update(@PathVariable Long id, @Valid @RequestBody Person person) {
		Person updatedPerson = this.personService.update(id, person);
		return ResponseEntity.ok(updatedPerson);
	}
	
	@PutMapping("/{id}/active")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateActiveProperty(@PathVariable Long id, @RequestBody(required = true) Boolean isActive) {
		this.personService.updateActiveProperty(id, isActive);
	}
}
