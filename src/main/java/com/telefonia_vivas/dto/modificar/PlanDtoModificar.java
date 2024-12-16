package com.telefonia_vivas.dto.modificar;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlanDtoModificar {

    @NotNull(message = "{validation.plan.idPlan.not_null}")
    private Long idPlan;

    @NotNull(message = "{validation.plan.nombrePlan.not_null}")
    @Size(min = 2, max = 50, message = "{validation.plan.nombrePlan.size}")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$", message = "{validation.plan.nombrePlan.pattern}")
    private String nombrePlan;

    @NotNull(message = "{validation.plan.precio.not_null}")
    @DecimalMin(value = "0.0", inclusive = false, message = "{validation.plan.precio.decimal_min}")
    @Digits(integer = 10, fraction = 2, message = "{validation.plan.precio.digits}")
    private Double precio;
}
