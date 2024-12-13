package com.telefonia_vivas.controller;

import com.telefonia_vivas.constants.ConstanteComuna;
import com.telefonia_vivas.dto.entrada.ComunaDtoEntrada;
import com.telefonia_vivas.dto.modificar.ComunaDtoModificar;
import com.telefonia_vivas.dto.salida.ComunaDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.interfaces.IComunaController;
import com.telefonia_vivas.service.ComunaService;
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
@RequestMapping("/v1/comuna")
public class ComunaController implements IComunaController {

    private final ComunaService comunaService;

    @Override
    @PostMapping("/crear")
    public ResponseEntity<ApiResponse<ComunaDtoSalida>> crearComuna(
            @RequestBody @Valid ComunaDtoEntrada comunaDtoEntrada) throws ResourceNotFoundException {


        ComunaDtoSalida comunaDtoSalida = comunaService.crearComuna(comunaDtoEntrada);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        ConstanteComuna.COMUNA_CREADA,
                        HttpStatus.CREATED.value(),
                        comunaDtoSalida
                ));


    }

    @Override
    @GetMapping("/listar")
    public ResponseEntity<ApiResponse<List<ComunaDtoSalida>>> listarComuna() {
        List<ComunaDtoSalida> comunaDtoSalidas = comunaService.listarComuna();

        ApiResponse<List<ComunaDtoSalida>> response = new ApiResponse<>(
                ConstanteComuna.COMUNAS_LIST,
                HttpStatus.OK.value(),
                comunaDtoSalidas
        );

        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/buscar/{idComuna}")
    public ResponseEntity<ApiResponse<ComunaDtoSalida>> buscarComunaID(
            @PathVariable Long idComuna) throws ResourceNotFoundException {

        ComunaDtoSalida comunaDtoSalida = comunaService.obtenerComunaPorId(idComuna);

        ApiResponse<ComunaDtoSalida> response = new ApiResponse<>(

                ConstanteComuna.COMUNA_ENCONTRADA,
                HttpStatus.OK.value(),
                comunaDtoSalida
        );

        return ResponseEntity.ok().body(response);
    }

    @Override
    @PutMapping("/modificar")
    public ResponseEntity<ApiResponse<ComunaDtoSalida>> comunaModificar(
            @RequestBody @Valid ComunaDtoModificar comunaDtoModificar) throws ResourceNotFoundException {

        ComunaDtoSalida comunaDtoSalida = comunaService.actualizarComuna(comunaDtoModificar);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        ConstanteComuna.COMUNA_MODIFICADA,
                        HttpStatus.CREATED.value(),
                        comunaDtoSalida
                ));
    }

    @Override
    @DeleteMapping("/eliminar/{idComuna}")
    public ResponseEntity<ApiResponse<Long>> eliminarComuna(
            @PathVariable Long idComuna) throws ResourceNotFoundException {

        comunaService.eliminarComuna(idComuna);

        ApiResponse<Long> response = new ApiResponse(
                ConstanteComuna.COMUNA_ELIMINADA,
                HttpStatus.OK.value(),
                idComuna
        );
        return ResponseEntity.ok(response);
    }
}
