package com.umc.thindesk.chamados.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ChamadoNotFoundException
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ChamadoNotFoundException extends RuntimeException {

    public ChamadoNotFoundException() {
        super("Chamado não encontrado");
    }

}
