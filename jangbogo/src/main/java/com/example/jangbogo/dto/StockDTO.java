package com.example.jangbogo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
    private Integer id;
    private int price;
    private int count;
    private ProductDTO product;
}
