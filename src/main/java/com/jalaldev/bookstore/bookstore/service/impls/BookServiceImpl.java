package com.jalaldev.bookstore.bookstore.service.impls;

import com.jalaldev.bookstore.bookstore.model.Book;
import com.jalaldev.bookstore.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.jalaldev.bookstore.bookstore.repositroy.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return  bookRepository.findBookById(id);
    }

    @Override
    public Book addBook(Book book) {
       return bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }
}
