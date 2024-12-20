package com.telefonia_vivas.mapper.mapperdireccion;

import com.telefonia_vivas.dto.salida.DireccionDtoSalida;
import com.telefonia_vivas.entity.Direccion;
import org.springframework.stereotype.Component;

@Component
public class FabricaSalidaDireccion {

    public DireccionDtoSalida construirDireccionDto(Direccion direccion) {

        DireccionDtoSalida direccionDtoSalida = new DireccionDtoSalida();

        direccionDtoSalida.setIdDireccion(direccion.getIdDireccion());

        direccionDtoSalida.setCalle(direccion.getCalle());

        direccionDtoSalida.setNumero(direccion.getNumero());

        direccionDtoSalida.setRegion(direccion.getRegion());

        direccionDtoSalida.setComuna(direccion.getComuna());

        return direccionDtoSalida;
    }
}
