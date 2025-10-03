package com.project.LibraryManagementSystem.LibraryApp.service;


import com.project.LibraryManagementSystem.LibraryApp.dto.BookDto;
import com.project.LibraryManagementSystem.LibraryApp.entity.Book;
import com.project.LibraryManagementSystem.LibraryApp.repository.BookRepository;
import com.project.LibraryManagementSystem.LibraryApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        return books.stream().map( book ->
                new BookDto(book.getId(), book.getAuthor(), book.getAuthor(), book.getPublishingHouse(), book.getPublishedDate(), book.getCreatedAt(), book.getBookStatus())
        ).toList();

    }

}
