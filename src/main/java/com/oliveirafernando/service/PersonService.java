package com.oliveirafernando.service;

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

	public Person searchById(Long id) {
		Person savedPerson = this.personRepository.findOne(id);
		if (savedPerson == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedPerson;
	}

	public void updateActiveProperty(Long id, Boolean isEnabled) {
		Person person = searchById(id);
		person.setIsActive(isEnabled);
		
		this.personRepository.save(person);	
	}
}
