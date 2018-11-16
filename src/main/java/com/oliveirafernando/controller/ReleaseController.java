package com.oliveirafernando.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliveirafernando.event.ResourceCreatedEvent;
import com.oliveirafernando.exceptionhandler.MyResponseExceptionHandler.Error;
import com.oliveirafernando.model.Release;
import com.oliveirafernando.repository.ReleaseRepository;
import com.oliveirafernando.service.PersonDoesntExistsOrInactiveException;
import com.oliveirafernando.service.ReleaseService;

@RestController
@RequestMapping("/releases")

public class ReleaseController {
	
	@Autowired
	private ReleaseService releaseService;

	@Autowired
	private ReleaseRepository releaseRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping
	public ResponseEntity<?> listAll() {
		List<Release> releases = this.releaseRepository.findAll();
		if (releases.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(releases);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Release> release = this.releaseRepository.findById(id);
		if (!release.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(release.get());
	}
	
	@PostMapping
	public ResponseEntity<Release> create(@Valid @RequestBody Release release, HttpServletResponse response) {
		Release createdRelease = this.releaseService.save(release);
		this.publisher.publishEvent(new ResourceCreatedEvent(this, response, createdRelease.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRelease);
	}
	
	@ExceptionHandler({ PersonDoesntExistsOrInactiveException.class })
	public ResponseEntity<Object> handlePersonDoesntExistsOrInactiveException(PersonDoesntExistsOrInactiveException ex){
		String errorMessage = this.messageSource.getMessage("person.doesntexists-or-inactive", null, LocaleContextHolder.getLocale());
		String technicalMessage = ex.toString();
		List<Error> errors = Arrays.asList(new Error(errorMessage, technicalMessage));

		return ResponseEntity.badRequest().body(errors);
	}
}
