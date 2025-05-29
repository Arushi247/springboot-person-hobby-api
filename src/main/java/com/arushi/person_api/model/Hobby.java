package com.arushi.person_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore  // 🚨 Prevents infinite loop during JSON serialization
    private Person person;

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public Person getPerson() { return person; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setPerson(Person person) { this.person = person; }
}
