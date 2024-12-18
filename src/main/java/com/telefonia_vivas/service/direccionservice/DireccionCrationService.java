package com.telefonia_vivas.service.direccionservice;

import com.telefonia_vivas.dto.entrada.DireccionDtoEntrada;
import com.telefonia_vivas.dto.salida.DireccionDtoSalida;
import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.entity.Direccion;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.DireccionRepository;
import com.telefonia_vivas.service.mapper.fabricadireccion.FabricaDireccion;
import com.telefonia_vivas.service.mapper.fabricadireccion.FabricaSalidaDireccion;
import com.telefonia_vivas.service.validation.validadorcomuna.ValidadorComuna;
import com.telefonia_vivas.service.validation.validadorregio.ValidadorRegion;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DireccionCrationService {


    private final DireccionRepository direccionRepository;
    private final FabricaDireccion fabricaDireccion;
    private final FabricaSalidaDireccion fabricaSalidaDireccion;
    private final ValidadorRegion validadorRegion;
    private final ValidadorComuna validadorComuna;


    public DireccionDtoSalida crearDireccion(DireccionDtoEntrada direccionDtoEntrada)
            throws ResourceNotFoundException {

        Comuna comuna = validadorComuna.validarIdComuna(direccionDtoEntrada.getIdComuna());
        Region region = validadorRegion.validarIdRegion(direccionDtoEntrada.getIdRegion());


        Direccion direccionCrear = fabricaDireccion.direccionCrear(direccionDtoEntrada, region, comuna);


        Direccion direccionSave = direccionRepository.save(direccionCrear);


        return fabricaSalidaDireccion.construirDireccionDto(direccionSave);
    }


}