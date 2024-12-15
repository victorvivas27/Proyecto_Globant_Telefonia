package com.telefonia_vivas.service.servicioservice;

import com.telefonia_vivas.dto.salida.ServicioDtoSalida;
import com.telefonia_vivas.entity.Servicio;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ServicioRepository;
import com.telefonia_vivas.service.validation.validadorservicio.ValidadorServicio;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServicioGetByIdService {

    private final ModelMapper modelMapper;
    private final ServicioRepository servicioRepository;
    private final ValidadorServicio validadorServicio;


    public ServicioDtoSalida obtenerServicioPorId(Long idServicio) throws ResourceNotFoundException {
        validadorServicio.validarIdServicio(idServicio);

        Servicio servicio = servicioRepository.findById(idServicio).orElse(null);


        return modelMapper.map(servicio, ServicioDtoSalida.class);
    }
}
