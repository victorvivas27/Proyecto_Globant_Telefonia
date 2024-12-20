package com.telefonia_vivas.mapper.mapperestado;

import com.telefonia_vivas.dto.entrada.EstadoDtoEntrada;
import com.telefonia_vivas.dto.salida.EstadoDtoSalida;
import com.telefonia_vivas.entity.Estado;
import com.telefonia_vivas.repository.EstadoRepository;
import com.telefonia_vivas.validation.validadorestado.ValidadorEstado;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class EstadoCrationService {

    private final EstadoRepository estadoRepository;
    private final ValidadorEstado validadorEstado;
    private final ModelMapper modelMapper;

    public EstadoDtoSalida crearEstado(EstadoDtoEntrada estadoDtoEntrada) {

        validadorEstado.validarNombreEstado(estadoDtoEntrada.getNombreEstado());

        estadoDtoEntrada.setNombreEstado(estadoDtoEntrada.getNombreEstado().toUpperCase());

        Estado estado = modelMapper.map(estadoDtoEntrada, Estado.class);

        Estado estadoGuardado = estadoRepository.save(estado);

        return modelMapper.map(estadoGuardado, EstadoDtoSalida.class);
    }
}
