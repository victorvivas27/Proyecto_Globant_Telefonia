package com.telefonia_vivas.service.validation.validadorservicio;

import com.telefonia_vivas.constants.ConstanteServicio;
import com.telefonia_vivas.exception.NombreExistenteException;
import com.telefonia_vivas.repository.ServicioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidadorServicio {

    private final ServicioRepository servicioRepository;

    public void validateNombreServicio(String nombreServicio) {
        if (nombreServicio == null || nombreServicio.isBlank()) {
            throw new IllegalArgumentException(ConstanteServicio.NOMBRE_SERVICIO_NOT_NULL);
        }
        if (servicioRepository.existsByNombreServicio(nombreServicio)) {
            throw new NombreExistenteException(ConstanteServicio.NOMBRE_EXISTE);
        }

    }

}
