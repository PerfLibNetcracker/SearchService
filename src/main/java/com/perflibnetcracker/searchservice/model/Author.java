package com.perflibnetcracker.searchservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class Author {
    public Author(){}

    @Id
    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "full_name")
    private String fullName;


}
