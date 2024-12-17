package com.telefonia_vivas.controller;

import com.telefonia_vivas.constants.ConstanteCliente;
import com.telefonia_vivas.dto.entrada.ClienteDtoEntrada;
import com.telefonia_vivas.dto.modificar.ClienteDtoModificar;
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


    public ResponseEntity<ApiResponse<List<ClienteDtoSalida>>> listarClientes() {
        return null;
    }


    public ResponseEntity<ApiResponse<ClienteDtoSalida>> buscarClienteID(Long idCliente) throws ResourceNotFoundException {
        return null;
    }


    public ResponseEntity<ApiResponse<ClienteDtoSalida>> clienteModificar(ClienteDtoModificar toClienteModificar) throws ResourceNotFoundException {
        return null;
    }


    public ResponseEntity<ApiResponse<Long>> eliminarCliente(Long idCliente) throws ResourceNotFoundException {
        return null;
    }
}
