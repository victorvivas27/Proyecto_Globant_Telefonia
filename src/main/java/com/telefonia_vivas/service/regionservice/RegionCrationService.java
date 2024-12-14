package com.telefonia_vivas.service.regionservice;

import com.telefonia_vivas.dto.entrada.RegionDtoEntrada;
import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.RegionRepository;
import com.telefonia_vivas.service.mapper.FabricaRegion;
import com.telefonia_vivas.service.mapper.FabricaSalidaRegion;
import com.telefonia_vivas.service.validation.ValidadorRegion;
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
    private final FabricaRegion fabricaRegion;
    private final FabricaSalidaRegion fabricaSalidaRegion;

    public RegionDtoSalida crearRegion(RegionDtoEntrada regionDtoEntrada) throws ResourceNotFoundException {

        validadorRegion.validateRegionDto(regionDtoEntrada);

        Region regionCrear = fabricaRegion.regionCrear(regionDtoEntrada);

        Region regionSave = regionRepository.save(regionCrear);

        return fabricaSalidaRegion.construirRegionDto(regionSave);
    }
}
