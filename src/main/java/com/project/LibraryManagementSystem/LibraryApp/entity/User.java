package com.project.LibraryManagementSystem.LibraryApp.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;


    private String lastName;


    @Column(nullable = false)
    private String address;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(unique = true , nullable = true)
    @ToString.Exclude
    private UserCard userCard;


    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;


}
