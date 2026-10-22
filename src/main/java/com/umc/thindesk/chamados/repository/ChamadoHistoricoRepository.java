package com.umc.thindesk.chamados.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.umc.thindesk.chamados.entity.ChamadoHistorico;

public interface ChamadoHistoricoRepository extends MongoRepository<ChamadoHistorico, String> {
    List<ChamadoHistorico> findByUsuario(String usuario);
}
