package com.telefonia_vivas.service;

import com.telefonia_vivas.dto.entrada.ServicioDtoEntrada;
import com.telefonia_vivas.dto.modificar.ServicioDtoModificar;
import com.telefonia_vivas.dto.salida.ServicioDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.service.servicioservice.ServicioCreationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioService {
    private final ServicioCreationService servicioCreationService;

    public ServicioDtoSalida crearServicio(ServicioDtoEntrada servicioDtoEntrada) {
        return servicioCreationService.crearServicio(servicioDtoEntrada);
    }

    List<ServicioDtoSalida> listarServicio() {
        return null;
    }

    public ServicioDtoSalida obtenerServicioPorId(Long idServicio) throws ResourceNotFoundException {
        return null;
    }

    public ServicioDtoSalida actualizarServicio(ServicioDtoModificar ServicioDtoModificar) throws ResourceNotFoundException {
        return null;
    }

    public void eliminarServicio(Long idServicio) throws ResourceNotFoundException {

    }
}
