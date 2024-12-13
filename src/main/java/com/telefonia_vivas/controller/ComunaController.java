package com.telefonia_vivas.controller;

import com.telefonia_vivas.constants.ConstanteComuna;
import com.telefonia_vivas.dto.entrada.ComunaDtoEntrada;
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
    public ResponseEntity<ApiResponse<ComunaDtoSalida>> buscarComunaID(Long idComuna) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<ComunaDtoSalida>> comunaModificar(ComunaDtoEntrada comunaDtoEntrada) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<Long>> eliminarComuna(Long idComuna) throws ResourceNotFoundException {
        return null;
    }
}
