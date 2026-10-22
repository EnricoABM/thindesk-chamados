package com.umc.thindesk.chamados.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.umc.thindesk.chamados.dto.ChamadoRegisterDTO;
import com.umc.thindesk.chamados.entity.Chamado;
import com.umc.thindesk.chamados.entity.ChamadoStatus;
import com.umc.thindesk.chamados.repository.ChamadoHistoricoRepository;
import com.umc.thindesk.chamados.repository.ChamadoRepository;

@Service
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;
    private final ChamadoHistoricoRepository historicoRepository;

    public ChamadoService(ChamadoRepository chamadoRepository, ChamadoHistoricoRepository historicoRepository) {
        this.chamadoRepository = chamadoRepository;
        this.historicoRepository = historicoRepository;
    }

    public Chamado save(ChamadoRegisterDTO dto) {
        // TODO registrar historico

        Chamado model = dto.toModel();
        model.setStatus(ChamadoStatus.ABERTO);
        model.setData(LocalDateTime.now());
        return chamadoRepository.save(model);
    }

    public Chamado findById(String id) {
        return chamadoRepository.findById(id)
                .orElseThrow(() -> new ChamadoNotFoundException());
    }

}
