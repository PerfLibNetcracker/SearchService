package com.perflibnetcracker.searchservice.service;

import com.perflibnetcracker.searchservice.model.Author;
import com.perflibnetcracker.searchservice.model.Book;

import java.util.List;

public interface BookService {

    Book findById(Long id);

    List<Book> findAll();

    void saveBook(Book book);

    void deleteById(Long id);

    List<Author> findAllAuthors();

    List<Book> findAllByAuthor(String authorName);

    List<Book> findAllByGenre(String genreName);

    void addViewToBook(Book book);
}
