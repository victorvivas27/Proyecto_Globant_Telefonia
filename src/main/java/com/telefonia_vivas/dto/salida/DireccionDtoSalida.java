package com.telefonia_vivas.dto.salida;

import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.entity.Region;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DireccionDtoSalida {


    private Long idDireccion;


    private String calle;


    private String numero;


    private Region region;


    private Comuna comuna;
}
