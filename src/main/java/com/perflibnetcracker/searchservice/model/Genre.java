package com.perflibnetcracker.searchservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Genre {

    @Id
    @Column(name = "genre_id")
    private Long genreId;

    private String name;
}
