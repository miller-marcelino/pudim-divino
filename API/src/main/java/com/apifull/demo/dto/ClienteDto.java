package com.apifull.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteDto {
    @NotBlank(message = "O nome é obrigatório")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ ]+$", message = "O nome deve conter apenas letras")
    private String nome;

    @NotBlank(message = "O sobrenome é obrigatório")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ ]+$", message = "O sobrenome deve conter apenas letras")
    private String sobrenome;

    @NotBlank(message = "O CEP é obrigatório")
    @Pattern(regexp = "\\d{8}", message = "CEP inválido")
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
    @Pattern(regexp = "\\d{11}", message = "WhatsApp inválido")
    private String whatsapp;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    @Pattern(regexp = ".*[!@#$%^&*(),.?\":{}|<>].*", message = "A senha deve conter pelo menos um caractere especial")
    private String senha;

    @NotBlank(message = "A confirmação de senha é obrigatória")
    private String confirmasenha;

    private String saborfavorito;
} 