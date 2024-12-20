package com.telefonia_vivas.mapper.mapperservicio;

import com.telefonia_vivas.constants.ConstanteServicio;
import com.telefonia_vivas.dto.modificar.ServicioDtoModificar;
import com.telefonia_vivas.dto.salida.ServicioDtoSalida;
import com.telefonia_vivas.entity.Servicio;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ServicioRepository;
import com.telefonia_vivas.validation.validadorservicio.ValidadorServicio;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ServicioUpdateService {

    private final ModelMapper modelMapper;
    private final ServicioRepository servicioRepository;
    private final ValidadorServicio validadorServicio;

    public ServicioDtoSalida actualizarServicio(ServicioDtoModificar servicioDtoModificar)
            throws ResourceNotFoundException {

       Servicio servicioExistente =  validadorServicio.validarIdServicio(
               servicioDtoModificar.getIdServicio());

       // Validar nombre si fue modificado
        if (!servicioExistente.getNombreServicio().equals(servicioDtoModificar.getNombreServicio())) {
            validadorServicio.validarNombreComunaParaModificacion(
                    servicioDtoModificar.getNombreServicio(),
                    servicioDtoModificar.getIdServicio()
            );
        }

       modelMapper.map(servicioDtoModificar, servicioExistente);

        Servicio servicioSave = servicioRepository.save(servicioExistente);

        return modelMapper.map(servicioSave, ServicioDtoSalida.class);
    }
}
