package com.jalaldev.bookstore.bookstore.service.impls;

import com.jalaldev.bookstore.bookstore.DTO.AuthorDTO;
import com.jalaldev.bookstore.bookstore.model.Author;
import com.jalaldev.bookstore.bookstore.model.Book;
import com.jalaldev.bookstore.bookstore.repositroy.*;
import com.jalaldev.bookstore.bookstore.service.AuthorService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream().map(this::toAuthorDTO).toList();
    }

    @Override
    public AuthorDTO getAuthorByID(Long id) {
        return toAuthorDTO(authorRepository.findAuthorById(id));
    }

    @Override
    public AuthorDTO addAuthor(Author author) {
        return toAuthorDTO(authorRepository.save(author));
    }

    @Override
    public void updateAuthor(Author author) {
        toAuthorDTO(authorRepository.save(author));
    }

    @Override
    public void deleteAuthor(Author author) {
        var books = bookRepository.findBookByAuthor(author);
        for (Book book : books) {
            bookRepository.delete(book);
        }
        authorRepository.delete(author);
    }


    private AuthorDTO toAuthorDTO(Author author) {
        return AuthorDTO.builder()
                .name(author.getName())
                .id(author.getId())
                .biography(author.getBiography())
                .build();
    }
}
