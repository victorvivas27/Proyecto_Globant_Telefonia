package com.telefonia_vivas.service.validation.validadordireccion;

import com.telefonia_vivas.constants.ConstanteDireccion;
import com.telefonia_vivas.entity.Direccion;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.DireccionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ValidadorDireccion {

    private final DireccionRepository direccionRepository;

    public Direccion validarIdDireccion(Long idDireccion) throws ResourceNotFoundException {

        if (idDireccion == null) {
            throw new IllegalArgumentException(ConstanteDireccion.DIRECCION_Id_NOT_NULL);
        }
        return direccionRepository.findById(idDireccion)
                .orElseThrow(() -> new ResourceNotFoundException(ConstanteDireccion.ID_DIRECCION_NO_EXISTE + idDireccion));
    }
}
