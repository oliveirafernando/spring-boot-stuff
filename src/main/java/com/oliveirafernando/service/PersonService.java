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
		Optional<Person> savedPerson = this.personRepository.findById(id);
		if (!savedPerson.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		Person realSavedPerson = savedPerson.get();
		BeanUtils.copyProperties(person, realSavedPerson, "id");
		this.personRepository.save(realSavedPerson);

		return realSavedPerson;
	}

}
