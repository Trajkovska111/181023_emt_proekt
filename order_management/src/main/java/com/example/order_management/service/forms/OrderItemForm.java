package com.example.order_management.service.forms;

import com.example.order_management.domain.valueobjects.Book;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderItemForm {

    @NotNull
    private Book book;

    @Min(1)
    private int quantity = 1;
}
