package com.telefonia_vivas.validation.validadorcomuna;

import com.telefonia_vivas.constants.ConstanteComuna;
import com.telefonia_vivas.dto.modificar.ComunaDtoModificar;
import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.exception.NombreExistenteException;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ComunaRepository;
import com.telefonia_vivas.repository.RegionRepository;
import com.telefonia_vivas.validation.validadorregio.ValidadorRegion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidadorComuna {

    private final ComunaRepository comunaRepository;
    private final RegionRepository regionRepository;
    private final ValidadorRegion validadorRegion;

    // Valida y obtiene una comuna por su ID
    public Comuna validarYObtenerComunaPorId(Long idComuna) throws ResourceNotFoundException {
        if (idComuna == null) {
            throw new IllegalArgumentException(ConstanteComuna.ID_COMUNA_NO_EXISTE);
        }
        return comunaRepository.findById(idComuna)
                .orElseThrow(() -> new ResourceNotFoundException(ConstanteComuna.ID_COMUNA_NO_EXISTE + idComuna));
    }

    // Valida que el nombre de la comuna sea único para nuevas comunas
    public void validateNombreComuna(String nombreComuna) {
        if (comunaRepository.existsByNombreComuna(nombreComuna)) {
            throw new NombreExistenteException(ConstanteComuna.NOMBRE_EXISTE);
        }
    }

    // Valida que el nombre de la comuna sea único al modificar
    public void validarNombreComunaParaModificacion(String nombreComuna, Long idComuna) {
        if (comunaRepository.existsByNombreComunaAndIdComunaNot(nombreComuna, idComuna)) {
            throw new NombreExistenteException(ConstanteComuna.NOMBRE_EXISTE);
        }
    }
}
