package com.project.LibraryManagementSystem.LibraryApp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class UserDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String address;

//    private Long userCardId;

    private Timestamp createdAt;


}
