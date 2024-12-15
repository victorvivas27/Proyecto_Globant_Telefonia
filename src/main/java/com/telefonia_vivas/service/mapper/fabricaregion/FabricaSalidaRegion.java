package com.telefonia_vivas.service.mapper.fabricaregion;

import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.entity.Region;
import org.springframework.stereotype.Component;

@Component
public class FabricaSalidaRegion {

    public RegionDtoSalida construirRegionDto(Region region) {

        RegionDtoSalida regionDtoSalida = new RegionDtoSalida();

        regionDtoSalida.setIdRegion(region.getIdRegion());

        regionDtoSalida.setNombreRegion(region.getNombreRegion());

        return regionDtoSalida;
    }
}
