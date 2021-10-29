package com.example.jangbogo.service;

import java.util.ArrayList;

import com.example.jangbogo.domain.Market;
import com.example.jangbogo.dto.MarketResponse;
import com.example.jangbogo.repository.MarketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketService {
    @Autowired
    private MarketRepository marketRepository;

    public ArrayList<MarketResponse> loadMarkets() {
        ArrayList<MarketResponse> markets = (ArrayList<MarketResponse>) marketRepository.findMarketList();

        return markets;
    }
}
