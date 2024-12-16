package com.telefonia_vivas.dto.modificar;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServicioDtoModificar {

    @NotNull(message = "{validation.servicio.idServicio.not_null}")
    private Long idServicio;

    @NotNull(message = "{validation.servicio.nombreServicio.not_null}")
    @Size(min = 2, max = 50, message = "{validation.servicio.nombreServicio.size}")
    //@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$", message = "{validation.servicio.nombreServicio.pattern}")
    private String nombreServicio;

    @NotNull(message = "{validation.servicio.nombreServicio.not_null}")
    @Size(min = 2, max = 50, message = "{validation.servicio.nombreServicio.size}")
    //@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$", message = "{validation.servicio.nombreServicio.pattern}")
    private String descripcion;
}
