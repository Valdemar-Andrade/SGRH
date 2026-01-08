package com.sgrh.rh.dto.response;

import java.time.LocalDate;

public record ColaboradorResponse(
        Integer pkColaborador,
        String nome,
        String email,
        LocalDate dataNascimento,
        LocalDate dataAdmissao,
        Boolean ativo
) { }
