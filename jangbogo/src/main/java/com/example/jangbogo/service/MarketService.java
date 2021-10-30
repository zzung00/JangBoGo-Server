package com.example.jangbogo.service;

import java.util.List;

import com.example.jangbogo.domain.Market;
import com.example.jangbogo.repository.MarketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketService {
    @Autowired
    private MarketRepository marketRepository;

    public List<Market> loadAllMarket() {
        return marketRepository.findAll();
    }

    public void enrollMarket(Market market) {
        marketRepository.save(market);
    }
}
