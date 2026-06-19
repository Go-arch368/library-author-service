package com.library.author.repository;

import com.library.author.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByNameContainingIgnoreCase(String name);
    boolean existsByName(String name);
}