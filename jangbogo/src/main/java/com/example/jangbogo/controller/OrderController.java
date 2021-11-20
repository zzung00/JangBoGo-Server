package com.example.jangbogo.controller;

import com.example.jangbogo.dto.OrdersDTO;
import com.example.jangbogo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody List<OrdersDTO> getAllOrders() {
        return orderService.loadAllOrder();
    }

}
