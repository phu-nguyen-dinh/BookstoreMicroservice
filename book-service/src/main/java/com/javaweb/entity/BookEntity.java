package com.javaweb.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book")
@Inheritance(strategy = InheritanceType.JOINED)
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "book_genre", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @JsonManagedReference
    private Set<GenreEntity> genres;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference
    private AuthorEntity author;

    @Column(name = "book_title", nullable = false)
    private String title;
    @Column(name = "price", nullable = false)
    private Integer price;
    @Column(name = "stock_quantity", nullable = false)
    private Integer quantity;

}
