package com.project.LibraryManagementSystem.LibraryApp.controller;


import com.project.LibraryManagementSystem.LibraryApp.dto.BookDto;
import com.project.LibraryManagementSystem.LibraryApp.service.UserCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usercard")
@RequiredArgsConstructor
public class UserCardController {

    private final UserCardService userCardService;


    // Get All the Books allocated to a User
    @GetMapping("/{userCardId}")
    public ResponseEntity<?> getData(@PathVariable Long userCardId) {
        return userCardService.getUserBookData(userCardId);
    }




    // Allocate a Book to a UserCard
    @PostMapping("/{userCardId}/{bookId}")
    public ResponseEntity<?> allocateBook(@PathVariable Long userCardId, @PathVariable Long bookId) {
        return userCardService.allocateBook(userCardId, bookId);
    }





    // Deallocate a Book from a UserCard
    @DeleteMapping("/{userCardId}/{bookId}")
    public ResponseEntity<?> deallocateBook(@PathVariable Long userCardId, @PathVariable Long bookId) {
        return userCardService.deallocateBook(userCardId, bookId);
    }

}
