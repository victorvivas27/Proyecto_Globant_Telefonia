package com.telefonia_vivas.service.validation.validadorcomuna;

import com.telefonia_vivas.constants.ConstanteComuna;
import com.telefonia_vivas.constants.ConstanteRegion;
import com.telefonia_vivas.dto.entrada.ComunaDtoEntrada;
import com.telefonia_vivas.dto.modificar.ComunaDtoModificar;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.NombreExistenteException;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ComunaRepository;
import com.telefonia_vivas.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidadorComuna {

    private final ComunaRepository comunaRepository;
    private final RegionRepository regionRepository;

    /**
     * Valida que el ID de la región no sea nulo y exista en la base de datos.
     *
     * @param idRegion ID de la región a validar.
     * @return Región encontrada.
     * @throws IllegalArgumentException  si el ID es nulo.
     * @throws ResourceNotFoundException si la región no existe.
     */
    public Region validateIdRegion(Long idRegion) throws ResourceNotFoundException {
        if (idRegion == null) {
            throw new IllegalArgumentException(ConstanteRegion.REGION_Id_NOT_NULL);
        }
        return regionRepository.findById(idRegion)
                .orElseThrow(() -> new ResourceNotFoundException(ConstanteRegion.ID_REGION_NO_EXISTE + idRegion));
    }


    /**
     * Valida que el nombre de la comuna no sea nulo y no exista en la base de datos.
     *
     * @param nombreComuna Nombre de la comuna a validar.
     * @throws IllegalArgumentException si el nombre es nulo o vacío.
     * @throws NombreExistenteException si el nombre ya existe.
     */
    public void validateNombreComuna(String nombreComuna) {
        if (nombreComuna == null || nombreComuna.isBlank()) {
            throw new IllegalArgumentException(ConstanteComuna.NOMBRE_COMUNA_NOT_NULL);
        }
        if (comunaRepository.existsByNombreComuna(nombreComuna)) {
            throw new NombreExistenteException(ConstanteComuna.NOMBRE_EXISTE);
        }
    }


    /**
     * Validación principal de entrada de datos para la creación de una comuna.
     *
     * @param comunaDtoEntrada DTO de entrada.
     * @return Región válida asociada al ID de la región.
     * @throws IllegalArgumentException o ResourceNotFoundException si las validaciones fallan.
     */
    public Region validateComunaDto(ComunaDtoEntrada comunaDtoEntrada) throws ResourceNotFoundException {
        validateNombreComuna(comunaDtoEntrada.getNombreComuna());
        return validateIdRegion(comunaDtoEntrada.getIdRegion());
    }


    public void validarIdComuna(Long idComuna) throws ResourceNotFoundException {

        if (idComuna == null || !comunaRepository.existsById(idComuna)) {
            throw new ResourceNotFoundException(ConstanteComuna.ID_COMUNA_NO_EXISTE + idComuna);
        }
    }

    public void validateComunaDtoModificar(ComunaDtoModificar comunaDtoModificar) throws ResourceNotFoundException {
        validateNombreComuna(comunaDtoModificar.getNombreComuna());
        validarIdComuna(comunaDtoModificar.getIdComuna());
    }
}
