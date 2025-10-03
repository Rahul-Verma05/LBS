package com.project.LibraryManagementSystem.LibraryApp.repository;

import com.project.LibraryManagementSystem.LibraryApp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
