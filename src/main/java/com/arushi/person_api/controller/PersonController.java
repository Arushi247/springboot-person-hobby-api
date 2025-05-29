package com.arushi.person_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.arushi.person_api.model.Person;
import com.arushi.person_api.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        return personRepository.findById(id)
                .map(person -> {
                    person.setName(updatedPerson.getName());
                    person.setPhoneNumber(updatedPerson.getPhoneNumber());
                    person.setAddress(updatedPerson.getAddress());
                    return personRepository.save(person);
                })
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
    }
}
