package com.telefonia_vivas.interfaces;

import com.telefonia_vivas.dto.entrada.RegionDtoEntrada;
import com.telefonia_vivas.dto.modificar.RegionDtoModificar;
import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.util.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRegionController {

    ResponseEntity<ApiResponse<RegionDtoSalida>> crearRegion(RegionDtoEntrada regionDtoEntrada) throws ResourceNotFoundException;

    ResponseEntity<ApiResponse<List<RegionDtoSalida>>> listarRegion();

    ResponseEntity<ApiResponse<RegionDtoSalida>> buscarRegionID(Long idRegion) throws ResourceNotFoundException;

    ResponseEntity<ApiResponse<RegionDtoSalida>> regionModificar(RegionDtoModificar regionDtoModificar) throws ResourceNotFoundException;

    ResponseEntity<ApiResponse<Long>> eliminarRegion(Long idRegion) throws ResourceNotFoundException;
}
