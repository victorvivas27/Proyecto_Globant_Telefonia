package com.telefonia_vivas.repository;

import com.telefonia_vivas.entity.Contrato;
import com.telefonia_vivas.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

    List<Contrato> findByEstado(Estado estado);
}
