package com.telefonia_vivas.mapper.mapperservicio;

import com.telefonia_vivas.dto.salida.ServicioDtoSalida;
import com.telefonia_vivas.entity.Servicio;
import org.springframework.stereotype.Component;

@Component
public class FabricaSalidaServicio {


    public ServicioDtoSalida construirServicioDto(Servicio servicio) {

        ServicioDtoSalida servicioDtoSalida = new ServicioDtoSalida();

        servicioDtoSalida.setIdServicio(servicio.getIdServicio());

        servicioDtoSalida.setNombreServicio(servicio.getNombreServicio());

        servicioDtoSalida.setDescripcion(servicio.getDescripcion());

        return servicioDtoSalida;
    }
}
