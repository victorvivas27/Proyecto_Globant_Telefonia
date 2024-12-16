package com.telefonia_vivas.service.direccionservice;

import com.telefonia_vivas.dto.entrada.DireccionDtoEntrada;
import com.telefonia_vivas.dto.entrada.RegionDtoEntrada;
import com.telefonia_vivas.dto.salida.DireccionDtoSalida;
import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.entity.Direccion;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ComunaRepository;
import com.telefonia_vivas.repository.DireccionRepository;
import com.telefonia_vivas.repository.RegionRepository;
import com.telefonia_vivas.service.mapper.fabricadireccion.FabricaDireccion;
import com.telefonia_vivas.service.mapper.fabricadireccion.FabricaSalidaDireccion;
import com.telefonia_vivas.service.mapper.fabricaregion.FabricaRegion;
import com.telefonia_vivas.service.mapper.fabricaregion.FabricaSalidaRegion;
import com.telefonia_vivas.service.validation.validadorcomuna.ValidadorComuna;
import com.telefonia_vivas.service.validation.validadorregio.ValidadorRegion;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DireccionCrationService {

    private final ModelMapper modelMapper;
    private final DireccionRepository direccionRepository;
    private final FabricaDireccion fabricaDireccion;
    private final FabricaSalidaDireccion fabricaSalidaDireccion;
    private final ComunaRepository comunaRepository;  // Asegúrate de inyectarlo
    private final RegionRepository regionRepository;  // Asegúrate de inyectarlo

    public DireccionDtoSalida crearDireccion(DireccionDtoEntrada direccionDtoEntrada)
            throws ResourceNotFoundException {


        Comuna comuna = comunaRepository.findById(direccionDtoEntrada.getIdComuna())
                .orElseThrow(() -> new ResourceNotFoundException("Comuna no encontrada"));


        Region region = regionRepository.findById(direccionDtoEntrada.getIdRegion())
                .orElseThrow(() -> new ResourceNotFoundException("Región no encontrada"));

        // Crear la dirección con los datos validados
        Direccion direccionCrear = fabricaDireccion.direccionCrear(direccionDtoEntrada, region, comuna);

        // Guardar la dirección en la base de datos
        Direccion direccionSave = direccionRepository.save(direccionCrear);

        // Construir y devolver el DTO de salida
        return fabricaSalidaDireccion.construirDireccionDto(direccionSave);
    }


}
