package com.example.jangbogo.controller;

import java.util.List;

import com.example.jangbogo.dto.StockDTO;
import com.example.jangbogo.service.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
    public @ResponseBody List<StockDTO> getAllStocks(int marketId) {
        return stockService.loadAllStockByMaketId(marketId);
    }
}
