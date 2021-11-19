package com.example.jangbogo.dto;

import java.util.List;

import com.example.jangbogo.domain.Orders;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketDTO {
    private Integer id;
    private String name;
    private double lat;
    private double lng;
    private String operHour;
    private String tel;
    private String address;
}
