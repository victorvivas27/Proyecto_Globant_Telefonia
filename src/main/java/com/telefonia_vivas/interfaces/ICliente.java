package com.telefonia_vivas.interfaces;

import com.telefonia_vivas.dto.entrada.ClienteDtoEntrada;
import com.telefonia_vivas.dto.modificar.ClienteDtoModificar;
import com.telefonia_vivas.dto.salida.ClienteDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;

import java.util.List;

public interface ICliente {

    ClienteDtoSalida crearCliente(ClienteDtoEntrada clienteDtoEntrada);

    List<ClienteDtoSalida> listarClientes();

    ClienteDtoSalida obtenerClientePorId(Long idCliente) throws ResourceNotFoundException;

    ClienteDtoSalida actualizarCliente(ClienteDtoModificar ClienteDtoModificar) throws ResourceNotFoundException;

    void eliminarCliente(Long idCliente) throws ResourceNotFoundException;
}
