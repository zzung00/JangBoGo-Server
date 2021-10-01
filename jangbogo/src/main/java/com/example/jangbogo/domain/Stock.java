package com.example.jangbogo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import javax.persistence.ManyToMany;
import lombok.*;

@Entity
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Product product;

    private int price;

    private int count;

    @ManyToMany(mappedBy = "stocks")
    private ArrayList<Market> markets = new ArrayList<>();
}
