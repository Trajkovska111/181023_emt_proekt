package com.example.bookslist.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookslist.domain.models.Book;
import com.example.bookslist.domain.repository.BookRepository;
import com.example.bookslist.services.BookService;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(String title, String author, Double price, String category, String pictureUrl) {
        Book book = Book.build(title, author, price, category, pictureUrl);
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public Book removeBook(Book book) {
        return removeBook(book);
    }
}
