package com.example.jangbogo.repository;

import com.example.jangbogo.domain.Market;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, Integer>{
    Market findByName(String name);
}
