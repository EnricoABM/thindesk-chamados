package com.umc.thindesk.chamados.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.umc.thindesk.chamados.entity.Chamado;
import com.umc.thindesk.chamados.entity.ChamadoStatus;

/**
 * ChamadoInfoDTO
 */
public record ChamadoInfoDTO(
    String id,
    String titulo,
    String descricao,
    LocalDateTime data,
    String solicitante,
    String tecnico,
    ChamadoStatus status,
    String resolucao,
    List<ChamadoHistoricoInfoDTO> historico 
) {
    public static ChamadoInfoDTO from(Chamado chamado) {
        return new ChamadoInfoDTO(
            chamado.getId(), 
            chamado.getTitulo(),
            chamado.getDescricao(), 
            chamado.getData(),
            chamado.getSolicitante(), 
            chamado.getTecnico(), 
            chamado.getStatus(),
            chamado.getResolucao(),
            ChamadoHistoricoInfoDTO.mapAll(chamado.getHistorico())
        );
    }
}
