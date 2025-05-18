package com.apifull.demo.dto;

import lombok.Data;

@Data
public class ProdutoDto {
    private String nomeProduto;
    private String sabor;
    private String tamanho;
    private double peso;
    private int quantidade;
    private double preco;
    private String fotoproduto;
    private String ingredientes;
    private boolean disponivelparavenda;
} 