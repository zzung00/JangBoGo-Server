package com.example.jangbogo.repository;

import com.example.jangbogo.domain.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    Orders findByUserId(Integer userId);
}
