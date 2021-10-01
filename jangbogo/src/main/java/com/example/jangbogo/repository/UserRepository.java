package com.example.jangbogo.repository;

import com.example.jangbogo.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
