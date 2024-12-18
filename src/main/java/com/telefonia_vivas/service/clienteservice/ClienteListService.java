package com.telefonia_vivas.service.clienteservice;

import com.telefonia_vivas.dto.salida.ClienteDtoSalida;
import com.telefonia_vivas.entity.Cliente;
import com.telefonia_vivas.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteListService {

    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public List<ClienteDtoSalida> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        // Forzar la inicialización de la colección de contratos
        clientes.forEach(cliente -> cliente.getContratos().size());

        return clientes.stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDtoSalida.class))
                .toList();
    }
}
