package com.perflibnetcracker.searchservice.service;

import com.perflibnetcracker.searchservice.model.Book;
import com.perflibnetcracker.searchservice.model.Genre;

import java.util.List;

public interface GenreService {

    Genre findById(Long id);

    List<Genre> findAll();

    Genre saveBook(Book book);

    void deleteById(Long id);
}
