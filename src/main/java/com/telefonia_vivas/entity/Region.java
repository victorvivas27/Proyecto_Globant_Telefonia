package com.telefonia_vivas.entity;

import com.telefonia_vivas.constants.ConstanteRegion;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column(name = ConstanteRegion.NOMBRE_REGION, length = 100, nullable = false, unique = true)
    private String nombreRegion;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Comuna> comunas = new HashSet<>();


}
