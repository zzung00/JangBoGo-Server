package com.example.jangbogo.repository;

import com.example.jangbogo.domain.Product;
import com.example.jangbogo.domain.Stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    Product findByProduct(String name);
}
