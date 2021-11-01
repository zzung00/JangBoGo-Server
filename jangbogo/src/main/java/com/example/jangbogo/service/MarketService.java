package com.example.jangbogo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.jangbogo.domain.Market;
import com.example.jangbogo.dto.MarketDTO;
import com.example.jangbogo.repository.MarketRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketService {
    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<MarketDTO> loadAllMarket() {
        List<MarketDTO> marketDTOs;
        List<Market> markets =  marketRepository.findAll();
        marketDTOs = markets.stream().map(m -> modelMapper.map(m, MarketDTO.class)).collect(Collectors.toList());   
        return marketDTOs;
    }

    public void enrollMarket(Market market) {
        marketRepository.save(market);
    }
}
