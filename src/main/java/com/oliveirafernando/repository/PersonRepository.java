package com.oliveirafernando.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveirafernando.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
