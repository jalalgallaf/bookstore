package com.jalaldev.bookstore.bookstore.service.impls;

import com.jalaldev.bookstore.bookstore.DTO.BookDTO;
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
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(this::tobookDTO).toList();
    }

    @Override
    public BookDTO getBookById(Long id) {
        return tobookDTO(bookRepository.findBookById(id));
    }

    @Override
    public BookDTO addBook(Book book) {
        return tobookDTO(bookRepository.save(book));
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    private BookDTO tobookDTO(Book book){
        return BookDTO.builder()
                .id(book.getId())
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .author(book.getAuthor())
                .publishDate(book.getPublishDate())
                .build();
    }


}
