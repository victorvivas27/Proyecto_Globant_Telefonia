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

    public void validateNombreComuna(String nombreComuna) {

        if (comunaRepository.existsByNombreComuna(nombreComuna)) {
            throw new NombreExistenteException(ConstanteComuna.NOMBRE_EXISTE);
        }
    }

    public Comuna validarIdComuna(Long idComuna) throws ResourceNotFoundException {
        if (idComuna == null) {
            throw new IllegalArgumentException(ConstanteComuna.ID_COMUNA_NO_EXISTE);
        }
        return comunaRepository.findById(idComuna)
                .orElseThrow(() -> new ResourceNotFoundException(ConstanteComuna.ID_COMUNA_NO_EXISTE + idComuna));
    }

    public void validateNombreComunaModificacion(String nombreComuna, Long idComuna) {

        if (comunaRepository.existsByNombreComunaAndIdComunaNot(nombreComuna, idComuna)) {
            throw new NombreExistenteException(ConstanteComuna.NOMBRE_EXISTE);
        }
    }

    public void validateComunaDtoModificar(ComunaDtoModificar comunaDtoModificar) throws ResourceNotFoundException {

        Comuna comunaExistente = validarIdComuna(comunaDtoModificar.getIdComuna());

        if (!comunaExistente.getNombreComuna().equals(comunaDtoModificar.getNombreComuna())) {
            validateNombreComunaModificacion(comunaDtoModificar.getNombreComuna(), comunaDtoModificar.getIdComuna());
        }
    }
}
