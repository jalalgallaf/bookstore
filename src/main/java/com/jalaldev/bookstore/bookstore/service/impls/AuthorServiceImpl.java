package com.jalaldev.bookstore.bookstore.service.impls;

import com.jalaldev.bookstore.bookstore.model.Author;
import com.jalaldev.bookstore.bookstore.repositroy.AuthorRepository;
import com.jalaldev.bookstore.bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorByID(Long id) {
       return authorRepository.findAuthorById(id);
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Author author) {
        authorRepository.delete(author);
    }
}
