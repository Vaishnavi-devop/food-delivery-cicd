package com.fooddelivery.app.service;

import com.fooddelivery.app.model.Order;
import com.fooddelivery.app.repository.OrderRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {

        return orderRepository.save(order);
    }

    public List<Order> getOrders() {

        return orderRepository.findAll();
    }
}
