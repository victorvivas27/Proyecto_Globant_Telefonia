package com.telefonia_vivas.factory.direccionservice;

import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.DireccionRepository;
import com.telefonia_vivas.validation.validadordireccion.ValidadorDireccion;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DireccionDeleteService {

    private final DireccionRepository direccionRepository;
    private final ValidadorDireccion validadorDireccion;

    public void eliminarDireccion(Long idDireccion) throws ResourceNotFoundException {

        validadorDireccion.validarIdDireccion(idDireccion);

        direccionRepository.deleteById(idDireccion);

    }
}
