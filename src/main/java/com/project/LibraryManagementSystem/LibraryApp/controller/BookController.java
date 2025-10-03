package com.project.LibraryManagementSystem.LibraryApp.controller;


import com.project.LibraryManagementSystem.LibraryApp.dto.BookDto;
import com.project.LibraryManagementSystem.LibraryApp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("book")
public class BookController {

    private final BookService bookservice;

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookservice.getAllBooks();
    }

}
