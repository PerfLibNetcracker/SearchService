package com.perflibnetcracker.searchservice.service.implementation;

import com.perflibnetcracker.searchservice.model.Genre;
import com.perflibnetcracker.searchservice.repository.GenreRepository;
import com.perflibnetcracker.searchservice.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GenreServiceImpl implements GenreService {
    GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre findById(Long id) {
        return genreRepository.findById(id).get();
    }

    @Override
    public List<Genre> findAll() {
        Set<Genre> set = new HashSet<>(genreRepository.findAll());
        return List.copyOf(set);
    }

    @Override
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void deleteById(Long id) {
        genreRepository.deleteById(id);
    }
}
