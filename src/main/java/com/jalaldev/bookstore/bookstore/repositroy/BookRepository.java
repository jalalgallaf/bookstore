package com.jalaldev.bookstore.bookstore.repositroy;

import com.jalaldev.bookstore.bookstore.model.Author;
import com.jalaldev.bookstore.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Book findBookById(Long id);
    List<Book> findBookByAuthor(Author author);
}
