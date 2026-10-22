package com.umc.thindesk.chamados.exception;

public class ChamadoNotFoundException extends RuntimeException {
    
    public ChamadoNotFoundException() {
        super("Chamado não encontrado");
    }
}
