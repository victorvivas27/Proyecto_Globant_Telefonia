package com.telefonia_vivas.dto.salida;

import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.entity.Region;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DireccionDtoSalida {


    private Long idDireccion;


    private String calle;


    private String numero;


    private Region region;


    private Comuna comuna;
}
