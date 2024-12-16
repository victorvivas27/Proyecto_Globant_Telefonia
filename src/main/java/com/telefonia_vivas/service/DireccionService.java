package com.telefonia_vivas.service;

import com.telefonia_vivas.dto.entrada.DireccionDtoEntrada;
import com.telefonia_vivas.dto.modificar.DireccionDtoModificar;
import com.telefonia_vivas.dto.salida.DireccionDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.service.direccionservice.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DireccionService {

    private final DireccionCrationService direccionCrationService;
    private final DiteccionListService diteccionListService;
    private final DireccionGetByIdService direccionGetByIdService;
    private final DireccionUpdateService direccionUpdateService;
    private final DireccionDeleteService direccionDeleteService;

    public DireccionDtoSalida crearDireccion(DireccionDtoEntrada direccionDtoEntrada) throws ResourceNotFoundException {

        return direccionCrationService.crearDireccion(direccionDtoEntrada);
    }

    public List<DireccionDtoSalida> listarDireccion() {

        return diteccionListService.listarDireccion();
    }

    public DireccionDtoSalida obtenerDireccionPorId(Long idDireccion) throws ResourceNotFoundException {

        return direccionGetByIdService.obtenerDireccionPorId(idDireccion);
    }


    public DireccionDtoSalida actualizarDireccion(DireccionDtoModificar direccionDtoModificar) throws ResourceNotFoundException {

        return direccionUpdateService.actualizarDireccion(direccionDtoModificar);
    }

    public void eliminarDireccion(Long idDireccion) throws ResourceNotFoundException {

        direccionDeleteService.eliminarDireccion(idDireccion);

    }
}

