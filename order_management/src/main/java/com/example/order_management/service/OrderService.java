package com.example.order_management.service;

import com.example.order_management.domain.exceptions.OrderIdNotExistException;
import com.example.order_management.domain.exceptions.OrderItemIdNotExistException;
import com.example.order_management.domain.model.Order;
import com.example.order_management.domain.model.OrderId;
import com.example.order_management.domain.model.OrderItemId;
import com.example.order_management.service.forms.OrderForm;
import com.example.order_management.service.forms.OrderItemForm;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    OrderId placeOrder(OrderForm orderForm);

    List<Order> findAll();

    Optional<Order> findById(OrderId id);

    void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderIdNotExistException;

    void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderIdNotExistException, OrderItemIdNotExistException;



}
