package com.example.jangbogo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchItemDTO {
    private StockDTO stock;
    private MarketDTO market;
}
