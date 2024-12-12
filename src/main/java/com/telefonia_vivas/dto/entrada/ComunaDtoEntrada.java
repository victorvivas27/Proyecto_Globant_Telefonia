package com.telefonia_vivas.dto.entrada;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComunaDtoEntrada {

    @NotNull(message = "{validation.comuna.nombreComuna.not_null}")
    @Size(min = 2, max = 50, message = "{validation.comuna.nombreComuna.size}")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$", message = "{validation.comuna.nombreComuna.pattern}")
    private String nombreComuna;

    @NotNull(message = "{validation.comuna.idRegion.not_null}")
    private Long idRegion;

}
