package com.example.jangbogo.service;


import com.example.jangbogo.domain.Product;
import com.example.jangbogo.repository.ProductRepository;

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
