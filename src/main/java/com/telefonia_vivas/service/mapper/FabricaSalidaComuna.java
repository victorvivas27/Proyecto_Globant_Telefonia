package com.telefonia_vivas.service.mapper;

import com.telefonia_vivas.dto.salida.ComunaDtoSalida;
import com.telefonia_vivas.entity.Comuna;
import org.springframework.stereotype.Component;

@Component
public class FabricaSalidaComuna {

    public ComunaDtoSalida construirComunaDto(Comuna comuna) {

        ComunaDtoSalida comunaDtoSalida = new ComunaDtoSalida();

        comunaDtoSalida.setIdComuna(comuna.getIdComuna());

        comunaDtoSalida.setNombreComuna(comuna.getNombreComuna());

        return comunaDtoSalida;
    }
}
