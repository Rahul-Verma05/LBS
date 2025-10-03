package com.project.LibraryManagementSystem.LibraryApp;


import com.project.LibraryManagementSystem.LibraryApp.dto.CreateUserDto;
import com.project.LibraryManagementSystem.LibraryApp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Usertest {

    @Autowired
    private UserService userService;

    @Test
    public void getAllUsers() {
        System.out.println(userService.getAllUsers());
    }



    @Test
    public void createUserTest() {
        CreateUserDto c = new CreateUserDto("Rahul", "Verma", "Lucknow");
        System.out.println( userService.createUser(c) );
    }

}
