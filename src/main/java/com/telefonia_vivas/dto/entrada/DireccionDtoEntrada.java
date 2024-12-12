package com.telefonia_vivas.dto.entrada;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DireccionDtoEntrada {

    @NotNull(message = "{validation.direccion.calle.not_null}")
    @Size(min = 3, max = 100, message = "{validation.direccion.calle.size}")
    private String calle;

    @NotNull(message = "{validation.direccion.numero.not_null}")
    @Pattern(regexp = "^\\d+$", message = "{validation.direccion.numero.pattern}")
    private String numero;

    @Valid
    @NotNull(message = "{validation.persona.direccion.region.not_null}")
    private RegionDtoEntrada region;

    @Valid
    @NotNull(message = "{validation.persona.direccion.comuna.not_null}")
    private ComunaDtoEntrada comuna;
}
