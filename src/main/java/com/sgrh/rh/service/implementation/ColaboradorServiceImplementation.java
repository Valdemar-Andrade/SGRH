package com.sgrh.rh.service.implementation;

import com.sgrh.rh.dto.request.ColaboradorRequestDTO;
import com.sgrh.rh.dto.response.ColaboradorResponseDTO;
import com.sgrh.rh.entity.Colaborador;
import com.sgrh.rh.exception.custom.BusinessException;
import com.sgrh.rh.repository.ColaboradorRepository;
import com.sgrh.rh.service.interfaces.ColaboradorService;
import com.sgrh.rh.util.ColaboradorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class ColaboradorServiceImplementation implements ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;
    private final ColaboradorMapper colaboradorMapper;

    @Override
    public ColaboradorResponseDTO criar(ColaboradorRequestDTO request) {

        log.info("Iniciando criação de colaborador com email={}", request.email());

        colaboradorRepository.findByEmail(request.email()).ifPresent(colaborador -> {
            throw new BusinessException("Email já cadastrado");
        });

        colaboradorRepository.findByCpf(request.cpf()).ifPresent(colaborador -> {
            throw new BusinessException("CPF já cadastrado");
        });

        Colaborador colaborador = colaboradorMapper.toEntity(request);
        colaborador.setAtivo(true);
        colaborador.setCreatedAt(LocalDateTime.now());
        colaborador.setUpdatedAt(LocalDateTime.now());

        Colaborador salvo = colaboradorRepository.save(colaborador);

        log.info("Colaborador criado com sucesso. id={}", salvo.getPkColaborador());

        return colaboradorMapper.toResponse(salvo);
    }
}
