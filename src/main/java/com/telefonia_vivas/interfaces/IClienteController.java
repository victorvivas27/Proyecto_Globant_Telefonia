package com.telefonia_vivas.interfaces;

import com.telefonia_vivas.dto.entrada.ClienteDtoEntrada;
import com.telefonia_vivas.dto.modificar.ClienteDtoModificar;
import com.telefonia_vivas.dto.salida.ClienteDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.util.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IClienteController {

    ResponseEntity<ApiResponse<ClienteDtoSalida>> crearCliente(ClienteDtoEntrada clienteDtoEntrada);

    ResponseEntity<ApiResponse<List<ClienteDtoSalida>>> listarClientes();

    ResponseEntity<ApiResponse<ClienteDtoSalida>> buscarClienteID(Long idCliente) throws ResourceNotFoundException;

    ResponseEntity<ApiResponse<ClienteDtoSalida>> clienteModificar(ClienteDtoModificar toClienteModificar) throws ResourceNotFoundException;

    ResponseEntity<ApiResponse<Long>> eliminarCliente(Long idCliente) throws ResourceNotFoundException;
}
