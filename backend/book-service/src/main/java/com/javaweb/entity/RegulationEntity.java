package com.javaweb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name="regulation")
@Inheritance(strategy = InheritanceType.JOINED)
public class RegulationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="content", nullable = false)
    String content;

    @Column(name="date_issued", nullable = false)
    Date dateIssued;
}
