package com.telefonia_vivas.entity;

import com.telefonia_vivas.constants.ConstanteServicio;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ConstanteServicio.SERVICIOS)
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicio;

    @Column(name = ConstanteServicio.NOMBRE, length = 100, nullable = false)
    private String nombre;

    @Column(name = ConstanteServicio.DESCRIPCION, length = 255)
    private String descripcion;


}
