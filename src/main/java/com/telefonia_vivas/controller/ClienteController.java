package com.telefonia_vivas.controller;

import com.telefonia_vivas.constants.ConstanteCliente;
import com.telefonia_vivas.constants.ConstanteRegion;
import com.telefonia_vivas.dto.entrada.ClienteDtoEntrada;
import com.telefonia_vivas.dto.modificar.ClienteDtoModificar;
import com.telefonia_vivas.dto.salida.ClienteDtoConContrato;
import com.telefonia_vivas.dto.salida.ClienteDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.service.ClienteService;
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
@RequestMapping("/v1/cliente")
public class ClienteController {
    private final ClienteService clienteService;


    @PostMapping("/crear")
    public ResponseEntity<ApiResponse<ClienteDtoSalida>> crearCliente(
            @RequestBody @Valid ClienteDtoEntrada clienteDtoEntrada) throws ResourceNotFoundException {


        ClienteDtoSalida clienteDtoSalida = clienteService.crearCliente(clienteDtoEntrada);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        ConstanteCliente.CLIENTE_CREADO,
                        HttpStatus.CREATED.value(),
                        clienteDtoSalida
                ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ClienteDtoSalida>>> listarClientes() {

        List<ClienteDtoSalida> clienteDtoSalidas = clienteService.listarClientes();

        ApiResponse<List<ClienteDtoSalida>> response = new ApiResponse<>(
                ConstanteCliente.LISTA_CLIENTES,
                HttpStatus.OK.value(),
                clienteDtoSalidas
        );

        return ResponseEntity.ok(response);
    }


    @GetMapping("/{idCliente}")
    public ResponseEntity<ApiResponse<ClienteDtoConContrato>> buscarClienteID(
            @PathVariable Long idCliente) throws ResourceNotFoundException {

        ClienteDtoConContrato clienteDtoConContrato = clienteService.obtenerClientePorId(idCliente);

        ApiResponse<ClienteDtoConContrato> response = new ApiResponse<>(

                ConstanteRegion.REGION_ENCONTRADA,
                HttpStatus.OK.value(),
                clienteDtoConContrato
        );

        return ResponseEntity.ok().body(response);
    }


    public ResponseEntity<ApiResponse<ClienteDtoSalida>> clienteModificar(ClienteDtoModificar toClienteModificar) throws ResourceNotFoundException {
        return null;
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<ApiResponse<Long>> eliminarCliente(
            @PathVariable Long idCliente) throws ResourceNotFoundException {
        clienteService.eliminarCliente(idCliente);

        ApiResponse<Long> response = new ApiResponse(
                ConstanteCliente.CLIENTE_ELIMINADO,
                HttpStatus.OK.value(),
                idCliente
        );
        return ResponseEntity.ok(response);
    }


}

