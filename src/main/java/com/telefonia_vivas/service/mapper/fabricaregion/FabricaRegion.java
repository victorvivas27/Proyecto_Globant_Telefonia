package com.telefonia_vivas.service.mapper.fabricaregion;

import com.telefonia_vivas.dto.entrada.RegionDtoEntrada;
import com.telefonia_vivas.dto.modificar.RegionDtoModificar;
import com.telefonia_vivas.entity.Region;
import org.springframework.stereotype.Component;

@Component
public class FabricaRegion {
    /**
     * Crea una nueva instancia de Region a partir de RegionDtoEntrada.
     *
     * @param regionDtoEntrada DTO de entrada para crear una región.
     * @return Una nueva instancia de Region.
     */
    public Region regionCrear(RegionDtoEntrada regionDtoEntrada) {
        Region region = new Region();
        region.setNombreRegion(regionDtoEntrada.getNombreRegion());
        return region;
    }

    /**
     * Modifica una instancia de Region existente a partir de RegionDtoModificar.
     *
     * @param regionDtoModificar DTO para modificar una región existente.
     * @param regionExistente    Instancia de Region existente a modificar.
     * @return La instancia modificada de Region.
     */
    public Region regionModificar(
            RegionDtoModificar regionDtoModificar, Region regionExistente) {
        regionExistente.setNombreRegion(regionDtoModificar.getNombreRegion());

        return regionExistente;
    }
}
