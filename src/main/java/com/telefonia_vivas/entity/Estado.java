package com.telefonia_vivas.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Estado {
    ACTIVO,
    DESACTIVADO,
    CANCELADO,
    PENDIENTE;

    @JsonCreator
    public static Estado fromString(String value) {
        for (Estado estado : Estado.values()) {
            if (estado.name().equalsIgnoreCase(value)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Valor no válido para el estado: " + value);
    }
}
