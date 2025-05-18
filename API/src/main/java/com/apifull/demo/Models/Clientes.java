package com.apifull.demo.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "Clientes")
@Data
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;

    @NotBlank(message = "O nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "O sobrenome é obrigatório")
    @Column(nullable = false)
    private String sobrenome;

    @NotBlank(message = "O CEP é obrigatório")
    @Column(length = 8)
    private String cep;

    @NotBlank(message = "A rua é obrigatória")
    private String rua;

    @NotBlank(message = "O número é obrigatório")
    private String numero;

    private String complemento;

    @NotBlank(message = "O bairro é obrigatório")
    private String bairro;

    @NotBlank(message = "A cidade é obrigatória")
    private String cidade;

    @NotBlank(message = "O WhatsApp é obrigatório")
    @Column(unique = true)
    private String whatsapp;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    private String senha;

    @Transient // Não será persistido no banco
    private String confirmasenha;

    private String saborfavorito;
}
