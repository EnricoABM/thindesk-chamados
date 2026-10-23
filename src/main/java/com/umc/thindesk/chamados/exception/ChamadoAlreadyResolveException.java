package com.umc.thindesk.chamados.exception;

/**
 * ChamadoAlreadyResolveException
 */
public class ChamadoAlreadyResolveException extends RuntimeException {
    public ChamadoAlreadyResolveException() {
        super("Chamado já resolvido");
    }
}
