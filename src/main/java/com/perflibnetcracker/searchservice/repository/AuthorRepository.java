package com.perflibnetcracker.searchservice.repository;

import com.perflibnetcracker.searchservice.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findOneByFullName(String fullNameAuthor);
}
