package com.telefonia_vivas.controller;

import com.telefonia_vivas.constants.ConstanteDireccion;
import com.telefonia_vivas.constants.ConstanteRegion;
import com.telefonia_vivas.dto.entrada.DireccionDtoEntrada;
import com.telefonia_vivas.dto.entrada.RegionDtoEntrada;
import com.telefonia_vivas.dto.salida.DireccionDtoSalida;
import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.service.DireccionService;
import com.telefonia_vivas.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/v1/direccion")
public class DireccionController {
private final DireccionService direccionService;
    @PostMapping("/crear")
    public ResponseEntity<ApiResponse<DireccionDtoSalida>> crearDireccion(
            @RequestBody @Valid DireccionDtoEntrada direccionDtoEntrada) throws ResourceNotFoundException {

        DireccionDtoSalida direccionDtoSalida = direccionService.crearDireccion(direccionDtoEntrada);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        ConstanteDireccion.DIRECCION_CREADA,
                        HttpStatus.CREATED.value(),
                        direccionDtoSalida
                ));
    }
}
