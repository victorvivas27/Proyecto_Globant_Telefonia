package com.telefonia_vivas.dto.salida;

import com.telefonia_vivas.entity.Contrato;
import com.telefonia_vivas.entity.Direccion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDtoSalida {

    private Long idCliente;

    private String nombre;

    private Date fechaNacimiento;

    private String run;

    private List<Contrato> contratos;

    private Direccion direccion;
}
