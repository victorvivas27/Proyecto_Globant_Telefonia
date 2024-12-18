package com.telefonia_vivas.service;

import com.telefonia_vivas.dto.entrada.ContratoDtoEntrada;
import com.telefonia_vivas.dto.salida.ContratoDtoSalida;
import com.telefonia_vivas.entity.Estado;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.service.contratoservice.ContratoCreationService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ContratoService {

    private final ContratoCreationService contratoCreationService;


    public ContratoDtoSalida crearContrato(ContratoDtoEntrada contratoDtoEntrada) throws ResourceNotFoundException {

        return contratoCreationService.crearContrato(contratoDtoEntrada);

    }

    public ContratoDtoSalida actualizarEstado(Long idContrato, Estado estado) throws ResourceNotFoundException {

        return contratoCreationService.actualizarEstado(idContrato, estado);
    }
}
