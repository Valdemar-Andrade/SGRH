package com.sgrh.rh.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ColaboradorRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 150)
        String nome,

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "CPF é obrigatório")
        @Size(max = 20)
        String cpf,

        @Past(message = "Data de nascimento deve estar no passado")
        LocalDate dataNascimento,

        @NotBlank(message = "Cargo é obrigatório")
        String cargo,

        @NotNull(message = "Salário é obrigatório")
        @Positive(message = "Salário deve ser positivo")
        BigDecimal salario,

        @NotNull(message = "Data de admissão é obrigatória")
        LocalDate dataAdmissao
) { }
