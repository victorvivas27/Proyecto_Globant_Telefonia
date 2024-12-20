package com.telefonia_vivas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.telefonia_vivas.constants.ConstanteComuna;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ConstanteComuna.COMUNAS)
public class Comuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComuna;

    @Column(name = ConstanteComuna.NOMBRE_COMUNA, length = 100, nullable = false, unique = true)
    private String nombreComuna;


    @ManyToOne
    @JoinColumn(name = "id_region")

    private Region region;

}
