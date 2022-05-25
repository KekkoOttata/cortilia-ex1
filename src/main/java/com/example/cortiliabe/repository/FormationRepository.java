package com.example.cortiliabe.repository;


import com.example.cortiliabe.data.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository<Formation,Long>{
}
