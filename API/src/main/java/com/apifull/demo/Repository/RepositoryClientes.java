package com.apifull.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apifull.demo.Models.Clientes;

public interface RepositoryClientes extends JpaRepository<Clientes,Long> {
    
}
