package com.telefonia_vivas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.telefonia_vivas.constants.ConstanteContrato;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ConstanteContrato.CONTRATOS)
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrato;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = ConstanteContrato.CLIENTE_ID, nullable = false)
    @JsonBackReference
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = ConstanteContrato.PLAN_ID, nullable = false)
    private Plan plan;
}
