package com.library.author.service;

import com.library.author.model.Author;
import com.library.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Author not found with id: " + id));
    }

    public Author addAuthor(Author author) {
        if (authorRepository.existsByName(author.getName())) {
            throw new RuntimeException("Author already exists!");
        }
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author updated) {
        Author existing = getAuthorById(id);
        existing.setName(updated.getName());
        existing.setNationality(updated.getNationality());
        return authorRepository.save(existing);
    }

    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new RuntimeException("Author not found with id: " + id);
        }
        authorRepository.deleteById(id);
    }

    public List<Author> searchAuthors(String name) {
        return authorRepository
                .findByNameContainingIgnoreCase(name);
    }
}