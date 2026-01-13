package com.sgrh.rh.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ColaboradorResponseDTO(
        Integer pkColaborador,
        String nome,
        String email,
        String cpf,
        LocalDate dataNascimento,
        String cargo,
        BigDecimal salario,
        LocalDate dataAdmissao,
        Boolean ativo,
        LocalDateTime createdAt
) { }
