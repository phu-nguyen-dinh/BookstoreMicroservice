package com.javaweb.entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "books")
@Inheritance(strategy = InheritanceType.JOINED)
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author_id", nullable = false)
    private Long authorID;
    @Column(name = "genre_id", nullable = false)
    private Integer price;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
