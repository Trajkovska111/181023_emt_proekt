package com.example.bookslist.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookslist.domain.models.Book;
import com.example.bookslist.domain.models.BookId;

public interface BookRepository extends JpaRepository<Book, BookId> {
}