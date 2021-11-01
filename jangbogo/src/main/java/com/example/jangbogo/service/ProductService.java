package com.example.jangbogo.service;


import java.util.List;
import java.util.stream.Collectors;

import com.example.jangbogo.domain.Category;
import com.example.jangbogo.domain.Product;
import com.example.jangbogo.dto.CategoryDTO;
import com.example.jangbogo.repository.ProductRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void enrollProduct(Product product) {
        productRepository.save(product);
    }
}
