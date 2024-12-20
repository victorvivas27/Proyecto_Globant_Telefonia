package com.telefonia_vivas.factory.servicioservice;

import com.telefonia_vivas.constants.ConstanteServicio;
import com.telefonia_vivas.dto.modificar.ServicioDtoModificar;
import com.telefonia_vivas.dto.salida.ServicioDtoSalida;
import com.telefonia_vivas.entity.Servicio;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.mapper.mapperservicio.FabricaSalidaServicio;
import com.telefonia_vivas.mapper.mapperservicio.FabricaServicio;
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
    private final FabricaServicio fabricaServicio;
    private final FabricaSalidaServicio fabricaSalidaServicio;

    public ServicioDtoSalida actualizarServicio(ServicioDtoModificar servicioDtoModificar) throws ResourceNotFoundException {
        validadorServicio.validateServicioDtoModificar(servicioDtoModificar);

        Servicio servicioExistente = servicioRepository.findById(servicioDtoModificar.getIdServicio())
                .orElseThrow(() -> new ResourceNotFoundException(
                        ConstanteServicio.ID_SERVICIO_NO_EXISTE + servicioDtoModificar.getIdServicio()));

        servicioExistente = fabricaServicio.servicioModificar(servicioDtoModificar, servicioExistente);

        Servicio servicioSave = servicioRepository.save(servicioExistente);

        return fabricaSalidaServicio.construirServicioDto(servicioSave);
    }
}
