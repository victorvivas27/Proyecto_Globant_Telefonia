package com.telefonia_vivas.repository;

import com.telefonia_vivas.entity.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ComunaRepository extends JpaRepository<Comuna, Long> {

    boolean existsByNombreComuna(String nombreComuna);

    @Modifying
    @Query("DELETE FROM Comuna c WHERE c.id = :idComuna")
    void deleteById(@Param("idComuna") Long idComuna);

    boolean existsByNombreComunaAndIdComunaNot(String nombreComuna, Long idComuna);
}
