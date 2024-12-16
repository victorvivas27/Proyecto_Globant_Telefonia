package com.telefonia_vivas.repository;

import com.telefonia_vivas.entity.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {

    @Modifying
    @Query("DELETE FROM Direccion d WHERE d.id = :idDireccion")
    void deleteById(@Param("idDireccion") Long idDireccion);
}
