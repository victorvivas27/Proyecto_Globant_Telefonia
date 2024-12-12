package com.telefonia_vivas.service;

import com.telefonia_vivas.constants.ConstanteRegion;
import com.telefonia_vivas.dto.entrada.RegionDtoEntrada;
import com.telefonia_vivas.dto.modificar.RegionDtoModificar;
import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.interfaces.IRegion;
import com.telefonia_vivas.repository.RegionRepository;
import com.telefonia_vivas.util.SalidaJson;
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
    private final RegionServiceSave regionServiceSave;
    private final RegionRepository regionRepository;

    @Override
    public RegionDtoSalida crearRegion(RegionDtoEntrada regionDtoEntrada) {
        Region region = modelMapper.map(regionDtoEntrada, Region.class);
        Region regionCreado = regionServiceSave.crearRegion(region);

        RegionDtoSalida regionDtoSalida = modelMapper.map(regionCreado, RegionDtoSalida.class);

        LOGGER.info(ConstanteRegion.REGIONES + "\n" + SalidaJson.toString(regionDtoSalida));

        return regionDtoSalida;
    }

    @Override
    public List<RegionDtoSalida> listarRegios() {
        List<Region> regions = regionRepository.findAll();
        return regions.stream()
                .map(region -> modelMapper.map(region, RegionDtoSalida.class))
                .toList();
    }

    @Override
    public RegionDtoSalida obtenerRegionPorId(Long idCliente) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public RegionDtoSalida actualizarRegion(RegionDtoModificar regionDtoModificar) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public void eliminarRegion(Long idRegion) throws ResourceNotFoundException {

    }
}
