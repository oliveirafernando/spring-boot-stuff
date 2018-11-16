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
import com.oliveirafernando.model.Release;
import com.oliveirafernando.repository.ReleaseRepository;

@RestController
@RequestMapping("/releases")

public class ReleaseController {

	@Autowired
	private ReleaseRepository releaseRepository;

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
}
