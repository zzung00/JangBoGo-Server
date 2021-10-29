package com.example.jangbogo.domain;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private double lat;

    private double lng;

    private String operHour;

    private String tel;

    @ManyToMany
    @JoinTable(name = "market_stock")
    private List<Stock> stocks = new ArrayList<>();
}
