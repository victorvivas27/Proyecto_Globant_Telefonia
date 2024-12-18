package com.telefonia_vivas.dto.entrada;

import com.telefonia_vivas.entity.Estado;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContratoDtoEntrada {

    @NotNull(message = "{validation.cliente.contrato.not_null}")
    private Long idCliente;

    @NotNull(message = "{validation.plan.contrato.not_null}")
    private Long idPlan;

    @Valid
    @NotNull(message = "{validation.cliente.estado.contrato.not_null}")
    private Estado estado;
}
