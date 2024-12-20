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
public class EstadoDtoEntrada {

    @NotNull(message = "{validation.estado.nombreEstado.not_null}")
    @Size(min = 2, max = 50, message = "{validation.estado.nombreEstado.size}")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$", message = "{validation.estado.nombreEstado.pattern}")
    private String nombreEstado;


}
