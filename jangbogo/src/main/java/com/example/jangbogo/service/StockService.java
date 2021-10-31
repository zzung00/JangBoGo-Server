package com.example.jangbogo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.jangbogo.domain.Stock;
import com.example.jangbogo.dto.StockResponse;
import com.example.jangbogo.repository.StockRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<StockResponse> loadAllStockByMaketId(Integer marketId) {
        List<StockResponse> response;
        List<Stock> stocks = stockRepository.findByMarketId(marketId);
        response = stocks.stream().map(s -> modelMapper.map(s, StockResponse.class)).collect(Collectors.toList());
        return response;
    }

    public void enrollStock(Stock stock) {
        stockRepository.save(stock);
    }
}
