package com.umc.thindesk.chamados.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.umc.thindesk.chamados.entity.Chamado;
import com.umc.thindesk.chamados.entity.ChamadoStatus;
import com.umc.thindesk.chamados.entity.ChamadoTipo;

/**
 * ChamadoInfoDTO
 */
public record ChamadoInfoDTO(
    String id,
    String descricao,
    LocalDateTime data,
    ChamadoTipo tipo,
    String solicitante,
    String tecnico,
    ChamadoStatus status,
    List<ChamadoHistoricoInfoDTO> historico 
) {
    public static ChamadoInfoDTO from(Chamado chamado) {
        return new ChamadoInfoDTO(
            chamado.getId(), 
            chamado.getDescricao(), 
            chamado.getData(), 
            chamado.getTipo(), 
            chamado.getSolicitante(), 
            chamado.getTecnico(), 
            chamado.getStatus(),
            ChamadoHistoricoInfoDTO.mapAll(chamado.getHistorico())
        );
    }
}
