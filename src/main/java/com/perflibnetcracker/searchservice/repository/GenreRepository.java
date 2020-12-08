package com.perflibnetcracker.searchservice.repository;

import com.perflibnetcracker.searchservice.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
