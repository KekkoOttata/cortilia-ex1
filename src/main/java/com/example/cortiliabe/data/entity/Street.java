package com.example.cortiliabe.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Street {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

     String street;

     String number;

     String country;

}
