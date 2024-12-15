package com.telefonia_vivas.repository;

import com.telefonia_vivas.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {

    boolean existsByNombreServicio(String nombreServicio);

    @Modifying
    @Query("DELETE FROM Servicio s WHERE s.id = :idServicio")
    void deleteById(@Param("idServicio") Long idServicio);
}
