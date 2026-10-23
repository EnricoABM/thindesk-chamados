package com.umc.thindesk.chamados.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.umc.thindesk.chamados.dto.ChamadoInfoDTO;
import com.umc.thindesk.chamados.dto.ChamadoRegisterDTO;
import com.umc.thindesk.chamados.dto.ChamadoResolveDTO;
import com.umc.thindesk.chamados.service.ChamadoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/chamados")
public class ChamadoController {

    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public URI save(@RequestBody @Valid ChamadoRegisterDTO dto, HttpServletRequest request) {
        ChamadoInfoDTO response = ChamadoInfoDTO.from(chamadoService.save(dto));
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ChamadoInfoDTO findById(@PathVariable String id) {
        return ChamadoInfoDTO.from(chamadoService.findById(id));
    }

    @GetMapping("/usuario/{id}")
    public List<ChamadoInfoDTO> findAllBySolicitante(
            @PathVariable String id,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String order) {
        List<ChamadoInfoDTO> list;
        if (page == null && size == null && order == null)
            list = chamadoService.findAllBySolicitente(id)
                    .stream()
                    .map(ChamadoInfoDTO::from)
                    .toList();
        else
            list = chamadoService.findAllBySolicitente(id, page, size, order)
                    .stream()
                    .map(ChamadoInfoDTO::from)
                    .toList();
        return list;
    }

    @PutMapping("/{id}/resolver")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void resolve(@PathVariable String id, @RequestBody @Valid ChamadoResolveDTO dto) {
        chamadoService.resolve(id, dto);
    }

}
