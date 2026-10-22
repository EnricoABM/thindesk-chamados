package com.umc.thindesk.chamados.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.umc.thindesk.chamados.entity.Chamado;

@Repository
public interface ChamadoRepository extends MongoRepository<Chamado, String> {
    List<Chamado> findAllBySolicitante(String solicitante, Pageable pageable);
}
