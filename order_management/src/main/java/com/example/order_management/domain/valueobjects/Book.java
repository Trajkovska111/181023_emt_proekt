package com.example.order_management.domain.valueobjects;


import com.example.sharedkernel.domain.base.ValueObject;
import com.example.sharedkernel.financial.Currency;
import com.example.sharedkernel.financial.Money;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Book implements ValueObject {

    private final BookId id;
    private final String name;
    private final Money price;
    private final int sales;

    private Book() {
        this.id=BookId.randomId(BookId.class);
        this.name= "";
        this.price = Money.valueOf(Currency.MKD,0);
        this.sales = 0;
    }

    @JsonCreator
    public Book(@JsonProperty("id") BookId id,
                   @JsonProperty("productName") String name,
                   @JsonProperty("price") Money price,
                   @JsonProperty("sales") int sales) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = sales;
    }
}
