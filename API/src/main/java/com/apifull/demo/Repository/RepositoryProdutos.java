package com.apifull.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apifull.demo.Models.Produtos;

public interface RepositoryProdutos extends JpaRepository<Produtos,Long> {
    
}
