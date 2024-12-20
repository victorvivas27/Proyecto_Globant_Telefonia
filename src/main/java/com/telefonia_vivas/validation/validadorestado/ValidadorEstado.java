package com.telefonia_vivas.validation.validadorestado;

import com.telefonia_vivas.dto.entrada.EstadoDtoEntrada;
import com.telefonia_vivas.entity.Estado;
import com.telefonia_vivas.exception.NombreExistenteException;
import com.telefonia_vivas.repository.EstadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidadorEstado {

    private EstadoRepository estadoRepository;

    public void validarNombreEstado (String estadoNombre){

        boolean existeEstado = estadoRepository.existsByNombreEstado(estadoNombre);

        if (existeEstado) {
            throw new NombreExistenteException(
                    "El estado con nombre '" + estadoNombre + "' ya existe.");
        }
    }
}
