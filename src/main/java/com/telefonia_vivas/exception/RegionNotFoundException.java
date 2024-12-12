package com.telefonia_vivas.exception;

public class RegionNotFoundException extends RuntimeException {
    public RegionNotFoundException(String mensaje) {
        super(mensaje);
    }
}
