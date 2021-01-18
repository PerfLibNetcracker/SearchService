package com.perflibnetcracker.searchservice.repository;

import com.perflibnetcracker.searchservice.model.Author;
import com.perflibnetcracker.searchservice.model.Book;
import com.perflibnetcracker.searchservice.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBookByIdIn(List<Long> ids);

    List<Book> findAllByAuthor(Author author);

    List<Book> findAllByGenre(Genre genre);
}
