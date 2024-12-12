package com.telefonia_vivas.controller;

import com.telefonia_vivas.constants.ConstanteRegion;
import com.telefonia_vivas.dto.entrada.RegionDtoEntrada;
import com.telefonia_vivas.dto.modificar.RegionDtoModificar;
import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.interfaces.IRegionController;
import com.telefonia_vivas.service.RegionService;
import com.telefonia_vivas.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/v1/region")
public class RegionController implements IRegionController {
    private final RegionService regionService;

    @Override
    @PostMapping("/crear")
    public ResponseEntity<ApiResponse<RegionDtoSalida>> crearRegion(
            @RequestBody @Valid RegionDtoEntrada regionDtoEntrada) {

        RegionDtoSalida regionDtoSalida = regionService.crearRegion(regionDtoEntrada);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        ConstanteRegion.REGION_CREADA,
                        HttpStatus.CREATED.value(),
                        regionDtoSalida
                ));
    }

    @Override
    @GetMapping("/listar")
    public ResponseEntity<ApiResponse<List<RegionDtoSalida>>> listarRegion() {

        List<RegionDtoSalida> regionDtoSalidas = regionService.listarRegios();

        ApiResponse<List<RegionDtoSalida>> response = new ApiResponse<>(
                ConstanteRegion.REGION_LIST,
                HttpStatus.OK.value(),
                regionDtoSalidas
        );

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse<RegionDtoSalida>> buscarRegionID(Long idRegion) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<RegionDtoSalida>> regionModificar(RegionDtoModificar regionDtoModificar) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<Long>> eliminarRegion(Long idRegion) throws ResourceNotFoundException {
        return null;
    }
}
