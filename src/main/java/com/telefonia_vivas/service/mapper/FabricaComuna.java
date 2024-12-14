package com.telefonia_vivas.service.mapper;

import com.telefonia_vivas.dto.entrada.ComunaDtoEntrada;
import com.telefonia_vivas.dto.modificar.ComunaDtoModificar;
import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.entity.Region;
import org.springframework.stereotype.Component;


@Component
public class FabricaComuna {

    public Comuna comunaAgregar(ComunaDtoEntrada comunaDtoEntrada, Region region) {

        Comuna comuna = new Comuna();

        comuna.setNombreComuna(comunaDtoEntrada.getNombreComuna());

        comuna.setRegion(region);

        return comuna;
    }

    public Comuna comunaModificar(ComunaDtoModificar comunaDtoModificar, Comuna comunaExistente) {

        comunaExistente.setNombreComuna(comunaDtoModificar.getNombreComuna());

        return comunaExistente;
    }
}
