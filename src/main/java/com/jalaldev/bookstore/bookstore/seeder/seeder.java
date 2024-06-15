package com.jalaldev.bookstore.bookstore.seeder;

import com.github.javafaker.Faker;
import com.jalaldev.bookstore.bookstore.model.Author;
import com.jalaldev.bookstore.bookstore.model.Book;
import com.jalaldev.bookstore.bookstore.repositroy.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class seeder implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private static final Faker faker = new Faker();


    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 50; i++) {
            Author author = generateFakeAuthor();
            authorRepository.save(author);

            Book book = generateFakeBook(author);
            bookRepository.save(book);
        }

    }

    private Author generateFakeAuthor() {
        Author author = new Author();
        author.setName(faker.book().author());
        author.setBiography(faker.lorem().paragraph());
        return author;
    }

    private Book generateFakeBook(Author author) {
        Book book = new Book();
        book.setTitle(faker.book().title());
        book.setIsbn(faker.code().isbn10());
        book.setPublishDate(LocalDate.ofInstant(faker.date().past(365 * 10, TimeUnit.DAYS).toInstant(), ZoneId.systemDefault()));
        book.setAuthor(author);
        return book;
    }


}
