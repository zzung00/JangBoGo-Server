package com.example.jangbogo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String category;
}
