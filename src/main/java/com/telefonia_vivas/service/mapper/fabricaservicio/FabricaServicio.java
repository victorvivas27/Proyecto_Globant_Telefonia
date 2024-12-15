package com.telefonia_vivas.service.mapper.fabricaservicio;

import com.telefonia_vivas.dto.entrada.ServicioDtoEntrada;
import com.telefonia_vivas.entity.Servicio;
import org.springframework.stereotype.Component;

@Component
public class FabricaServicio {

    public Servicio servicioCrear(ServicioDtoEntrada servicioDtoEntrada) {
        Servicio servicio = new Servicio();
        servicio.setNombreServicio(servicioDtoEntrada.getNombreServicio());
        servicio.setDescripcion(servicioDtoEntrada.getDescripcion());
        return servicio;
    }
}
