package com.example.jangbogo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Entity
@Data
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int userid;

    private Product product;

    private int price;

    private int count;
}
