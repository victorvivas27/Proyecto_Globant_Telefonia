package com.telefonia_vivas.dto.salida;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDtoSalida {

    private Long idCliente;

    private String nombre;

    private LocalDate fechaNacimiento;

    private String run;

    private DireccionDtoSalida direccion;
}
