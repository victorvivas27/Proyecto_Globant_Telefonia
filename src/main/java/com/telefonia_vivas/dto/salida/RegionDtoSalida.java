package com.telefonia_vivas.dto.salida;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegionDtoSalida {

    private Long idRegion;

    private String nombreRegion;

    private List<ComunaDtoSalida> comunas;

}
