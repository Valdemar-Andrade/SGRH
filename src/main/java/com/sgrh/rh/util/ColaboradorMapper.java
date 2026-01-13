package com.sgrh.rh.util;

import com.sgrh.rh.dto.request.ColaboradorRequestDTO;
import com.sgrh.rh.dto.response.ColaboradorResponseDTO;
import com.sgrh.rh.entity.Colaborador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ColaboradorMapper {

    @Mapping(target = "pkColaborador", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Colaborador toEntity(ColaboradorRequestDTO dto);

    ColaboradorResponseDTO toResponse(Colaborador colaborador);
}
