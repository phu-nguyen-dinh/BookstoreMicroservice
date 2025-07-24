package com.javaweb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false)
    String userName;

    @Column(name="pass_word", nullable = false)
    String passWord;

    @Column(name="first_name", nullable = false)
    String first_name;

    @Column(name = "last_name", nullable = false)
    String last_name;
}
