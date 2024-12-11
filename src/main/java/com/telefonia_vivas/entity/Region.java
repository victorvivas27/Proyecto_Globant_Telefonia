package com.telefonia_vivas.entity;

import com.telefonia_vivas.constants.ConstanteRegion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ConstanteRegion.REGIONES)
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegion;

    @Column(name = ConstanteRegion.NOMBRE, length = 100, nullable = false)
    private String nombre;
}
