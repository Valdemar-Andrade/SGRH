package com.sgrh.rh.repository;

import com.sgrh.rh.entity.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

    Optional<Colaborador> findByEmail(String email);

    boolean existsByEmail(String email);
    Optional<Colaborador> findByCpf(String cpf);
}
