package com.example.jangbogo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.jangbogo.domain.Market;
import com.example.jangbogo.domain.Stock;
import com.example.jangbogo.dto.MarketDTO;
import com.example.jangbogo.dto.SearchItemDTO;
import com.example.jangbogo.dto.StockDTO;
import com.example.jangbogo.repository.MarketRepository;
import com.example.jangbogo.repository.StockRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<SearchItemDTO> search(String query) {
        List<Market> markets = marketRepository.findByNameContaining(query);
        List<Stock> stocks = stockRepository.findByProductNameContaining(query);
        List<SearchItemDTO> result = new ArrayList<>();

        for (Market m : markets) {
            SearchItemDTO searchItemDTO = new SearchItemDTO();
            searchItemDTO.setMarket(modelMapper.map(m, MarketDTO.class));
            result.add(searchItemDTO);
        }

        for (Stock s : stocks) {
            SearchItemDTO searchItemDTO = new SearchItemDTO();
            searchItemDTO.setStock(modelMapper.map(s, StockDTO.class));
            searchItemDTO.setMarket(modelMapper.map(s.getMarket(), MarketDTO.class));
            result.add(searchItemDTO);
        }

        return result;
    }
}
