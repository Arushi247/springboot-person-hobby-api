package com.arushi.person_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arushi.person_api.model.Hobby;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {
    List<Hobby> findByName(String name);
}
