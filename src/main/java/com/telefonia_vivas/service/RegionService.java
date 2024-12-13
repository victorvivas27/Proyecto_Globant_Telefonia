package com.telefonia_vivas.service;

import com.telefonia_vivas.constants.ConstanteRegion;
import com.telefonia_vivas.dto.entrada.RegionDtoEntrada;
import com.telefonia_vivas.dto.modificar.RegionDtoModificar;
import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.interfaces.IRegion;
import com.telefonia_vivas.repository.RegionRepository;
import com.telefonia_vivas.service.mapper.FabricaRegion;
import com.telefonia_vivas.service.mapper.FabricaSalidaRegion;
import com.telefonia_vivas.service.validation.ValidadorRegion;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class RegionService implements IRegion {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegionService.class);
    private final ModelMapper modelMapper;
    private final RegionRepository regionRepository;
    private final ValidadorRegion validadorRegion;
    private final FabricaRegion fabricaRegion;
    private final FabricaSalidaRegion fabricaSalidaRegion;


    @Override
    public RegionDtoSalida crearRegion(RegionDtoEntrada regionDtoEntrada) throws ResourceNotFoundException {

        validadorRegion.validateRegionDto(regionDtoEntrada);

        Region regionCrear = fabricaRegion.regionCrear(regionDtoEntrada);

        Region regionSave = regionRepository.save(regionCrear);

        return fabricaSalidaRegion.construirRegionDto(regionSave);
    }

    @Override
    public List<RegionDtoSalida> listarRegios() {
        List<Region> regions = regionRepository.findAll();

        return regions.stream()
                .map(region -> modelMapper.map(region, RegionDtoSalida.class))
                .toList();
    }

    @Override
    public RegionDtoSalida obtenerRegionPorId(Long idRegion) throws ResourceNotFoundException {
        validadorRegion.validarIdRegion(idRegion);

        Region region = regionRepository.findById(idRegion).orElse(null);


        return modelMapper.map(region, RegionDtoSalida.class);
    }

    @Override
    public RegionDtoSalida actualizarRegion(RegionDtoModificar regionDtoModificar) throws ResourceNotFoundException {
        validadorRegion.validateRegionDtoModificar(regionDtoModificar);

        Region regionExistente = regionRepository.findById(regionDtoModificar.getIdRegion())
                .orElseThrow(() -> new ResourceNotFoundException(
                        ConstanteRegion.ID_REGION_NO_EXISTE + regionDtoModificar.getIdRegion()));

        regionExistente = fabricaRegion.regionModificar(regionDtoModificar, regionExistente);

        Region regionSave = regionRepository.save(regionExistente);

        return fabricaSalidaRegion.construirRegionDto(regionSave);
    }

    @Override
    public void eliminarRegion(Long idRegion) throws ResourceNotFoundException {
        validadorRegion.validarIdRegion(idRegion);

        regionRepository.deleteById(idRegion);
    }
}
