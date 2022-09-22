package com.example.order_management.domain.model;
import com.example.order_management.domain.valueobjects.Book;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.financial.Currency;
import com.example.sharedkernel.financial.Money;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="orders")
@Getter
public class Order extends AbstractEntity<OrderId> {
    private Instant orderedOn;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @Column(name="order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;


    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList = new HashSet<>();

    protected Order() {
        super(OrderId.randomId(OrderId.class));
    }
    public Order(Instant now, Currency currency) {
        super(OrderId.randomId(OrderId.class));
        this.orderedOn = now;
        this.currency = currency;
    }

    public Money total() {
        return orderItemList.stream().map(OrderItem::subtotal).reduce(new Money(currency, 0), Money::add);
    }

    public OrderItem addItem(@NonNull Book book, int qty) {
        Objects.requireNonNull(book,"book must not be null");
        var item  = new OrderItem(book.getId(),book.getPrice(),qty);
        orderItemList.add(item);
        return item;
    }

    public void removeItem(@NonNull OrderItemId orderItemId) {
        Objects.requireNonNull(orderItemId,"Order Item must not be null");
        orderItemList.removeIf(v->v.getId().equals(orderItemId));
    }

}
