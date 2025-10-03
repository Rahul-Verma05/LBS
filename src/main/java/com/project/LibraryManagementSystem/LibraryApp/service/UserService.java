package com.project.LibraryManagementSystem.LibraryApp.service;


import com.project.LibraryManagementSystem.LibraryApp.dto.CreateUserDto;
import com.project.LibraryManagementSystem.LibraryApp.dto.UpdateUserDto;
import com.project.LibraryManagementSystem.LibraryApp.dto.UserDto;
import com.project.LibraryManagementSystem.LibraryApp.entity.Book;
import com.project.LibraryManagementSystem.LibraryApp.entity.User;
import com.project.LibraryManagementSystem.LibraryApp.entity.UserCard;
import com.project.LibraryManagementSystem.LibraryApp.enums.BookStatus;
import com.project.LibraryManagementSystem.LibraryApp.repository.BookRepository;
import com.project.LibraryManagementSystem.LibraryApp.repository.UserCardRepository;
import com.project.LibraryManagementSystem.LibraryApp.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserCardRepository userCardRepository;
    private final BookRepository bookRepository;



    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map(user ->
            new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getAddress(), user.getCreatedAt())
        ).toList();
    }



    public UserDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getAddress(), user.getCreatedAt());
    }


    @Transactional
    public UserDto createUser(CreateUserDto userData) {
        UserCard userCard = new UserCard();

        User user = User.builder()
                .address(userData.getAddress())
                .firstName(userData.getFirstName())
                .lastName((userData.getLastName()))
                .userCard(userCard)
                .build();

        user = userRepository.save(user);

        userCard.setUser(user);
        userCard.setUserId(user.getId());

        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getAddress(),
                user.getCreatedAt()
        );
    }



    @Transactional
    public String deleteUser(Long id){

        User user = userRepository.findById(id).orElseThrow();
        UserCard userCard = user.getUserCard();
        List<Book> books = userCard.getBooks();

        for(Book book : books) {
            book.setBookStatus(BookStatus.AVAILABLE);
            book.setUserCard(null);
        }

        userRepository.delete(user);

        return "User with ID : " + id + " is Deleted Successfully";
    }





    public UserDto updateUser(UpdateUserDto updateUserDto, Long id) {
        User user = userRepository.findById(id).orElseThrow();

        user.setFirstName(updateUserDto.getFirstName());
        user.setLastName(updateUserDto.getLastName());
        user.setAddress(updateUserDto.getAddress());

        user = userRepository.save(user);

        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getAddress(),
                user.getCreatedAt()
        );
    }





}

