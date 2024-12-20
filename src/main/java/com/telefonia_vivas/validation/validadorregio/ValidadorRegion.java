package com.telefonia_vivas.validation.validadorregio;

import com.telefonia_vivas.constants.ConstanteComuna;
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

        if (regionRepository.existsByNombreRegion(nombreRegion)) {
            throw new NombreExistenteException(ConstanteRegion.NOMBRE_EXISTE);
        }
    }


    public Region validarIdRegion(Long idRegion) throws ResourceNotFoundException {

        return regionRepository.findById(idRegion)
                .orElseThrow(() -> new ResourceNotFoundException(ConstanteRegion.ID_REGION_NO_EXISTE + idRegion));
    }


    public void validateNombreRegionModificacion(String nombreRegion, Long idRegion) {

        if (regionRepository.existsByNombreRegionAndIdRegionNot(nombreRegion, idRegion)) {
            throw new NombreExistenteException(ConstanteRegion.NOMBRE_EXISTE);
        }
    }

    // Valida que el nombre de la comuna sea único al modificar
    public void validarNombreComunaParaModificacion(String nombreComuna, Long idComuna) {
        if (regionRepository.existsByNombreRegionAndIdRegionNot(nombreComuna, idComuna)) {
            throw new NombreExistenteException(ConstanteRegion.NOMBRE_EXISTE);
        }
    }
}
