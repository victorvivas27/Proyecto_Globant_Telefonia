package com.telefonia_vivas.factory.comunaservice;

import com.telefonia_vivas.dto.salida.ComunaDtoSalida;
import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ComunaRepository;
import com.telefonia_vivas.validation.validadorcomuna.ValidadorComuna;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ComunaGetByIdService {

    private final ComunaRepository comunaRepository;
    private final ModelMapper modelMapper;
    private final ValidadorComuna validadorComuna;

    public ComunaDtoSalida obtenerComunaPorId(Long idComuna) throws ResourceNotFoundException {

        validadorComuna.validarIdComuna(idComuna);

        Comuna comuna = comunaRepository.findById(idComuna).orElse(null);


        return modelMapper.map(comuna, ComunaDtoSalida.class);
    }
}
