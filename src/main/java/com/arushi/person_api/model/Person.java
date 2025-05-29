package com.arushi.person_api.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String address;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hobby> hobbies;

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    public List<Hobby> getHobbies() { return hobbies; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setAddress(String address) { this.address = address; }
    public void setHobbies(List<Hobby> hobbies) { this.hobbies = hobbies; }
}
