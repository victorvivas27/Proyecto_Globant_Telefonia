package com.telefonia_vivas.entity;

import com.telefonia_vivas.constants.ConstanteRegion;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ConstanteRegion.REGIONES)
public class Region {

    @OneToMany(
            mappedBy = ConstanteRegion.REGION,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    final private Set<Comuna> comunas = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegion;

    @Column(length = 100, nullable = false, unique = true)
    private String nombreRegion;


}
