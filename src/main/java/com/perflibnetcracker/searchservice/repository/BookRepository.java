package com.perflibnetcracker.searchservice.repository;

import com.perflibnetcracker.searchservice.model.Book;
import com.perflibnetcracker.searchservice.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBookByIdIn(List<Long> ids);

    List<Book> findAllByGenre(Genre genre);

    List<Book> findByNameContainingIgnoreCaseOrAuthorFullNameContainingIgnoreCase(String bookName, String authorName);

    List<Book> findAllByOrderByReleaseYearDesc();
}
