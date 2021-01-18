package com.perflibnetcracker.searchservice.repository;

import com.perflibnetcracker.searchservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBookByIdIn(List<Long> ids);
    List<Book> findAllByAuthorId(Long authorId);
    List<Book> findAllByGenreId(Long genreId);
    List<Book> findByNameContainingIgnoreCase(String bookName);
}
