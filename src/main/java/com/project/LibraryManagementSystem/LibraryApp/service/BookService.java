package com.project.LibraryManagementSystem.LibraryApp.service;


import com.project.LibraryManagementSystem.LibraryApp.dto.AddBookDto;
import com.project.LibraryManagementSystem.LibraryApp.dto.BookDto;
import com.project.LibraryManagementSystem.LibraryApp.entity.Book;
import com.project.LibraryManagementSystem.LibraryApp.enums.BookStatus;
import com.project.LibraryManagementSystem.LibraryApp.repository.BookRepository;
import com.project.LibraryManagementSystem.LibraryApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;



    // Get all Books Data
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        return books.stream().map( book ->
                new BookDto(book.getId(), book.getAuthor(), book.getAuthor(), book.getPublishingHouse(), book.getPublishedDate(), book.getCreatedAt(), book.getBookStatus())
        ).toList();
    }




    // Add a Book
    public BookDto addBook(AddBookDto bookDataDto) {
        Book book = Book.builder()
                .name(bookDataDto.getName())
                .author(bookDataDto.getAuthor())
                .publishingHouse(bookDataDto.getPublishingHouse())
                .publishedDate(bookDataDto.getPublishedDate())
                .build();

        book = bookRepository.save(book);

        return new BookDto(
                book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getPublishingHouse(),
                book.getPublishedDate(),
                book.getCreatedAt(),
                book.getBookStatus()
        );
    }







    // Delete a Book
    public ResponseEntity<String> deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow( () ->
                new RuntimeException("Book Not Found with ID " + id));

        if(book.getBookStatus() == BookStatus.BORROWED) {
            return new ResponseEntity<>("Cannot delete book. It is currently borrowed.", HttpStatus.BAD_REQUEST);
        }

        bookRepository.deleteById(id);

        return new ResponseEntity<>("Book Deleted Successfully", HttpStatus.OK);
    }


}
