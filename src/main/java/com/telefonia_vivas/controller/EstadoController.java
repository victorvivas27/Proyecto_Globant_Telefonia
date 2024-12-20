package com.telefonia_vivas.controller;

import com.telefonia_vivas.constants.ConstanteEstado;
import com.telefonia_vivas.dto.entrada.EstadoDtoEntrada;
import com.telefonia_vivas.dto.salida.EstadoDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.service.EstadoService;
import com.telefonia_vivas.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/v1/estado")
public class EstadoController {

    private final EstadoService estadoService;

    @PostMapping
    public ResponseEntity<ApiResponse<EstadoDtoSalida>> crearEstado(
            @RequestBody @Valid EstadoDtoEntrada estadoDtoEntrada) throws ResourceNotFoundException {


        EstadoDtoSalida estadoDtoSalida = estadoService.crearEstado(estadoDtoEntrada);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        ConstanteEstado.ESTADO_CREADO,
                        HttpStatus.CREATED.value(),
                        estadoDtoSalida
                ));
    }
}
