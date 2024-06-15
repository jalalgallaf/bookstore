package com.jalaldev.bookstore.bookstore.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String isbn;
    LocalDate publishDate;
    @ManyToOne
    @JoinColumn(name = "author_id")
    Author author;
}
