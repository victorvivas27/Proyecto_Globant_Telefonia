package com.telefonia_vivas.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(length = 100, unique = true, nullable = false)
    private String nombrePlan;

    @Column(nullable = false)
    private Double precio;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinTable(
            name = ConstantePlan.PLAN_SERVICIOS,
            joinColumns = @JoinColumn(name = ConstantePlan.PLAN_ID),
            inverseJoinColumns = @JoinColumn(name = ConstantePlan.SERVICIO_ID)
    )
    private Set<Servicio> servicios;


}
