package com.jalaldev.bookstore.bookstore.Repository;

import com.jalaldev.bookstore.bookstore.model.Book;
import com.jalaldev.bookstore.bookstore.repositroy.BookRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertFalse;

@DataJpaTest
@AutoConfigureTestDatabase
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    private Validator validator;

    @Test
    public void BookRepository_SaveAll_ReturnSaved(){
        // arrange
        Book book = Book.builder().id(2L).isbn("9783161484100").title("dffdffddf").build();
        //act
        Book savedBooked = bookRepository.save(book);
        //assert
        Assertions.assertThat(savedBooked).isNotNull();
        Assertions.assertThat(savedBooked.getId()).isGreaterThan(0);
    }


    @Test
    public void BookRepository_GetAll_ReturnMoreThanOneBook(){
        Book book = Book.builder().id(2L).isbn("9783161484100").title("dffdffddf").build();
        Book book2 = Book.builder().id(3L).isbn("9783161484102").title("dffdffddfdd").build();

        bookRepository.save(book);
        bookRepository.save(book);
        List<Book> books = bookRepository.findAll();

        Assertions.assertThat(books).isNotNull();
        Assertions.assertThat(books.size()).isEqualTo(2);

    }



}


