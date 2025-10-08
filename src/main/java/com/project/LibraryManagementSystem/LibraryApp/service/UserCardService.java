package com.project.LibraryManagementSystem.LibraryApp.service;


import com.project.LibraryManagementSystem.LibraryApp.dto.BookDto;
import com.project.LibraryManagementSystem.LibraryApp.entity.Book;
import com.project.LibraryManagementSystem.LibraryApp.entity.UserCard;
import com.project.LibraryManagementSystem.LibraryApp.enums.BookStatus;
import com.project.LibraryManagementSystem.LibraryApp.repository.BookRepository;
import com.project.LibraryManagementSystem.LibraryApp.repository.UserCardRepository;
import com.project.LibraryManagementSystem.LibraryApp.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserCardService {

    private final UserRepository userRepository;
    private final UserCardRepository userCardRepository;
    public final BookRepository bookRepository;


    public ResponseEntity<?> getUserBookData(Long userCardId) {

        Optional<UserCard> userCardOptional = userCardRepository.findById(userCardId);

        if(userCardOptional.isEmpty()) {
            return new ResponseEntity<>("No User Card exists with ID : " + userCardId , HttpStatus.BAD_REQUEST);
        }

        UserCard userCard = userCardOptional.get();


        List<Book> books = userCard.getBooks();

        List<BookDto> bookDtos = books.stream().map( book ->
                    new BookDto(
                            book.getId(),
                            book.getName(),
                            book.getAuthor(),
                            book.getPublishingHouse(),
                            book.getPublishedDate(),
                            book.getCreatedAt(),
                            book.getBookStatus()
                    )
                ).toList();

        return ResponseEntity.ok(bookDtos);
    }






    @Transactional
    public ResponseEntity<?> allocateBook(Long userCardId, Long bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        Optional<UserCard> userCardOptional = userCardRepository.findById(userCardId);

        if(bookOptional.isEmpty()) {
            return new ResponseEntity<>("Invalid Book Id", HttpStatus.BAD_REQUEST);
        }

        if(userCardOptional.isEmpty()) {
            return new ResponseEntity<>("Invalid User Card Id", HttpStatus.BAD_REQUEST);
        }


        Book book = bookOptional.get();
        UserCard userCard = userCardOptional.get();


        if(book.getBookStatus() == BookStatus.BORROWED) {
            return new ResponseEntity<>("Book Already Borrowed by Someone Else", HttpStatus.BAD_REQUEST);
        }



        String s = userCard.getBooksId();
        if(s.equals("{}")) {
            s = "{ " + Long.toString(bookId)  + " }";
        } else {
            s = s.replaceAll("[{}]", "").trim();
            s = "{ " + s + ", " + Long.toString(bookId) + " }";
        }




        userCard.getBooks().add(book);
        userCard.setBooksId(s);
        book.setBookStatus(BookStatus.BORROWED);
        book.setUserCard(userCard);

        return ResponseEntity.ok("Book with ID " + bookId + " is allocated successfully to User Card Id : " + userCardId);
    }





    @Transactional
    public ResponseEntity<?> deallocateBook(Long userCardId, Long bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        Optional<UserCard> userCardOptional = userCardRepository.findById(userCardId);

        if(bookOptional.isEmpty()) {
            return new ResponseEntity<>("Invalid Book Id", HttpStatus.BAD_REQUEST);
        }

        if(userCardOptional.isEmpty()) {
            return new ResponseEntity<>("Invalid User Card Id", HttpStatus.BAD_REQUEST);
        }


        Book book = bookOptional.get();
        UserCard userCard = userCardOptional.get();


        if(book.getBookStatus() == BookStatus.AVAILABLE) {
            return new ResponseEntity<>("Book is already available", HttpStatus.BAD_REQUEST);
        }

        if(book.getUserCard() != userCard) {
            return new ResponseEntity<>("Book not allocated to this User", HttpStatus.BAD_REQUEST);
        }

        userCard.getBooks().remove(book);
        book.setBookStatus(BookStatus.AVAILABLE);
        book.setUserCard(null);

        String s = userCard.getBooksId();
        s = s.replaceAll("[{}]", "").trim();
        String[] ans = s.split(", ");
        String result = "";
        if(ans.length == 1) {
            result = "{}";
        }
        else {
            ArrayList<String> newans = new ArrayList<>();
            for (int i = 0; i < ans.length; i++) {
                if (ans[i].equals(Long.toString(bookId))) {
                    continue;
                }
                newans.add(ans[i]);
            }


            result = "{ " + String.join(", ", newans) + " }";
        }
        userCard.setBooksId(result);



        return ResponseEntity.ok("Book with ID " + bookId + " is De-allocated successfully from User Card Id : " + userCardId);
    }



}
