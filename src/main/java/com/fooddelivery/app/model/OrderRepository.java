package com.fooddelivery.app.repository;

import com.fooddelivery.app.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository
        extends JpaRepository<Order, Long> {
}
