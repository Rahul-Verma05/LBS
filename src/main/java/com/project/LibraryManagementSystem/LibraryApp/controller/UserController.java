package com.project.LibraryManagementSystem.LibraryApp.controller;


import com.project.LibraryManagementSystem.LibraryApp.dto.CreateUserDto;
import com.project.LibraryManagementSystem.LibraryApp.dto.UpdateUserDto;
import com.project.LibraryManagementSystem.LibraryApp.dto.UserDto;
import com.project.LibraryManagementSystem.LibraryApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Get All Users
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }



    // Get a User with Specific ID
    @GetMapping("{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }



    // Create a New User
    @PostMapping
    public UserDto createUser(@RequestBody CreateUserDto userData) {
        return userService.createUser(userData);
    }



    // Delete a User with an ID
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }



    // Update details of the User
    @PutMapping("/{id}")
    public UserDto updateUser(@RequestBody UpdateUserDto updateUserDto, @PathVariable Long id) {
        return userService.updateUser(updateUserDto, id);
    }




}
