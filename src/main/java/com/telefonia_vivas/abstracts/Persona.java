package com.telefonia_vivas.abstracts;

import com.telefonia_vivas.constants.ConstanteCliente;
import com.telefonia_vivas.entity.Direccion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Persona {
    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(length = 15, nullable = false, unique = true)
    private String run;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = ConstanteCliente.DIRECCION_ID, nullable = false)
    private Direccion direccion;
}
