package com.arushi.person_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arushi.person_api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

