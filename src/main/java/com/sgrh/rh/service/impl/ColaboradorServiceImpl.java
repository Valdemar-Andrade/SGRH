package com.sgrh.rh.service.impl;

import com.sgrh.rh.dto.request.ColaboradorCreateRequest;
import com.sgrh.rh.dto.response.ColaboradorResponse;
import com.sgrh.rh.entity.Colaborador;
import com.sgrh.rh.exception.custom.BusinessException;
import com.sgrh.rh.repository.ColaboradorRepository;
import com.sgrh.rh.service.interfaces.ColaboradorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ColaboradorServiceImpl implements ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    @Override
    public ColaboradorResponse criar(ColaboradorCreateRequest request) {

        log.info("Iniciando criação de colaborador com email={}", request.email());

        if (colaboradorRepository.existsByEmail(request.email())) {
            throw new BusinessException("Email já cadastrado");
        }

        Colaborador colaborador = new Colaborador();
        colaborador.setNome(request.nome());
        colaborador.setEmail(request.email());
        colaborador.setDataNascimento(request.dataNascimento());
        colaborador.setDataAdmissao(request.dataAdmissao());

        Colaborador salvo = colaboradorRepository.save(colaborador);

        log.info("Colaborador criado com sucesso. id={}", salvo.getPkColaborador());

        return new ColaboradorResponse(
                salvo.getPkColaborador(),
                salvo.getNome(),
                salvo.getEmail(),
                salvo.getDataNascimento(),
                salvo.getDataAdmissao(),
                salvo.getAtivo()
        );
    }
}
