package com.umc.thindesk.chamados.dto;

import jakarta.validation.constraints.NotBlank;

public record ChamadoResolveDTO(
    @NotBlank(message = "Resolução não pode ser vazio") 
    String resolucao,
    @NotBlank(message = "Técnico não pode ser vazio")
    String tecnico
) {

}
