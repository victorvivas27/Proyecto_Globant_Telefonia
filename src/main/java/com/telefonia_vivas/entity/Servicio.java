package com.telefonia_vivas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.telefonia_vivas.constants.ConstanteServicio;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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
    private String nombreServicio;

    @Column(name = ConstanteServicio.DESCRIPCION, length = 255)
    private String descripcion;

    @ManyToMany(mappedBy = "servicios", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Plan> planes;
}
