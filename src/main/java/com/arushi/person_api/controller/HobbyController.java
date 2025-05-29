package com.arushi.person_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.arushi.person_api.model.Hobby;
import com.arushi.person_api.model.Person;
import com.arushi.person_api.repository.HobbyRepository;
import com.arushi.person_api.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/hobbies")
public class HobbyController {

    @Autowired
    private HobbyRepository hobbyRepository;

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/person/{personId}")
    public Hobby addHobby(@PathVariable Long personId, @RequestBody Hobby hobby) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found"));
        hobby.setPerson(person);
        return hobbyRepository.save(hobby);
    }

    @GetMapping("/person/{personId}")
    public List<Hobby> getHobbiesByPerson(@PathVariable Long personId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found"));
        return person.getHobbies();
    }

    @PutMapping("/{id}")
    public Hobby updateHobby(@PathVariable Long id, @RequestBody Hobby updatedHobby) {
        return hobbyRepository.findById(id)
                .map(hobby -> {
                    hobby.setName(updatedHobby.getName());
                    return hobbyRepository.save(hobby);
                })
                .orElseThrow(() -> new RuntimeException("Hobby not found with id " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteHobby(@PathVariable Long id) {
        hobbyRepository.deleteById(id);
    }

    @GetMapping("/search")
    public List<Hobby> findPeopleByHobbyName(@RequestParam String name) {
        return hobbyRepository.findByName(name);
    }
}
