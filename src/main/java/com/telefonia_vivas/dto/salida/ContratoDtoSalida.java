package com.telefonia_vivas.dto.salida;

import com.telefonia_vivas.entity.Estado;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContratoDtoSalida {

    private Long idContrato;

    private Long idCliente;

    private Long idPlan;

    private Estado estado;


}
