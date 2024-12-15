package com.telefonia_vivas.service.servicioservice;

import com.telefonia_vivas.dto.salida.ServicioDtoSalida;
import com.telefonia_vivas.entity.Servicio;
import com.telefonia_vivas.repository.ServicioRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioListService {

    private final ServicioRepository servicioRepository;
    private final ModelMapper modelMapper;

    public List<ServicioDtoSalida> listarServicio() {
        List<Servicio> servicios = servicioRepository.findAll();

        return servicios.stream()
                .map(servicio -> modelMapper.map(servicio, ServicioDtoSalida.class))
                .toList();
    }
}
