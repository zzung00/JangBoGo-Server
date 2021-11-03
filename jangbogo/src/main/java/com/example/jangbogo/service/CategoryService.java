package com.example.jangbogo.service;

import com.example.jangbogo.domain.Category;
import com.example.jangbogo.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void enrollCategory(Category category) {
        categoryRepository.save(category);
    }
}
