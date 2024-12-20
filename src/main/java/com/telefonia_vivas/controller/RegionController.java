package com.telefonia_vivas.controller;

import com.telefonia_vivas.constants.ConstanteRegion;
import com.telefonia_vivas.dto.entrada.RegionDtoEntrada;
import com.telefonia_vivas.dto.modificar.RegionDtoModificar;
import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
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
public class RegionController {
    private final RegionService regionService;


    @PostMapping
    public ResponseEntity<ApiResponse<RegionDtoSalida>> crearRegion(
            @RequestBody @Valid RegionDtoEntrada regionDtoEntrada) throws ResourceNotFoundException {

        RegionDtoSalida regionDtoSalida = regionService.crearRegion(regionDtoEntrada);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        ConstanteRegion.REGION_CREADA,
                        HttpStatus.CREATED.value(),
                        regionDtoSalida
                ));
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<RegionDtoSalida>>> listarRegion() {

        List<RegionDtoSalida> regionDtoSalidas = regionService.listarRegios();

        ApiResponse<List<RegionDtoSalida>> response = new ApiResponse<>(
                ConstanteRegion.REGION_LIST,
                HttpStatus.OK.value(),
                regionDtoSalidas
        );

        return ResponseEntity.ok(response);
    }


    @GetMapping("{idRegion}")
    public ResponseEntity<ApiResponse<RegionDtoSalida>> buscarRegionID(
            @PathVariable Long idRegion) throws ResourceNotFoundException {

        RegionDtoSalida regionDtoSalida = regionService.obtenerRegionPorId(idRegion);

        ApiResponse<RegionDtoSalida> response = new ApiResponse<>(

                ConstanteRegion.REGION_ENCONTRADA,
                HttpStatus.OK.value(),
                regionDtoSalida
        );

        return ResponseEntity.ok().body(response);
    }


    @PutMapping
    public ResponseEntity<ApiResponse<RegionDtoSalida>> regionModificar(
            @RequestBody @Valid RegionDtoModificar regionDtoModificar) throws ResourceNotFoundException {

        RegionDtoSalida regionDtoSalida = regionService.actualizarRegion(regionDtoModificar);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        ConstanteRegion.REGION_MODIFICADA,
                        HttpStatus.CREATED.value(),
                        regionDtoSalida
                ));
    }


    @DeleteMapping("{idRegion}")
    public ResponseEntity<ApiResponse<Long>> eliminarRegion(
            @PathVariable Long idRegion) throws ResourceNotFoundException {

        regionService.eliminarRegion(idRegion);

        ApiResponse<Long> response = new ApiResponse(
                ConstanteRegion.REGION_ELIMINADA,
                HttpStatus.OK.value(),
                idRegion
        );
        return ResponseEntity.ok(response);
    }
}
