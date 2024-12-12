package com.telefonia_vivas.repository;

import com.telefonia_vivas.entity.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComunaRepository extends JpaRepository<Comuna, Long> {

    boolean existsByNombreComuna(String nombreComuna);
}
