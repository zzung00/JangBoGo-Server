package com.example.jangbogo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketResponse {
    private Integer id;

    private String name;

    private double lat;

    private double lng;

    private String operHour;

    private String tel;
}
