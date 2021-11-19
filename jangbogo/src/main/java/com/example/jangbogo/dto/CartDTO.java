package com.example.jangbogo.dto;

import java.util.List;

import com.example.jangbogo.domain.Market;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private Integer id;
    private int count;
    private int total;
    private MarketDTO market;
    private List<CartItemDTO> cartItems;
}
