package com.telefonia_vivas.factory.direccionservice;

import com.telefonia_vivas.dto.salida.DireccionDtoSalida;
import com.telefonia_vivas.entity.Direccion;
import com.telefonia_vivas.repository.DireccionRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DiteccionListService {

    private final DireccionRepository direccionRepository;
    private final ModelMapper modelMapper;

    public List<DireccionDtoSalida> listarDireccion() {
        List<Direccion> direcciones = direccionRepository.findAll();

        return direcciones.stream()
                .map(direccion -> modelMapper.map(direccion, DireccionDtoSalida.class))
                .toList();
    }
}
