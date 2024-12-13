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
public class RegionDtoModificar {

    @NotNull(message = "{validation.comuna.idRegion.not_null}")
    private Long idRegion;

    @NotNull(message = "{validation.region.nombreRegion.not_null}")
    @Size(min = 2, max = 50, message = "{validation.region.nombreRegion.size}")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$", message = "{validation.region.nombreRegion.pattern}")
    private String nombreRegion;
}
