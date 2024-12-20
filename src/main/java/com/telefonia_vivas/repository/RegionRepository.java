package com.telefonia_vivas.repository;

import com.telefonia_vivas.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    boolean existsByNombreRegion(String nombreRegion);

    boolean existsByNombreRegionAndIdRegionNot( String nombreRegion,Long idRegion);
}
