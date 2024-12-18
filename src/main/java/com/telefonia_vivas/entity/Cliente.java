package com.telefonia_vivas.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.telefonia_vivas.abstracts.Persona;
import com.telefonia_vivas.constants.ConstanteCliente;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ConstanteCliente.CLIENTES)
public class Cliente extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @OneToMany(mappedBy = ConstanteCliente.CLIENTE,
            cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Contrato> contratos;

}
