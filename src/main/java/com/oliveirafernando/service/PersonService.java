package com.oliveirafernando.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.oliveirafernando.model.Person;
import com.oliveirafernando.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Person update(Long id, Person person) {
		Person savedPerson = searchById(id);
		BeanUtils.copyProperties(person, savedPerson, "id");
		this.personRepository.save(savedPerson);

		return savedPerson;
	}

	private Person searchById(Long id) {
		Optional<Person> savedPerson = this.personRepository.findById(id);
		if (!savedPerson.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedPerson.get();
	}

	public void updateActiveProperty(Long id, Boolean isEnabled) {
		Person person = searchById(id);
		person.setIsActive(isEnabled);
		
		this.personRepository.save(person);	
	}

}
