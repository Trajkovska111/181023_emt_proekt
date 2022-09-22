package com.example.bookslist.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.sharedkernel.domain.base.AbstractEntity;

import lombok.Getter;

@Entity
@Table(name = "book")
@Getter
public class Book extends AbstractEntity<BookId> {
    private String title;
    private String author;
    private Double price;
    private String category;
    @Column(columnDefinition = "TEXT")
    private String pictureUrl;

    protected Book() {
        super(BookId.randomId(BookId.class));
    }

    public static Book build(String title, String author, Double price, String category, String pictureUrl) {
        Book book = new Book();
        book.title = title;
        book.author = author;
        book.price = price;
        book.category = category;
        book.pictureUrl = pictureUrl;

        return book;
    }
}
