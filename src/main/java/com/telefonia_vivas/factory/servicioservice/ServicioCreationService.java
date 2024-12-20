package com.telefonia_vivas.factory.servicioservice;

import com.telefonia_vivas.dto.entrada.ServicioDtoEntrada;
import com.telefonia_vivas.dto.salida.ServicioDtoSalida;
import com.telefonia_vivas.entity.Servicio;
import com.telefonia_vivas.mapper.mapperservicio.FabricaSalidaServicio;
import com.telefonia_vivas.mapper.mapperservicio.FabricaServicio;
import com.telefonia_vivas.repository.ServicioRepository;
import com.telefonia_vivas.validation.validadorservicio.ValidadorServicio;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ServicioCreationService {
    private final ServicioRepository servicioDtoRepository;
    private final ValidadorServicio validadorServicio;
    private final FabricaServicio fabricaServicio;
    private final FabricaSalidaServicio fabricaSalidaServicio;

    public ServicioDtoSalida crearServicio(ServicioDtoEntrada servicioDtoEntrada) {

        validadorServicio.validateNombreServicio(servicioDtoEntrada.getNombreServicio());

        Servicio servicio = fabricaServicio.servicioCrear(servicioDtoEntrada);

        Servicio servicioSave = servicioDtoRepository.save(servicio);

        return fabricaSalidaServicio.construirServicioDto(servicioSave);
    }
}
