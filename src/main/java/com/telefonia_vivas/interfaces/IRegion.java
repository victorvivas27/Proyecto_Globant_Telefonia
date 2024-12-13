package com.telefonia_vivas.interfaces;

import com.telefonia_vivas.dto.entrada.RegionDtoEntrada;
import com.telefonia_vivas.dto.modificar.RegionDtoModificar;
import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;

import java.util.List;

public interface IRegion {
    RegionDtoSalida crearRegion(RegionDtoEntrada regionDtoEntrada) throws ResourceNotFoundException;

    List<RegionDtoSalida> listarRegios();

    RegionDtoSalida obtenerRegionPorId(Long idCliente) throws ResourceNotFoundException;

    RegionDtoSalida actualizarRegion(RegionDtoModificar regionDtoModificar) throws ResourceNotFoundException;

    void eliminarRegion(Long idRegion) throws ResourceNotFoundException;
}
