package com.javaweb.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "author")
@Inheritance(strategy = InheritanceType.JOINED) // Sử dụng InheritanceType.JOINED để tạo bảng con cho các lớp con
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<BookEntity> books;

    @Column(name = "author_name", nullable = false)
    private String authorName;
}
