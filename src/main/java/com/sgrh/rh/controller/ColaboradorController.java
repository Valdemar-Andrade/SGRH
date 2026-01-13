package com.sgrh.rh.controller;

import com.sgrh.rh.dto.request.ColaboradorRequestDTO;
import com.sgrh.rh.dto.response.ColaboradorResponseDTO;
import com.sgrh.rh.service.interfaces.ColaboradorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/colaboradores")
@RequiredArgsConstructor
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ColaboradorResponseDTO criarColaborador(@RequestBody @Valid ColaboradorRequestDTO request) {
        return colaboradorService.criar(request);
    }
}
