package com.library.author.controller;

import com.library.author.model.Author;
import com.library.author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/search")
    public List<Author> searchAuthors(@RequestParam String name) {
        return authorService.searchAuthors(name);
    }

    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id,
                               @RequestBody Author author) {
        return authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return "Author deleted successfully!";
    }
}