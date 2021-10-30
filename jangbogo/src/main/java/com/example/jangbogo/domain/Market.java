package com.example.jangbogo.domain;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor 
@NoArgsConstructor
@RequiredArgsConstructor
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private double lat;

    @NonNull
    private double lng;

    private String operHour;

    private String tel;

    private String address;

    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL)
    private List<Stock> stocks = new ArrayList<>();

}
