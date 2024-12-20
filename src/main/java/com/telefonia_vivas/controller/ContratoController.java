package com.telefonia_vivas.controller;

import com.telefonia_vivas.constants.ConstanteContrato;
import com.telefonia_vivas.dto.entrada.ContratoDtoEntrada;
import com.telefonia_vivas.dto.salida.ContratoDtoSalida;
import com.telefonia_vivas.entity.Estado;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.service.ContratoService;
import com.telefonia_vivas.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/v1/contrato")
public class ContratoController {
    private final ContratoService contratoService;

    @PostMapping
    public ResponseEntity<ApiResponse<ContratoDtoSalida>> crearContrato(
            @RequestBody @Valid ContratoDtoEntrada contratoDtoEntrada) throws ResourceNotFoundException {


        ContratoDtoSalida contratoDtoSalida = contratoService.crearContrato(contratoDtoEntrada);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        ConstanteContrato.CONTRATO_CREADO,
                        HttpStatus.CREATED.value(),
                        contratoDtoSalida
                ));
    }

    @PatchMapping("/{idContrato}/estado")
    public ResponseEntity<ApiResponse<ContratoDtoSalida>> actualizarEstado(
            @PathVariable Long idContrato,
            @RequestBody ContratoDtoEntrada contratoDtoEntrada) throws ResourceNotFoundException {

        Estado estado = contratoDtoEntrada.getEstado();

        ContratoDtoSalida contratoDtoSalida = contratoService.actualizarEstado(idContrato, estado);

        return ResponseEntity.ok(new ApiResponse<>(
                ConstanteContrato.CONTRATO_ACTUALIZO_ESTADO,
                HttpStatus.OK.value(),
                contratoDtoSalida
        ));
    }
}
