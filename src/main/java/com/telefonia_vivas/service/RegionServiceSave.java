package com.telefonia_vivas.service;

import com.telefonia_vivas.constants.ConstanteRegion;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.NombreExistenteException;
import com.telefonia_vivas.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegionServiceSave {
    private final RegionRepository regionRepository;
    private final ModelMapper modelMapper;

    public Region crearRegion(Region region) {

        String nombre = region.getNombreRegion();

        if (regionRepository.existsByNombreRegion(nombre)) {
            throw new NombreExistenteException(ConstanteRegion.REGION_EXISTE);

        }

        Region regionCreado = modelMapper.map(region, Region.class);

        return regionRepository.save(region);
    }
}
