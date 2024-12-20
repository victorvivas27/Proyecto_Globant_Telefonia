package com.telefonia_vivas.mapper.mapperegion;

import com.telefonia_vivas.dto.entrada.RegionDtoEntrada;
import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.RegionRepository;
import com.telefonia_vivas.validation.validadorregio.ValidadorRegion;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class RegionCrationService {

    private final ModelMapper modelMapper;
    private final RegionRepository regionRepository;
    private final ValidadorRegion validadorRegion;


    public RegionDtoSalida crearRegion(RegionDtoEntrada regionDtoEntrada) throws ResourceNotFoundException {

        validadorRegion.validateNombreRegion(regionDtoEntrada.getNombreRegion());

        Region regionCrear = modelMapper.map(regionDtoEntrada, Region.class);

        Region regionSave = regionRepository.save(regionCrear);

        return modelMapper.map(regionSave, RegionDtoSalida.class);
    }
}
