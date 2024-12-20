package com.telefonia_vivas.mapper.mapperegion;

import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegionListService {

    private final ModelMapper modelMapper;
    private final RegionRepository regionRepository;

    public List<RegionDtoSalida> listarRegios() {
        List<Region> regions = regionRepository.findAll();

        return regions.stream()
                .map(region -> modelMapper.map(region, RegionDtoSalida.class))
                .toList();
    }
}
