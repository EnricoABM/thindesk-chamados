package com.umc.thindesk.chamados.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.umc.thindesk.chamados.dto.ErroDTO;

@RestControllerAdvice
public class ChamadoGlobalAdvice {
    
    @ExceptionHandler(ChamadoNotFoundException.class)
    public ResponseEntity<ErroDTO> handleChamadoNotFoundException(ChamadoNotFoundException ex) {
        return ResponseEntity.badRequest().body(new ErroDTO(ex.getMessage()));
    }

    @ExceptionHandler(ChamadoAlreadyResolveException.class)
    public ResponseEntity<ErroDTO> handleChamadoAlreadyResolveException(ChamadoAlreadyResolveException ex) {
        return ResponseEntity.badRequest().body(new ErroDTO(ex.getMessage()));
    }
}
