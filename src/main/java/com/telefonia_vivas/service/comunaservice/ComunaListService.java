package com.telefonia_vivas.service.comunaservice;

import com.telefonia_vivas.dto.salida.ComunaDtoSalida;
import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.repository.ComunaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComunaListService {

    private final ComunaRepository comunaRepository;
    private final ModelMapper modelMapper;

    public List<ComunaDtoSalida> listarComunas() {
        List<Comuna> comunas = comunaRepository.findAll();

        return comunas.stream()
                .map(comuna -> modelMapper.map(comuna, ComunaDtoSalida.class))
                .toList();
    }
}
