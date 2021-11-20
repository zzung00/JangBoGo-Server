package com.example.jangbogo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.jangbogo.domain.CartItem;
import com.example.jangbogo.domain.Market;
import com.example.jangbogo.domain.OrderItem;
import com.example.jangbogo.domain.Orders;
import com.example.jangbogo.domain.Product;
import com.example.jangbogo.dto.CartDTO;
import com.example.jangbogo.dto.CartItemDTO;
import com.example.jangbogo.dto.MarketDTO;
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

    public List<OrdersDTO> loadAllOrder() {
        List<Orders> orders = ordersRepository.findAll();
        List<OrdersDTO> ordersDTO = orders.stream().map(o -> modelMapper.map(o, OrdersDTO.class)).collect(Collectors.toList());
        return ordersDTO;
    }

    public List<OrderItemDTO> loadOrderItem(Integer orderId) {
        List<OrderItemDTO> response;
        List<OrderItem> orderItems = orderItemRepository.findByOrdersId(orderId);
        response = orderItems.stream().map(o -> modelMapper.map(o, OrderItemDTO.class)).collect(Collectors.toList());
        return response;
    }

    public OrdersDTO purchase(CartDTO cart) {
        Orders orders = new Orders();
        OrdersDTO ordersDTO;
        orders.setDate(Date.valueOf(LocalDate.now()));
        orders.setMarket(modelMapper.map(cart.getMarket(), Market.class));

        List<OrderItem> orderItems = new ArrayList<>();
        
        for (CartItemDTO c : cart.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrders(orders);
            orderItem.setCount(c.getCount());
            orderItem.setPrice(c.getPrice());
            orderItem.setProduct(modelMapper.map(c.getProduct(), Product.class));
            orderItems.add(orderItem);
        }
        orders.setOrderItems(orderItems);
        orders = ordersRepository.save(orders);

        ordersDTO = modelMapper.map(orders, OrdersDTO.class);
        return ordersDTO;

    }

}
