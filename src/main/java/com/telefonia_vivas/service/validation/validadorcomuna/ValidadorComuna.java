package com.telefonia_vivas.service.validation.validadorcomuna;

import com.telefonia_vivas.constants.ConstanteComuna;
import com.telefonia_vivas.dto.entrada.ComunaDtoEntrada;
import com.telefonia_vivas.dto.modificar.ComunaDtoModificar;
import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.NombreExistenteException;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ComunaRepository;
import com.telefonia_vivas.repository.RegionRepository;
import com.telefonia_vivas.service.validation.validadorregio.ValidadorRegion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidadorComuna {

    private final ComunaRepository comunaRepository;
    private final RegionRepository regionRepository;
    private final ValidadorRegion validadorRegion;

    public void validateNombreComuna(String nombreComuna) {
        if (nombreComuna == null || nombreComuna.isBlank()) {
            throw new IllegalArgumentException(ConstanteComuna.NOMBRE_COMUNA_NOT_NULL);
        }
        if (comunaRepository.existsByNombreComuna(nombreComuna)) {
            throw new NombreExistenteException(ConstanteComuna.NOMBRE_EXISTE);
        }
    }


    public Region validateComunaDto(ComunaDtoEntrada comunaDtoEntrada) throws ResourceNotFoundException {
        validateNombreComuna(comunaDtoEntrada.getNombreComuna());
        return validadorRegion.validarIdRegion(comunaDtoEntrada.getIdRegion());
    }


    public Comuna validarIdComuna(Long idComuna) throws ResourceNotFoundException {
        if (idComuna == null) {
            throw new IllegalArgumentException(ConstanteComuna.ID_COMUNA_NO_EXISTE);
        }
        return comunaRepository.findById(idComuna)
                .orElseThrow(() -> new ResourceNotFoundException(ConstanteComuna.ID_COMUNA_NO_EXISTE + idComuna));
    }

    public void validateComunaDtoModificar(ComunaDtoModificar comunaDtoModificar) throws ResourceNotFoundException {
        validateNombreComuna(comunaDtoModificar.getNombreComuna());
        validarIdComuna(comunaDtoModificar.getIdComuna());
    }
}
