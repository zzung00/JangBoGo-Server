package com.example.jangbogo.repository;

import com.example.jangbogo.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
    
    
}
