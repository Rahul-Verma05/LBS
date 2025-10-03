package com.project.LibraryManagementSystem.LibraryApp;


import com.project.LibraryManagementSystem.LibraryApp.dto.CreateUserDto;
import com.project.LibraryManagementSystem.LibraryApp.service.UserCardService;
import com.project.LibraryManagementSystem.LibraryApp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Usertest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserCardService userCardService;

    @Test
    public void getAllUsers() {
        System.out.println(userService.getAllUsers());
    }



    @Test
    public void createUserTest() {
        CreateUserDto c = new CreateUserDto("Rahul", "Verma", "Lucknow");
        System.out.println( userService.createUser(c) );
    }




    @Test
    public void allocateBookTest() {
        userCardService.allocateBook(1L,4L);
    }

}
