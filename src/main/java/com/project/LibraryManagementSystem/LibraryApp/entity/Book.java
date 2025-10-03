package com.project.LibraryManagementSystem.LibraryApp.entity;

import com.project.LibraryManagementSystem.LibraryApp.enums.BookStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private String author;


    @Column(nullable = false)
    private String publishingHouse;


    @Column(nullable = false)
    private LocalDate publishedDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private UserCard userCard;


    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;


    @Builder.Default
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus = BookStatus.AVAILABLE ;

}
