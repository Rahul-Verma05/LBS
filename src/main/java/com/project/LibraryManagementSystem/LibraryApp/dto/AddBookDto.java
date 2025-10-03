package com.project.LibraryManagementSystem.LibraryApp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBookDto {
    private String name;

    private String author;

    private String publishingHouse;

    private LocalDate publishedDate;
}
