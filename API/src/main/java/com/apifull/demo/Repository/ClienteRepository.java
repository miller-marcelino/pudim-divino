package com.apifull.demo.Repository;

import com.apifull.demo.Models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long> {
    Optional<Clientes> findByEmail(String email);
} 