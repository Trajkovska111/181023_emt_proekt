package com.example.bookslist.services;

import java.util.List;

import com.example.bookslist.domain.models.Book;

public interface BookService {
    List<Book> getAll();
    Book addBook(String title, String author, Double price, String category, String pictureUrl);
    Book addBook(Book book);
    Book removeBook(Book book);
}
