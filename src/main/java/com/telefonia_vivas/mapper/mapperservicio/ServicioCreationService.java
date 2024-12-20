package com.telefonia_vivas.mapper.mapperservicio;

import com.telefonia_vivas.dto.entrada.ServicioDtoEntrada;
import com.telefonia_vivas.dto.salida.ServicioDtoSalida;
import com.telefonia_vivas.entity.Servicio;
import com.telefonia_vivas.repository.ServicioRepository;
import com.telefonia_vivas.validation.validadorservicio.ValidadorServicio;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ServicioCreationService {

    private final ServicioRepository servicioDtoRepository;
    private final ValidadorServicio validadorServicio;
    private  final ModelMapper modelMapper;

    public ServicioDtoSalida crearServicio(ServicioDtoEntrada servicioDtoEntrada) {

        validadorServicio.validateNombreServicio(servicioDtoEntrada.getNombreServicio());

        Servicio servicio = modelMapper.map(servicioDtoEntrada,Servicio.class);

        Servicio servicioSave = servicioDtoRepository.save(servicio);

        return modelMapper.map(servicioSave, ServicioDtoSalida.class);
    }
}
