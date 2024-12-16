package com.telefonia_vivas.service;

import com.telefonia_vivas.dto.entrada.DireccionDtoEntrada;
import com.telefonia_vivas.dto.entrada.RegionDtoEntrada;
import com.telefonia_vivas.dto.salida.DireccionDtoSalida;
import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.service.direccionservice.DireccionCrationService;
import com.telefonia_vivas.service.regionservice.RegionCrationService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DireccionService {

    private final DireccionCrationService direccionCrationService;

    public DireccionDtoSalida crearDireccion(DireccionDtoEntrada direccionDtoEntrada) throws ResourceNotFoundException {

        return direccionCrationService.crearDireccion(direccionDtoEntrada);
    }
}
