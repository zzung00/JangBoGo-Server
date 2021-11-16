package com.example.jangbogo.repository;

import java.util.List;

import com.example.jangbogo.domain.Stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer>{
    List<Stock> findByMarketId(Integer marketId);
    List<Stock> findByProductNameContaining(String query);
}
