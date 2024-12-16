package com.telefonia_vivas.service.mapper.fabricadireccion;

import com.telefonia_vivas.dto.entrada.DireccionDtoEntrada;
import com.telefonia_vivas.dto.modificar.DireccionDtoModificar;
import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.entity.Direccion;
import com.telefonia_vivas.entity.Region;
import org.springframework.stereotype.Component;

@Component
public class FabricaDireccion {

    public Direccion direccionCrear(DireccionDtoEntrada direccionDtoEntrada, Region region, Comuna comuna) {
        Direccion direccion = new Direccion();

        direccion.setCalle(direccionDtoEntrada.getCalle());
        direccion.setNumero(direccionDtoEntrada.getNumero());
        direccion.setRegion(region);
        direccion.setComuna(comuna);

        return direccion;
    }

    public Direccion direccionModificar(
            DireccionDtoModificar direccionDtoModificar, Direccion direccionExistente) {

        direccionExistente.setCalle(direccionDtoModificar.getCalle());
        direccionExistente.setNumero(direccionDtoModificar.getNumero());

        return direccionExistente;
    }
}
