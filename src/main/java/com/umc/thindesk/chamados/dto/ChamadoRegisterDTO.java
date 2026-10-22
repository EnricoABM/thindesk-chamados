package com.umc.thindesk.chamados.dto;

import org.hibernate.validator.constraints.Length;

import com.umc.thindesk.chamados.entity.Chamado;
import com.umc.thindesk.chamados.entity.ChamadoTipo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ChamadoRegisterDTO(
        @NotBlank(message = "Descrição não pode estar vazia") 
        @Length(min = 5, message = "Descrição deve ter no mínimo 5 caracteres") 
        String descricao,
        @NotNull(message = "Tipo não pode estar vazia")
        ChamadoTipo tipo,
        @NotBlank(message = "Solicitante não pode estar vazia")
        String solicitante,
        @NotBlank(message = "Tecnico não pode estar vazia")
        String tecnico) {
    public Chamado toModel() {
        return Chamado.builder()
                .descricao(descricao)
                .tipo(tipo)
                .solicitante(solicitante)
                .tecnico(tecnico)
                .build();
    }
}
