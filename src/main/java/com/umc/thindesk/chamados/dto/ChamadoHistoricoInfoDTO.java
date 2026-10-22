package com.umc.thindesk.chamados.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.umc.thindesk.chamados.entity.ChamadoHistorico;
import com.umc.thindesk.chamados.entity.ChamadoStatus;

/**
 * ChamadoHistoricoInfoDTO
 */
public record ChamadoHistoricoInfoDTO(
        String id,
        LocalDateTime data,
        String usuario,
        ChamadoStatus estadoAnterior,
        ChamadoStatus estadoAtual) {
    public static ChamadoHistoricoInfoDTO from(ChamadoHistorico historico) {
        return new ChamadoHistoricoInfoDTO(
                historico.getId(),
                historico.getData(),
                historico.getUsuario(),
                historico.getEstadoAnterior(),
                historico.getEstadoAtual());
    }

    public static List<ChamadoHistoricoInfoDTO> mapAll(List<ChamadoHistorico> lista) {
        if (lista == null)
            return List.of();
        
        return lista.stream()
                .map(ChamadoHistoricoInfoDTO::from)
                .toList();
    }
}
