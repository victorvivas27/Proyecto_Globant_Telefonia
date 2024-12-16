package com.telefonia_vivas.service.validation.validadorregio;

import com.telefonia_vivas.constants.ConstanteRegion;
import com.telefonia_vivas.dto.modificar.RegionDtoModificar;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.NombreExistenteException;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ValidadorRegion {

    private final RegionRepository regionRepository;

    public void validateNombreRegion(String nombreRegion) {
        if (nombreRegion == null || nombreRegion.isBlank()) {
            throw new IllegalArgumentException(ConstanteRegion.NOMBRE_REGION_NOT_NULL);
        }
        if (regionRepository.existsByNombreRegion(nombreRegion)) {
            throw new NombreExistenteException(ConstanteRegion.NOMBRE_EXISTE);
        }
    }


    public Region validarIdRegion(Long idRegion) throws ResourceNotFoundException {
        if (idRegion == null) {
            throw new IllegalArgumentException(ConstanteRegion.REGION_Id_NOT_NULL);
        }
        return regionRepository.findById(idRegion)
                .orElseThrow(() -> new ResourceNotFoundException(ConstanteRegion.ID_REGION_NO_EXISTE + idRegion));
    }


    public void validateRegionDtoModificar(RegionDtoModificar regionDtoModificar) throws ResourceNotFoundException {
        validateNombreRegion(regionDtoModificar.getNombreRegion());
        validarIdRegion(regionDtoModificar.getIdRegion());
    }
}
