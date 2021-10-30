package com.example.jangbogo.controller;

import java.util.List;

import com.example.jangbogo.domain.Market;
import com.example.jangbogo.service.MarketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/market")
public class MarketController {
    @Autowired
    private MarketService marketService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody List<Market> getAllMarket() {
        return marketService.loadAllMarket();
    }
}
