package com.example.jangbogo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
    private Integer id;
    private int count;
    private int price;
    private ProductDTO product;
}
