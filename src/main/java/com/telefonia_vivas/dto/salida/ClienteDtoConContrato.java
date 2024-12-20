package com.telefonia_vivas.dto.salida;

import com.telefonia_vivas.entity.Contrato;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDtoConContrato {

    private Long idCliente;

    private String nombre;

    private LocalDate fechaNacimiento;

    private String run;

    private List<Contrato> contratos;

    private DireccionDtoSalida direccion;
}
