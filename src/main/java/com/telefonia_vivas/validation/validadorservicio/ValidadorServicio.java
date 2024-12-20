package com.telefonia_vivas.validation.validadorservicio;

import com.telefonia_vivas.constants.ConstanteComuna;
import com.telefonia_vivas.constants.ConstanteServicio;
import com.telefonia_vivas.dto.modificar.ServicioDtoModificar;
import com.telefonia_vivas.entity.Servicio;
import com.telefonia_vivas.exception.NombreExistenteException;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ServicioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidadorServicio {

    private final ServicioRepository servicioRepository;

    public void validateNombreServicio(String nombreServicio) {

        if (servicioRepository.existsByNombreServicio(nombreServicio)) {
            throw new NombreExistenteException(ConstanteServicio.NOMBRE_EXISTE);
        }

    }

    public Servicio validarIdServicio(Long idServicio) throws ResourceNotFoundException {

        return servicioRepository.findById(idServicio)
                .orElseThrow(() -> new ResourceNotFoundException(
                        ConstanteServicio.ID_SERVICIO_NO_EXISTE + idServicio));
    }

    public void validateNombreServicioModificacion(String nombreServicio, Long idServicio) {

        if (servicioRepository.existsByNombreServicioAndIdServicioNot(nombreServicio, idServicio)) {
            throw new NombreExistenteException(ConstanteServicio.NOMBRE_EXISTE);
        }
    }

    // Valida que el nombre de la comuna sea único al modificar
    public void validarNombreComunaParaModificacion(String nombreServicio, Long idServicio) {
        if (servicioRepository.existsByNombreServicioAndIdServicioNot(nombreServicio, idServicio)) {
            throw new NombreExistenteException(ConstanteServicio.NOMBRE_EXISTE);
        }
    }
}
