package com.example.cortiliabe.data.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aulumn {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    String name;

    @ManyToMany
    @JoinColumn(name = "street_id")
    List<Street> addresses;

    @OneToOne
    @JoinColumn(name = "education_id")
    Education education;


}
