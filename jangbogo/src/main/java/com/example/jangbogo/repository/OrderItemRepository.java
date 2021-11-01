package com.example.jangbogo.repository;

import java.util.List;

import com.example.jangbogo.domain.OrderItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findByOrdersId(Integer ordersId);
}
