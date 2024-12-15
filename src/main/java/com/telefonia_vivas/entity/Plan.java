package com.telefonia_vivas.entity;

import com.telefonia_vivas.constants.ConstantePlan;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ConstantePlan.PLANES)
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlan;

    @Column(length = 100, nullable = false)
    private Double precio;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = ConstantePlan.PLAN_SERVICIOS,
            joinColumns = @JoinColumn(name = ConstantePlan.PLAN_ID),
            inverseJoinColumns = @JoinColumn(name = ConstantePlan.SERVICIO_ID)
    )
    private Set<Servicio> servicios;

    @OneToMany(mappedBy = ConstantePlan.PLAN, cascade = CascadeType.ALL)
    private Set<Contrato> contratos;

}
