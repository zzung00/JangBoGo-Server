package com.example.jangbogo.repository;

import java.util.List;
import java.util.Optional;

import com.example.jangbogo.domain.Cart;
import com.example.jangbogo.domain.CartItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Optional<Cart> findByUserId(Integer userId);
}
