package com.example.jangbogo.controller;

import java.util.List;

import com.example.jangbogo.domain.Market;
import com.example.jangbogo.domain.Stock;
import com.example.jangbogo.dto.StockRequest;
import com.example.jangbogo.dto.StockResponse;
import com.example.jangbogo.service.MarketService;
import com.example.jangbogo.service.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/market")
public class MarketController {
    @Autowired
    private MarketService marketService;

    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody List<Market> getAllMarket() {
        return marketService.loadAllMarket();
    }

    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
    public @ResponseBody List<StockResponse> getAllStocks(StockRequest request) {
        return stockService.loadAllStockByMaketId(request.getMarketId());
    }
}
