package com.telefonia_vivas.service.servicioservice;

import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ServicioRepository;
import com.telefonia_vivas.service.validation.validadorservicio.ValidadorServicio;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ServicioDeleteService {

    private final ModelMapper modelMapper;
    private final ServicioRepository servicioRepository;
    private final ValidadorServicio validadorServicio;

    public void eliminarServicio(Long idServicio) throws ResourceNotFoundException {

        validadorServicio.validarIdServicio(idServicio);

        servicioRepository.deleteById(idServicio);
    }
}
