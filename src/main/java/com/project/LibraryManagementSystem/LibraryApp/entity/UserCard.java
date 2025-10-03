package com.project.LibraryManagementSystem.LibraryApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(mappedBy = "userCard" ,fetch = FetchType.LAZY)
    @ToString.Exclude
    private User user;


    @OneToMany(mappedBy = "userCard", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Book> books = new ArrayList<>();

    private Long userId;

    private String booksId = "{}";

}
