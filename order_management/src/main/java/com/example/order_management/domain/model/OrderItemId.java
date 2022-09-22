package com.example.order_management.domain.model;

import com.example.sharedkernel.domain.base.DomainObjectId;

public class OrderItemId extends DomainObjectId {

    private OrderItemId() {
        super(OrderItemId.randomId(OrderItemId.class).getId());
    }

    public OrderItemId(String uuid) {
        super(uuid);
    }

}
