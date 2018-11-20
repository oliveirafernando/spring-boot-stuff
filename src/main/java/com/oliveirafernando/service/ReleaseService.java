package com.oliveirafernando.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveirafernando.model.Person;
import com.oliveirafernando.model.Release;
import com.oliveirafernando.repository.PersonRepository;
import com.oliveirafernando.repository.ReleaseRepository;

@Service
public class ReleaseService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ReleaseRepository releaseRepository;

	public Release save(Release release) {
		Person person = personRepository.findOne(release.getPerson().getId());
		if(person == null || person.isInactive()) {
			throw new PersonDoesntExistsOrInactiveException();
		}
		return this.releaseRepository.save(release);
	}
	
}
