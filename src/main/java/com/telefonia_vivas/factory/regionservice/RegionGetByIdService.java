package com.telefonia_vivas.factory.regionservice;

import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.RegionRepository;
import com.telefonia_vivas.validation.validadorregio.ValidadorRegion;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegionGetByIdService {

    private final ModelMapper modelMapper;
    private final RegionRepository regionRepository;
    private final ValidadorRegion validadorRegion;


    public RegionDtoSalida obtenerRegionPorId(Long idRegion) throws ResourceNotFoundException {

        validadorRegion.validarIdRegion(idRegion);

        Region region = regionRepository.findById(idRegion).orElse(null);


        return modelMapper.map(region, RegionDtoSalida.class);
    }
}
