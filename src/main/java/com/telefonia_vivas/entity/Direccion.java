package com.telefonia_vivas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(length = 100, nullable = false)
    private String calle;

    @Column(nullable = false)
    private String numero;

    @ManyToOne(optional = false)
    @JoinColumn(name = ConstanteDireccion.REGION_ID)
    @JsonBackReference
    private Region region;

    @ManyToOne(optional = false)
    @JoinColumn(name = ConstanteDireccion.COMUNA_ID)
    @JsonBackReference
    private Comuna comuna;
}
