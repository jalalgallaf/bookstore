package com.jalaldev.bookstore.bookstore.service;

import com.jalaldev.bookstore.bookstore.DTO.BookDTO;
import com.jalaldev.bookstore.bookstore.model.Book;

import java.util.List;

public interface BookService {
    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long id);
    BookDTO addBook(Book BookDTO);
    void updateBook(Book BookDTO);
    void deleteBook(Book BookDTO);
}
