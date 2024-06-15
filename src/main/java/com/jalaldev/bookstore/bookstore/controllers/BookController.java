package com.jalaldev.bookstore.bookstore.controllers;

import com.jalaldev.bookstore.bookstore.model.Book;
import com.jalaldev.bookstore.bookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BookController {
    private final BookService bookService;

    @GetMapping("/books")
    ResponseEntity<List<Book>> getAllBooks(){
        var books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/{bookID}")
    ResponseEntity<Book>getBook(@PathVariable Long bookID){
        return ResponseEntity.ok(bookService.getBookById(bookID));
    }

    @PostMapping("/books")
    ResponseEntity<Book> addBook(@Valid @RequestBody Book book){
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @PutMapping("/books")
    ResponseEntity <Void> updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/books")
    ResponseEntity <Void> deleteBook(@RequestBody Book book){
        bookService.deleteBook(book);
        return ResponseEntity.noContent().build();
    }

}
