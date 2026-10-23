package com.umc.thindesk.chamados.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.umc.thindesk.chamados.dto.ChamadoRegisterDTO;
import com.umc.thindesk.chamados.dto.ChamadoResolveDTO;
import com.umc.thindesk.chamados.entity.Chamado;
import com.umc.thindesk.chamados.entity.ChamadoStatus;
import com.umc.thindesk.chamados.exception.ChamadoAlreadyResolveException;
import com.umc.thindesk.chamados.exception.ChamadoNotFoundException;
import com.umc.thindesk.chamados.repository.ChamadoHistoricoRepository;
import com.umc.thindesk.chamados.repository.ChamadoRepository;

@Service
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;
    private final ChamadoHistoricoService historicoService;

    public ChamadoService(ChamadoRepository chamadoRepository, ChamadoHistoricoRepository historicoRepository,
            ChamadoHistoricoService historicoService) {
        this.chamadoRepository = chamadoRepository;
        this.historicoService = historicoService;

    }

    public Chamado save(ChamadoRegisterDTO dto) {
        Chamado model = dto.toModel();
        model.setStatus(ChamadoStatus.ABERTO);
        model.setData(LocalDateTime.now());
        return chamadoRepository.save(model);
    }

    public Chamado findById(String id) {
        return chamadoRepository.findById(id)
                .orElseThrow(() -> new ChamadoNotFoundException());
    }

    public void resolve(String id, ChamadoResolveDTO dto) {
        Chamado chamado = this.findById(id);

        if (chamado.getStatus().equals(ChamadoStatus.RESOLVIDO))
            throw new ChamadoAlreadyResolveException();

        ChamadoStatus estadoAnterior = chamado.getStatus();

        chamado.setResolucao(dto.resolucao());
        chamado.setTecnico(dto.tecnico());
        chamado.setStatus(ChamadoStatus.RESOLVIDO);
        chamadoRepository.save(chamado);
        historicoService.save(dto.tecnico(), chamado, estadoAnterior, ChamadoStatus.RESOLVIDO);
    }

    public List<Chamado> findAllBySolicitente(String id, int page, int size, String order) {
        List<Chamado> lista = chamadoRepository.findAllBySolicitante(id, PageRequest.of(page, size, Sort.by(order)))
                .stream()
                .map((chamado) -> {
                    chamado.setHistorico(
                            historicoService.findAllByChamado(chamado.getId()));
                    return chamado;
                })
                .toList();
        return lista;
    }

    public List<Chamado> findAllBySolicitente(String id) {
        List<Chamado> lista = chamadoRepository.findAllBySolicitante(id)
                .stream()
                .map((chamado) -> {
                    chamado.setHistorico(
                            historicoService.findAllByChamado(chamado.getId()));
                    return chamado;
                })
                .toList();
        return lista;
    }

}
