package com.telefonia_vivas.factory.estadoservice;

import com.telefonia_vivas.dto.entrada.EstadoDtoEntrada;
import com.telefonia_vivas.dto.salida.EstadoDtoSalida;
import com.telefonia_vivas.entity.Estado;
import com.telefonia_vivas.exception.NombreExistenteException;
import com.telefonia_vivas.repository.EstadoRepository;
import com.telefonia_vivas.validation.validadorestado.ValidadorEstado;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class EstadoCrationService {

    private final EstadoRepository estadoRepository;
    private  final ValidadorEstado validadorEstado;

    public EstadoDtoSalida crearEstado(EstadoDtoEntrada estadoDtoEntrada) {

       validadorEstado.validarNombreEstado(estadoDtoEntrada.getNombreEstado());


        Estado estado = Estado.builder()
                .nombreEstado(estadoDtoEntrada.getNombreEstado())
                .build();


        Estado estadoGuardado = estadoRepository.save(estado);


        return EstadoDtoSalida.builder()
                .idEstado(estadoGuardado.getIdEstado())
                .nombreEstado(estadoGuardado.getNombreEstado())
                .build();
    }
}
