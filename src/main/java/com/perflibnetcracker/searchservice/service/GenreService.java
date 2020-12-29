package com.perflibnetcracker.searchservice.service;

import com.perflibnetcracker.searchservice.model.Genre;

import java.util.List;

public interface GenreService {

    Genre findById(Long id);

    List<Genre> findAll();

    Genre saveGenre(Genre genre);

    void deleteById(Long id);
}
