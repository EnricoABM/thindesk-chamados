package com.umc.thindesk.chamados.entity;

/**
 * ChamadoStatus
 */
public enum ChamadoStatus {
    ABERTO("Aberto"),
    RESOLVIDO("Resolvido");

    private String status;

    private ChamadoStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
