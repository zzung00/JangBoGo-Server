package com.example.jangbogo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.jangbogo.domain.OrderItem;
import com.example.jangbogo.domain.Orders;
import com.example.jangbogo.dto.OrderItemDTO;
import com.example.jangbogo.dto.OrdersDTO;
import com.example.jangbogo.repository.OrderItemRepository;
import com.example.jangbogo.repository.OrdersRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    private ModelMapper modelMapper;

    public OrdersDTO loadOrders(Integer userId) {
        Orders orders = ordersRepository.findByUserId(userId);
        OrdersDTO ordersDTO = modelMapper.map(orders, OrdersDTO.class);
        return ordersDTO;
    }

    public List<OrderItemDTO> loadOrderItem(Integer orderId) {
        List<OrderItemDTO> response;
        List<OrderItem> orderItems = orderItemRepository.findByOrdersId(orderId);
        response = orderItems.stream().map(o -> modelMapper.map(o, OrderItemDTO.class)).collect(Collectors.toList());
        return response;
    }
}
