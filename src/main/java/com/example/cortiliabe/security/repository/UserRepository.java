package com.example.cortiliabe.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cortiliabe.security.entity.UserDAO;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDAO,Long> {

    Optional<UserDAO> findByUsername(String username);
}
