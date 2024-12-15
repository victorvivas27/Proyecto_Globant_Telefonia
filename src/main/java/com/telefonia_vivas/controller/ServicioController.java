package com.telefonia_vivas.controller;

import com.telefonia_vivas.constants.ConstanteServicio;
import com.telefonia_vivas.dto.entrada.ServicioDtoEntrada;
import com.telefonia_vivas.dto.modificar.ServicioDtoModificar;
import com.telefonia_vivas.dto.salida.ServicioDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.service.ServicioService;
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
@RequestMapping("/v1/servicio")
public class ServicioController {
    private final ServicioService servicioService;

    @PostMapping("/crear")
    public ResponseEntity<ApiResponse<ServicioDtoSalida>> crearServicio(
            @RequestBody @Valid ServicioDtoEntrada servicioDtoEntrada) throws ResourceNotFoundException {

        ServicioDtoSalida servicioDtoSalida = servicioService.crearServicio(servicioDtoEntrada);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        ConstanteServicio.SERVICIO_CREADA,
                        HttpStatus.CREATED.value(),
                        servicioDtoSalida
                ));
    }


    @GetMapping("/listar")
    public ResponseEntity<ApiResponse<List<ServicioDtoSalida>>> listarServicio() {

        List<ServicioDtoSalida> servicioDtoSalidas = servicioService.listarServicio();

        ApiResponse<List<ServicioDtoSalida>> response = new ApiResponse<>(
                ConstanteServicio.SERVICIO_LIST,
                HttpStatus.OK.value(),
                servicioDtoSalidas
        );

        return ResponseEntity.ok(response);
    }


    @GetMapping("/buscar/{idServicio}")
    public ResponseEntity<ApiResponse<ServicioDtoSalida>> buscarServicioID(
            @PathVariable Long idServicio) throws ResourceNotFoundException {

        ServicioDtoSalida servicioDtoSalida = servicioService.obtenerServicioPorId(idServicio);

        ApiResponse<ServicioDtoSalida> response = new ApiResponse<>(

                ConstanteServicio.SERVICIO_ENCONTRADA,
                HttpStatus.OK.value(),
                servicioDtoSalida
        );

        return ResponseEntity.ok().body(response);
    }


    @PutMapping("/modificar")
    public ResponseEntity<ApiResponse<ServicioDtoSalida>> servicioModificar(
            @RequestBody @Valid ServicioDtoModificar servicioDtoModificar) throws ResourceNotFoundException {

        ServicioDtoSalida servicioDtoSalida = servicioService.actualizarServicio(servicioDtoModificar);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        ConstanteServicio.SERVICIO_MODIFICADA,
                        HttpStatus.CREATED.value(),
                        servicioDtoSalida
                ));
    }


    @DeleteMapping("/eliminar/{idServicio}")
    public ResponseEntity<ApiResponse<Long>> eliminarServicio(
            @PathVariable Long idServicio) throws ResourceNotFoundException {

        servicioService.eliminarServicio(idServicio);

        ApiResponse<Long> response = new ApiResponse(
                ConstanteServicio.SERVICIO_ELIMINADA,
                HttpStatus.OK.value(),
                idServicio
        );
        return ResponseEntity.ok(response);
    }

}
