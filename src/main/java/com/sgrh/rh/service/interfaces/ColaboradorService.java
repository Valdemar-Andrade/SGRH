package com.sgrh.rh.service.interfaces;

import com.sgrh.rh.dto.request.ColaboradorRequestDTO;
import com.sgrh.rh.dto.response.ColaboradorResponseDTO;

public interface ColaboradorService {

    ColaboradorResponseDTO criar(ColaboradorRequestDTO request);
}
