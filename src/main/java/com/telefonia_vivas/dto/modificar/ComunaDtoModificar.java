package com.telefonia_vivas.dto.modificar;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComunaDtoModificar {

    @NotNull(message = "{validation.comuna.idComuna.not_null}")
    private Long idComuna;

    @NotNull(message = "{validation.comuna.nombreComuna.not_null}")
    @Size(min = 2, max = 50, message = "{validation.comuna.nombreComuna.size}")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$", message = "{validation.comuna.nombreComuna.pattern}")
    private String nombreComuna;
}
