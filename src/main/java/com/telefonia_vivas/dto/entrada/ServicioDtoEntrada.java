package com.telefonia_vivas.dto.entrada;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServicioDtoEntrada {

    @NotNull(message = "{validation.servicio.nombreServicio.not_null}")
    @Size(min = 2, max = 50, message = "{validation.servicio.nombreServicio.size}")
    //@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$", message = "{validation.servicio.nombreServicio.pattern}")
    private String nombreServicio;

    @NotNull(message = "{validation.servicio.descripcion.not_null}")
    @Size(min = 2, max = 50, message = "{validation.servicio.descripcion.size}")
    //@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$", message = "{validation.servicio.descripcion.pattern}")
    private String descripcion;
}