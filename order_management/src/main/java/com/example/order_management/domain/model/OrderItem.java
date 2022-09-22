package com.example.order_management.domain.model;

import com.example.order_management.domain.valueobjects.BookId;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.financial.Money;
import com.example.sharedkernel.domain.base.DomainObjectId;
import com.example.order_management.domain.valueobjects.BookId;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {

    @Embedded
    private Money itemPrice;

    @Column(name = "qty", nullable = false)
    private int quantity;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "book_id", nullable = false))
    private BookId bookId;

    protected OrderItem() {
        super(DomainObjectId.randomId(OrderItemId.class));
    }

    public OrderItem(@NonNull BookId bookId, @NonNull Money itemPrice, int qty) {
        super(DomainObjectId.randomId(OrderItemId.class));
        this.bookId = bookId;
        this.itemPrice = itemPrice;
        this.quantity = qty;
    }

    public Money subtotal() {
        return itemPrice.multiply(quantity);
    }
}
