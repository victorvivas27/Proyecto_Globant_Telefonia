package com.telefonia_vivas.service.direccionservice;

import com.telefonia_vivas.dto.salida.DireccionDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DireccionGetByIdService {

    public DireccionDtoSalida obtenerDireccionPorId(Long idDireccion) throws ResourceNotFoundException {

        return null;
    }
}
