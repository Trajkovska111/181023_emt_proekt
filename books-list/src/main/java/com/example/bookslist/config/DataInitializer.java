package com.example.bookslist.config;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import com.example.bookslist.domain.models.Book;
import com.example.bookslist.domain.repository.BookRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final BookRepository bookRepository;

    @PostConstruct
    public void initData() {
        Book p1 = Book.build(
                "It Ends With Us","Cooleen Hover",600.0,"Romance",
                "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9781/4711/9781471156267.jpg");
        Book p2 = Book.build(
                "This Is Goind To Hurt","Adam Kay",700.0,"Biography",
                "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9781/5098/9781509858637.jpg");
        Book p3 = Book.build(
                "Educated","Tara Westover",700.0,"Biography",
                "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/0995/9780099511021.jpg");
        Book p4 = Book.build(
                "A Gentleman In Moscow","Amor Towles",900.0,"Contemporary Fiction",
                "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/0995/9780099558781.jpg");
        Book p5 = Book.build(
                "Pachiko","Min Jin Lee",900.0,"Saga",
                "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9781/7866/9781786691378.jpg");
        Book p6 = Book.build(
                "Poeple We Meet On Vacation","Emily Henry",550.0,"Fiction",
                "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9781/9848/9781984806758.jpg");
        if (bookRepository.findAll().isEmpty()) {
            bookRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
        }
    }
}

