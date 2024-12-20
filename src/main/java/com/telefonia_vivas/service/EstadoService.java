package com.telefonia_vivas.service;

import com.telefonia_vivas.dto.entrada.EstadoDtoEntrada;
import com.telefonia_vivas.dto.salida.EstadoDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.factory.estadoservice.EstadoCrationService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class EstadoService {

    private final EstadoCrationService estadoCrationService;

    public EstadoDtoSalida crearEstado(EstadoDtoEntrada estadoDtoEntrada)
            throws ResourceNotFoundException {

        return estadoCrationService.crearEstado(estadoDtoEntrada);
    }
}
