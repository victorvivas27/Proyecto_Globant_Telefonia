package com.telefonia_vivas.service.validation;

import com.telefonia_vivas.constants.ConstanteRegion;
import com.telefonia_vivas.dto.entrada.RegionDtoEntrada;
import com.telefonia_vivas.exception.NombreExistenteException;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ValidadorRegion {
    private final RegionRepository regionRepository;


    /**
     * Valida que el nombre de la region no sea nulo y no exista en la base de datos.
     *
     * @param nombreRegion Nombre de la region a validar.
     * @throws IllegalArgumentException si el nombre es nulo o vacío.
     * @throws NombreExistenteException si el nombre ya existe.
     */
    public void validateNombreRegion(String nombreRegion) {
        if (nombreRegion == null || nombreRegion.isBlank()) {
            throw new IllegalArgumentException(ConstanteRegion.NOMBRE_REGION_NOT_NULL);
        }
        if (regionRepository.existsByNombreRegion(nombreRegion)) {
            throw new NombreExistenteException(ConstanteRegion.NOMBRE_EXISTE);
        }
    }

    /**
     * Validación principal de entrada de datos para la creación de una region.
     *
     * @param regionDtoEntrada DTO de entrada.
     * @return Región válida asociada al ID de la región.
     * @throws IllegalArgumentException o ResourceNotFoundException si las validaciones fallan.
     */
    public void validateRegionDto(RegionDtoEntrada regionDtoEntrada) throws ResourceNotFoundException {
        validateNombreRegion(regionDtoEntrada.getNombreRegion());
    }
}
