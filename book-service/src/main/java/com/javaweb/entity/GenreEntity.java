package com.javaweb.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "genre")
@Inheritance(strategy = InheritanceType.JOINED)
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "genres")
    @JsonBackReference
    private Set<BookEntity> books;

    @Column(name = "genre_name", nullable = false)
    private String genreName;
}
