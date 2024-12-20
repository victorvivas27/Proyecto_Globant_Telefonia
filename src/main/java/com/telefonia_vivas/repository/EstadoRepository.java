package com.telefonia_vivas.repository;

import com.telefonia_vivas.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    boolean existsByNombreEstado(String nombreEstado);
}
