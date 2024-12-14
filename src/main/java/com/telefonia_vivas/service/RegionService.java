package com.telefonia_vivas.service;

import com.telefonia_vivas.dto.entrada.RegionDtoEntrada;
import com.telefonia_vivas.dto.modificar.RegionDtoModificar;
import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.interfaces.IRegion;
import com.telefonia_vivas.service.regionservice.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class RegionService implements IRegion {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegionService.class);
    private final RegionCrationService regionCrationService;
    private final RegionListService regionListService;
    private final RegionGetByIdService regionGetByIdService;
    private final RegionUpdateService regionUpdateService;
    private final RegionDeleteService regionDeleteService;


    @Override
    public RegionDtoSalida crearRegion(RegionDtoEntrada regionDtoEntrada) throws ResourceNotFoundException {

        return regionCrationService.crearRegion(regionDtoEntrada);
    }

    @Override
    public List<RegionDtoSalida> listarRegios() {

        return regionListService.listarRegios();
    }

    @Override
    public RegionDtoSalida obtenerRegionPorId(Long idRegion) throws ResourceNotFoundException {

        return regionGetByIdService.obtenerRegionPorId(idRegion);
    }

    @Override
    public RegionDtoSalida actualizarRegion(RegionDtoModificar regionDtoModificar) throws ResourceNotFoundException {

        return regionUpdateService.actualizarRegion(regionDtoModificar);
    }

    @Override
    public void eliminarRegion(Long idRegion) throws ResourceNotFoundException {

        regionDeleteService.eliminarRegion(idRegion);

    }
}
