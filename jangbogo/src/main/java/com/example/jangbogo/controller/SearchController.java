package com.example.jangbogo.controller;

import java.util.List;

import com.example.jangbogo.dto.SearchItemDTO;
import com.example.jangbogo.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public @ResponseBody List<SearchItemDTO> search(@RequestParam String query) {
        return searchService.search(query);
    }
    
}
