package com.perflibnetcracker.searchservice.service.implementation;

import com.perflibnetcracker.searchservice.model.Book;
import com.perflibnetcracker.searchservice.model.Genre;
import com.perflibnetcracker.searchservice.repository.BookRepository;
import com.perflibnetcracker.searchservice.repository.GenreRepository;
import com.perflibnetcracker.searchservice.service.GenreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre findById(Long id) {
        return null;
    }

    @Override
    public List<Genre> findAll() {
        System.out.println(genreRepository.findAll());
        return genreRepository.findAll();
    }

    @Override
    public Genre saveBook(Book book) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
