package com.example.jangbogo.dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDTO {
    private Integer id;
    private Date date;
    private int total;
    private String status;
    private List<OrderItemDTO> orderItemDTOs;
}
