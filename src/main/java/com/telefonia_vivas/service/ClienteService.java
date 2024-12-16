package com.telefonia_vivas.service;

import com.telefonia_vivas.constants.ConstanteCliente;
import com.telefonia_vivas.dto.entrada.ClienteDtoEntrada;
import com.telefonia_vivas.dto.modificar.ClienteDtoModificar;
import com.telefonia_vivas.dto.salida.ClienteDtoSalida;
import com.telefonia_vivas.entity.Cliente;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ClienteRepository;
import com.telefonia_vivas.util.SalidaJson;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ClienteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteService.class);
    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;
    private final ClienteServiceSave clienteServiceSave;


    public ClienteDtoSalida crearCliente(ClienteDtoEntrada clienteDtoEntrada) {

        Cliente cliente = modelMapper.map(clienteDtoEntrada, Cliente.class);
        Cliente clienteCreado = clienteServiceSave.crearCliente(cliente);

        ClienteDtoSalida toClienteSalida = modelMapper.map(clienteCreado, ClienteDtoSalida.class);

        LOGGER.info(ConstanteCliente.CLIENTE + "\n" + SalidaJson.toString(toClienteSalida));

        return toClienteSalida;
    }


    public List<ClienteDtoSalida> listarClientes() {
        return List.of();
    }


    public ClienteDtoSalida obtenerClientePorId(Long idCliente) throws ResourceNotFoundException {
        return null;
    }


    public ClienteDtoSalida actualizarCliente(ClienteDtoModificar ClienteDtoModificar) throws ResourceNotFoundException {
        return null;
    }


    public void eliminarCliente(Long idCliente) throws ResourceNotFoundException {

    }
}
