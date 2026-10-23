package com.umc.thindesk.chamados.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.umc.thindesk.chamados.entity.Chamado;

public interface ChamadoRepository extends MongoRepository<Chamado, String> {
    List<Chamado> findAllBySolicitante(String solicitante, Pageable pageable);

    List<Chamado> findAllBySolicitante(String solicitante);

}
