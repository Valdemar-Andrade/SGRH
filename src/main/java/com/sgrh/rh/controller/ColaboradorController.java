package com.sgrh.rh.controller;

import com.sgrh.rh.dto.request.ColaboradorCreateRequest;
import com.sgrh.rh.dto.response.ColaboradorResponse;
import com.sgrh.rh.service.interfaces.ColaboradorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/colaboradores")
@RequiredArgsConstructor
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    @PostMapping
    public ResponseEntity<ColaboradorResponse> criarColaborador(@RequestBody @Valid ColaboradorCreateRequest request) {
        ColaboradorResponse response = colaboradorService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
