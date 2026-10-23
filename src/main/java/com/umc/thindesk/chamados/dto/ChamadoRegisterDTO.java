package com.umc.thindesk.chamados.dto;

import org.hibernate.validator.constraints.Length;

import com.umc.thindesk.chamados.entity.Chamado;

import jakarta.validation.constraints.NotBlank;

public record ChamadoRegisterDTO(
        @NotBlank(message = "Titulo não pode estar vazio")
        @Length(min = 5, message = "Titulo não pode estar vazio")
        String titulo,
        @NotBlank(message = "Descrição não pode estar vazia") 
        @Length(min = 5, message = "Descrição deve ter no mínimo 5 caracteres") 
        String descricao,
        @NotBlank(message = "Solicitante não pode estar vazia")
        String solicitante) {
    public Chamado toModel() {
        return Chamado.builder()
                .titulo(titulo)
                .descricao(descricao)
                .solicitante(solicitante)
                .build();
    }
}
