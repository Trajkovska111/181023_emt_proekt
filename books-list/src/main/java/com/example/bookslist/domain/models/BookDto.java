package com.example.bookslist.domain.models;

import lombok.Data;

@Data
public class BookDto {

    private String title;

    private String author;

    private Double price;

    private String category;

    private String pictureUrl;

    public BookDto() {
    }

    public BookDto(String title, String author, Double price, String category, String pictureUrl) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.category = category;
        this.pictureUrl = pictureUrl;
    }
}
