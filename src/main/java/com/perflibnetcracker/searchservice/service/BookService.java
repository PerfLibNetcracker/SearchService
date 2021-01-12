package com.perflibnetcracker.searchservice.service;

import com.perflibnetcracker.searchservice.model.Author;
import com.perflibnetcracker.searchservice.model.Book;

import java.util.List;

public interface BookService {

    Book findById(Long id);

    List<Book> findAll();

    Book saveBook(Book book);

    void deleteById(Long id);

    List<Author> findAllAuthors();

}
