package com.telefonia_vivas.dto.salida;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServicioDtoSalida {

    private Long idServicio;

    private String nombreServicio;

    private String descripcion;
}
