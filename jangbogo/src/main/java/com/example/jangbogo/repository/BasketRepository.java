package com.example.jangbogo.repository;

import com.example.jangbogo.domain.Basket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Integer> {
    Basket findByUserId(int userid);
}
