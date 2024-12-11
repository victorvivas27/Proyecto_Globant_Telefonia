package com.telefonia_vivas.entity;

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

    @Column(name = ConstanteComuna.NOMBRE, length = 100, nullable = false)
    private String nombre;

}
