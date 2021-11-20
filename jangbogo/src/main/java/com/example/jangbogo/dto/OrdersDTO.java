package com.example.jangbogo.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDTO {
    private Integer id;
    private LocalDate date;
    private int total;
    private MarketDTO market;
    private List<OrderItemDTO> orderItemDTOs;
}
