package com.telefonia_vivas.dto.modificar;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DireccionDtoModificar {

    @NotNull(message = "{validation.direccion.idDireccion.not_null}")
    private Long idDireccion;

    @NotNull(message = "{validation.direccion.calle.not_null}")
    @Size(min = 3, max = 100, message = "{validation.direccion.calle.size}")
    private String calle;

    @NotNull(message = "{validation.direccion.numero.not_null}")
    @Pattern(regexp = "^\\d+$", message = "{validation.direccion.numero.pattern}")
    private String numero;



}
