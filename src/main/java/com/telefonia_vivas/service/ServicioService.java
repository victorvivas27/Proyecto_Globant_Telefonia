package com.telefonia_vivas.service;

import com.telefonia_vivas.dto.entrada.ServicioDtoEntrada;
import com.telefonia_vivas.dto.modificar.ServicioDtoModificar;
import com.telefonia_vivas.dto.salida.ServicioDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.mapper.mapperservicio.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioService {
    private final ServicioCreationService servicioCreationService;
    private final ServicioListService servicioListService;
    private final ServicioGetByIdService servicioGetByIdService;
    private final ServicioUpdateService servicioUpdateService;
    private final ServicioDeleteService servicioDeleteService;


    public ServicioDtoSalida crearServicio(ServicioDtoEntrada servicioDtoEntrada) {

        return servicioCreationService.crearServicio(servicioDtoEntrada);
    }

    public List<ServicioDtoSalida> listarServicio() {

        return servicioListService.listarServicio();
    }

    public ServicioDtoSalida obtenerServicioPorId(Long idServicio)
            throws ResourceNotFoundException {

        return servicioGetByIdService.obtenerServicioPorId(idServicio);

    }

    public ServicioDtoSalida actualizarServicio(ServicioDtoModificar servicioDtoModificar)
            throws ResourceNotFoundException {

        return servicioUpdateService.actualizarServicio(servicioDtoModificar);
    }

    public void eliminarServicio(Long idServicio) throws ResourceNotFoundException {

        servicioDeleteService.eliminarServicio(idServicio);
    }
}
