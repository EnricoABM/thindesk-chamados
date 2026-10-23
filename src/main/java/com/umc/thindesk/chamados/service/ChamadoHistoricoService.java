package com.umc.thindesk.chamados.service;

import com.umc.thindesk.chamados.repository.ChamadoRepository;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.umc.thindesk.chamados.entity.ChamadoHistorico;
import com.umc.thindesk.chamados.entity.ChamadoStatus;
import com.umc.thindesk.chamados.repository.ChamadoHistoricoRepository;

@Service
public class ChamadoHistoricoService {

    private final ChamadoRepository chamadoRepository;
    private final ChamadoHistoricoRepository chamadoHistoricoRepository;
    
    public ChamadoHistoricoService(ChamadoHistoricoRepository chamadoHistoricoRepository, ChamadoRepository chamadoRepository) {
        this.chamadoHistoricoRepository = chamadoHistoricoRepository;
        this.chamadoRepository = chamadoRepository;
    }

    public ChamadoHistorico save(String usuario, ChamadoStatus estadoAnterior, ChamadoStatus estadoAtual) {
        ChamadoHistorico chamadoHistorico = ChamadoHistorico.builder()
            .id(null)
            .usuario(usuario)
            .data(LocalDateTime.now())
            .estadoAnterior(estadoAnterior)
            .estadoAtual(estadoAtual)
            .build();

        return chamadoHistoricoRepository.save(chamadoHistorico);
    }

    public List<ChamadoHistorico> findAllByChamado(String chamado) {
        return chamadoHistoricoRepository.findAllByChamado(chamado);
    }
}
