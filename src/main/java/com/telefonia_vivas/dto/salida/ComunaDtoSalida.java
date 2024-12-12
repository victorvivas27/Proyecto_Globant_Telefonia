package com.telefonia_vivas.dto.salida;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComunaDtoSalida {

    private Long idComuna;

    private String nombreComuna;

    private RegionDtoSalida region;

}
