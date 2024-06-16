package com.jalaldev.bookstore.bookstore.DTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jalaldev.bookstore.bookstore.model.Author;
import com.jalaldev.bookstore.bookstore.model.Book;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO {
    Long id;
    String title;
    String isbn;
    LocalDate publishDate;
    Author author;

   public static BookDTO toBookDto(Book book) {
       return BookDTO.builder()
               .id(book.getId())
               .isbn(book.getIsbn())
               .title(book.getTitle())
               .author(book.getAuthor())
               .publishDate(book.getPublishDate())
               .build();
   }
}
