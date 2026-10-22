package com.umc.thindesk.chamados.exception;

/**
 * ChamadoNotFoundException
 */
public class ChamadoNotFoundException extends RuntimeException {

    public ChamadoNotFoundException() {
        super("Chamado não encontrado");
    }

}
