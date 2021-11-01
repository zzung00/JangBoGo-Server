package com.example.jangbogo.repository;

import java.util.List;

import com.example.jangbogo.domain.CartItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByCartId(Integer cartId);    
}
