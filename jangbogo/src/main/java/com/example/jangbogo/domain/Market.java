package com.example.jangbogo.domain;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;

@Entity
@Data
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany
    @JoinTable(name = "market_product")
    private ArrayList<Stock> stocks = new ArrayList<>();
}
