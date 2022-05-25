package com.example.cortiliabe.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Education {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "master_id")
    Formation master;

    @ManyToOne
    @JoinColumn(name = "phd_id")
    Formation phd;
}
