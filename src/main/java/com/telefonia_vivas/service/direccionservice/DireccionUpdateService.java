package com.telefonia_vivas.service.direccionservice;

import com.telefonia_vivas.constants.ConstanteDireccion;
import com.telefonia_vivas.dto.modificar.DireccionDtoModificar;
import com.telefonia_vivas.dto.salida.DireccionDtoSalida;
import com.telefonia_vivas.entity.Direccion;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.DireccionRepository;
import com.telefonia_vivas.service.mapper.fabricadireccion.FabricaDireccion;
import com.telefonia_vivas.service.mapper.fabricadireccion.FabricaSalidaDireccion;
import com.telefonia_vivas.service.validation.validadordireccion.ValidadorDireccion;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DireccionUpdateService {

    private final ModelMapper modelMapper;
    private final DireccionRepository direccionRepository;
    private final ValidadorDireccion validadorDireccion;
    private final FabricaDireccion fabricaDireccion;
    private final FabricaSalidaDireccion fabricaSalidaDireccion;

    public DireccionDtoSalida actualizarDireccion(DireccionDtoModificar direccionDtoModificar) throws ResourceNotFoundException {


        Direccion direccionExistente = direccionRepository.findById(direccionDtoModificar.getIdDireccion())
                .orElseThrow(() -> new ResourceNotFoundException(
                        ConstanteDireccion.ID_DIRECCION_NO_EXISTE + direccionDtoModificar.getIdDireccion()));

        direccionExistente = fabricaDireccion.direccionModificar(direccionDtoModificar, direccionExistente);

        Direccion direccionSave = direccionRepository.save(direccionExistente);

        return fabricaSalidaDireccion.construirDireccionDto(direccionSave);
    }
}
