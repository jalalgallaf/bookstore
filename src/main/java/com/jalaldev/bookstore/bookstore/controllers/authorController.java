package com.jalaldev.bookstore.bookstore.controllers;

import com.jalaldev.bookstore.bookstore.model.Author;
import com.jalaldev.bookstore.bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.auditing.AuditingHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class authorController {

    private final AuthorService authorService;

    @GetMapping("/authors")
    ResponseEntity<List<Author>> getAllAuthors(){
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/authors/{authorID}")
    ResponseEntity<Author> getAuthor(@PathVariable Long authorID){
        return ResponseEntity.ok(authorService.getAuthorByID(authorID));
    }

    @PostMapping("/authors")
    ResponseEntity<Author>addAuthor(@RequestBody Author author){
        return ResponseEntity.ok(authorService.addAuthor(author));
    }

    @DeleteMapping("/authors")
    ResponseEntity deleteAuthor(@RequestBody Author author){
        authorService.deleteAuthor(author);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    ResponseEntity updateAuthor(@RequestBody Author author){
        authorService.updateAuthor(author);
        return ResponseEntity.noContent().build();
    }


}
