package com.telefonia_vivas.service.mapper;

import com.telefonia_vivas.dto.entrada.RegionDtoEntrada;
import com.telefonia_vivas.entity.Region;
import org.springframework.stereotype.Component;

@Component
public class FabricaRegion {
    public Region regionCrear(RegionDtoEntrada regionDtoEntrada) {

        Region region = new Region();

        region.setNombreRegion(regionDtoEntrada.getNombreRegion());

        return region;
    }
}
