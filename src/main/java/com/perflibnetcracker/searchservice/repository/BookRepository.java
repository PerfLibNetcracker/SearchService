package com.perflibnetcracker.searchservice.repository;

import com.perflibnetcracker.searchservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
}
