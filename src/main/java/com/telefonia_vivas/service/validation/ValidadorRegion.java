package com.telefonia_vivas.service.validation;

import com.telefonia_vivas.constants.ConstanteRegion;
import com.telefonia_vivas.dto.entrada.RegionDtoEntrada;
import com.telefonia_vivas.dto.modificar.RegionDtoModificar;
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
     * Valida si el ID de una región es válido y existe en la base de datos.
     *
     * <p>Este método verifica que el ID proporcionado no sea nulo y que corresponda
     * a una región existente en el repositorio. Si el ID no cumple con estas condiciones,
     * se lanza una excepción personalizada {@link ResourceNotFoundException}.
     *
     * @param idRegion el ID de la región a validar.
     * @throws ResourceNotFoundException si el ID es nulo o no existe en la base de datos.
     */
    public void validarIdRegion(Long idRegion) throws ResourceNotFoundException {
        if (idRegion == null || !regionRepository.existsById(idRegion)) {
            throw new ResourceNotFoundException(ConstanteRegion.ID_REGION_NO_EXISTE + idRegion);
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


    /**
     * Validación principal de entrada de datos para la modificacion de una region.
     *
     * @param regionDtoModificar DTO de entrada.
     * @return Región válida asociada al ID de la región.
     * @throws IllegalArgumentException o ResourceNotFoundException si las validaciones fallan.
     */
    public void validateRegionDtoModificar(RegionDtoModificar regionDtoModificar) throws ResourceNotFoundException {
        validateNombreRegion(regionDtoModificar.getNombreRegion());
        validarIdRegion(regionDtoModificar.getIdRegion());
    }
}
