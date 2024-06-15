package com.jalaldev.bookstore.bookstore.service;

import com.jalaldev.bookstore.bookstore.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book addBook(Book book);
    void updateBook(Book book);
    void deleteBook(Book book);
}
