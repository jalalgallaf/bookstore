package com.jalaldev.bookstore.bookstore.repositroy;

import com.jalaldev.bookstore.bookstore.model.Author;
import com.jalaldev.bookstore.bookstore.service.AuthorService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorById(Long id);
}
