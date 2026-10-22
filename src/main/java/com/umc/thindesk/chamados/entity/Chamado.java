package com.umc.thindesk.chamados.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Document(collection = "chamados")
public class Chamado {

    @Id
    private String id;

    private String descricao;

    private LocalDateTime data;

    private ChamadoTipo tipo;

    private String solicitante;

    private String tecnico;

    private ChamadoStatus status;

    @DBRef(lazy = true)
    private List<ChamadoHistorico> historico;
}
