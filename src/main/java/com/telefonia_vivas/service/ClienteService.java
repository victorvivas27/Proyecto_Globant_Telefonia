package com.telefonia_vivas.service;

import com.telefonia_vivas.dto.entrada.ClienteDtoEntrada;
import com.telefonia_vivas.dto.modificar.ClienteDtoModificar;
import com.telefonia_vivas.dto.salida.ClienteDtoConContrato;
import com.telefonia_vivas.dto.salida.ClienteDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.factory.clienteservice.ClienteCreationService;
import com.telefonia_vivas.factory.clienteservice.ClienteDeleteService;
import com.telefonia_vivas.factory.clienteservice.ClienteGetByIdService;
import com.telefonia_vivas.factory.clienteservice.ClienteListService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ClienteService {

    private final ClienteCreationService clienteCreationService;
    private final ClienteListService clienteListService;
    private final ClienteDeleteService clienteDeleteService;
    private final ClienteGetByIdService clienteGetByIdService;


    public ClienteDtoSalida crearCliente(ClienteDtoEntrada clienteDtoEntrada) throws ResourceNotFoundException {

        return clienteCreationService.crearCliente(clienteDtoEntrada);

    }


    public List<ClienteDtoSalida> listarClientes() {
        return clienteListService.listarClientes();
    }


    public ClienteDtoConContrato obtenerClientePorId(Long idCliente) throws ResourceNotFoundException {
        return clienteGetByIdService.obtenerClientePorId(idCliente);
    }


    public ClienteDtoSalida actualizarCliente(ClienteDtoModificar ClienteDtoModificar) throws ResourceNotFoundException {
        return null;
    }


    public void eliminarCliente(Long idCliente) throws ResourceNotFoundException {
        clienteDeleteService.eliminarCliente(idCliente);
    }
}
