package com.jalaldev.bookstore.bookstore.service;

import com.jalaldev.bookstore.bookstore.DTO.AuthorDTO;
import com.jalaldev.bookstore.bookstore.model.Author;

import java.util.List;

public interface AuthorService {
    List<AuthorDTO> getAllAuthors();
    AuthorDTO getAuthorByID(Long id);
    AuthorDTO addAuthor(Author author);
    void updateAuthor(Author author);
    void deleteAuthor(Author author);
}
