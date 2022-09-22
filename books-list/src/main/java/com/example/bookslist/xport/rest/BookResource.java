package com.example.bookslist.xport.rest;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookslist.domain.models.Book;
import com.example.bookslist.domain.models.BookDto;
import com.example.bookslist.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookResource {

    private final BookService bookService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAll")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/add")
    public Book addBook(@RequestBody BookDto book) {
        return bookService.addBook(book.getTitle(), book.getAuthor(), book.getPrice(), book.getCategory(), book.getPictureUrl());
    }

}
