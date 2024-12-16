package com.telefonia_vivas.controller;

import com.telefonia_vivas.constants.ConstanteDireccion;
import com.telefonia_vivas.dto.entrada.DireccionDtoEntrada;
import com.telefonia_vivas.dto.modificar.DireccionDtoModificar;
import com.telefonia_vivas.dto.salida.DireccionDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.service.DireccionService;
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


    @GetMapping("/listar")
    public ResponseEntity<ApiResponse<List<DireccionDtoSalida>>> listarDireccion() {

        List<DireccionDtoSalida> direccionDtoSalidas = direccionService.listarDireccion();

        ApiResponse<List<DireccionDtoSalida>> response = new ApiResponse<>(
                ConstanteDireccion.DIRECCION_LIST,
                HttpStatus.OK.value(),
                direccionDtoSalidas
        );

        return ResponseEntity.ok(response);
    }


    @PutMapping("/modificar")
    public ResponseEntity<ApiResponse<DireccionDtoSalida>> direccionModificar(
            @RequestBody @Valid DireccionDtoModificar direccionDtoModificar) throws ResourceNotFoundException {

        DireccionDtoSalida direccionDtoSalida = direccionService.actualizarDireccion(direccionDtoModificar);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        ConstanteDireccion.DIRECCION_MODIFICADA,
                        HttpStatus.CREATED.value(),
                        direccionDtoSalida
                ));
    }


    @DeleteMapping("/eliminar/{idDireccion}")
    public ResponseEntity<ApiResponse<Long>> eliminarRegion(
            @PathVariable Long idDireccion) throws ResourceNotFoundException {

        direccionService.eliminarDireccion(idDireccion);

        ApiResponse<Long> response = new ApiResponse(
                ConstanteDireccion.DIRECCION_ELIMINADA,
                HttpStatus.OK.value(),
                idDireccion
        );
        return ResponseEntity.ok(response);
    }
}
