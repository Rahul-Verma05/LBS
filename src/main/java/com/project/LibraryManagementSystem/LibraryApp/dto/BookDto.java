package com.project.LibraryManagementSystem.LibraryApp.dto;


import com.project.LibraryManagementSystem.LibraryApp.entity.UserCard;
import com.project.LibraryManagementSystem.LibraryApp.enums.BookStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Long id;

    private String name;

    private String author;

    private String publishingHouse;

    private LocalDate publishedDate;

    private Timestamp createdAt;

    private BookStatus bookStatus;

}
