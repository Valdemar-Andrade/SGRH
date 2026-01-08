package com.sgrh.rh.service.interfaces;

import com.sgrh.rh.dto.request.ColaboradorCreateRequest;
import com.sgrh.rh.dto.response.ColaboradorResponse;

public interface ColaboradorService {

    ColaboradorResponse criar(ColaboradorCreateRequest request);
}
