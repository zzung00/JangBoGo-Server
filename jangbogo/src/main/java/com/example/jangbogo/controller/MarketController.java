package com.example.jangbogo.controller;

import java.util.ArrayList;

import com.example.jangbogo.dto.MarketRequest;
import com.example.jangbogo.dto.MarketResponse;
import com.example.jangbogo.service.MarketService;

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
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody ArrayList<MarketResponse> list(@RequestBody MarketRequest request) {
        ArrayList<MarketResponse> response = marketService.loadMarkets();

        return response;
    }
}