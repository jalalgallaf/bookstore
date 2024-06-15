package com.jalaldev.bookstore.bookstore.service;

import com.jalaldev.bookstore.bookstore.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();
    Author getAuthorByID(Long id);
    Author addAuthor(Author author);
    void updateAuthor(Author author);
    void deleteAuthor(Author author);
}
