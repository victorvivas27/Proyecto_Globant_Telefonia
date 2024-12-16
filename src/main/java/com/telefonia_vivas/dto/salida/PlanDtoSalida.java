package com.telefonia_vivas.dto.salida;

import com.telefonia_vivas.entity.Servicio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanDtoSalida {

    private Long idPlan;

    private String nombrePlan;

    private Double precio;

    private Set<Servicio> servicios;


}
