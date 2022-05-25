package com.example.cortiliabe.repository;

import com.example.cortiliabe.data.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends JpaRepository<Street,Long> {
}
