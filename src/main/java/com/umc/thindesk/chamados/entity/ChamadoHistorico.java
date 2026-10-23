package com.umc.thindesk.chamados.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ChamadoHistorico
 */
@Getter
@Setter
@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "chamado_historico")
public class ChamadoHistorico {

    @Id 
    private String id;
    private LocalDateTime data;
    @DBRef(lazy = true)
    private Chamado chamado;
    private String usuario;
    private ChamadoStatus estadoAnterior;
    private ChamadoStatus estadoAtual;
}
