package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;

    // Внедрение через конструктор, рекомендуется Spring
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String keyword) {
        return bookRepository.findAll().stream()
                .filter(book -> book.getTitle().contains(keyword) || book.getAuthor().contains(keyword))
                .collect(Collectors.toList());
    }
}
