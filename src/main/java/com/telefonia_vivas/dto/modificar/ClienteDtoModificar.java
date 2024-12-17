package com.telefonia_vivas.dto.modificar;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDtoModificar {

    @NotNull(message = "{validation.persona.idCliente.not_null}")
    private Long idCliente;

    @NotNull(message = "{validation.persona.nombre.not_null}")
    @Size(min = 2, max = 50, message = "{validation.persona.nombre.size}")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$", message = "{validation.persona.nombre.pattern}")
    private String nombre;

    @NotNull(message = "{validation.persona.fechaNacimiento.not_null}")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    @NotNull(message = "{validation.persona.run.not_null}")
    @Size(min = 9, max = 9, message = "{validation.persona.run.size}")
    private String run;
}
