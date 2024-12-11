package com.telefonia_vivas.entity;

import com.telefonia_vivas.constants.ConstanteDireccion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ConstanteDireccion.DIRECCIONES)
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDireccion;

    @Column(name = ConstanteDireccion.CALLE, length = 100, nullable = false)
    private String calle;

    @Column(name = ConstanteDireccion.NUMERO, nullable = false)
    private String numero;

    @ManyToOne(optional = false)
    @JoinColumn(name = ConstanteDireccion.REGION_ID)
    private Region region;

    @ManyToOne(optional = false)
    @JoinColumn(name = ConstanteDireccion.COMUNA_ID)
    private Comuna comuna;
}
