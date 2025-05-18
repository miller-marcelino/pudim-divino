package com.apifull.demo.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "Produtos")
@Data
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;

    @NotBlank(message = "O nome do produto é obrigatório")
    @Column(nullable = false)
    private String nomeProduto;

    @NotBlank(message = "O sabor é obrigatório")
    private String sabor;

    @NotBlank(message = "O tamanho é obrigatório")
    private String tamanho;

    @NotNull(message = "O peso é obrigatório")
    @Min(value = 0, message = "O peso deve ser maior que zero")
    private double peso;

    @NotNull(message = "A quantidade é obrigatória")
    @Min(value = 0, message = "A quantidade deve ser maior que zero")
    private int quantidade;

    @NotNull(message = "O preço é obrigatório")
    @Min(value = 0, message = "O preço deve ser maior que zero")
    private double preco;

    private String fotoproduto;

    @Column(columnDefinition = "TEXT")
    private String ingredientes;

    @NotNull(message = "A disponibilidade é obrigatória")
    private boolean disponivelparavenda;
}
