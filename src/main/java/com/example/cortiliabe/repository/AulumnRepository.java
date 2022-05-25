package com.example.cortiliabe.repository;

import com.example.cortiliabe.data.entity.Aulumn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AulumnRepository extends JpaRepository<Aulumn,Long>, PagingAndSortingRepository<Aulumn,Long> {

    List<Aulumn> findAllByName(String name);

    Page<Aulumn> findAllByName(String name, Pageable pageable);
}
