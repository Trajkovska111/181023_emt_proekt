package com.example.order_management.domain.repository;

import com.example.order_management.domain.model.Order;
import com.example.order_management.domain.model.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
}
