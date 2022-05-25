package com.example.cortiliabe.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Formation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    String university;

    String year ;
}
