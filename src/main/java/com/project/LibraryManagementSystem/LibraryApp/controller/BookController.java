package com.project.LibraryManagementSystem.LibraryApp.controller;


import com.project.LibraryManagementSystem.LibraryApp.dto.AddBookDto;
import com.project.LibraryManagementSystem.LibraryApp.dto.BookDto;
import com.project.LibraryManagementSystem.LibraryApp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("book")
public class BookController {

    private final BookService bookservice;


    // Get Data of all the Books
    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookservice.getAllBooks();
    }


    // Add a Book
    @PostMapping
    public BookDto addBook(@RequestBody AddBookDto bookDataDto) {
        return bookservice.addBook(bookDataDto);
    }




    // Delete a Book
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        return bookservice.deleteBook(id);
    }


}
