package com.project.LibraryManagementSystem.LibraryApp.repository;

import com.project.LibraryManagementSystem.LibraryApp.entity.User;
import com.project.LibraryManagementSystem.LibraryApp.entity.UserCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCardRepository extends JpaRepository<UserCard, Long> {


}
