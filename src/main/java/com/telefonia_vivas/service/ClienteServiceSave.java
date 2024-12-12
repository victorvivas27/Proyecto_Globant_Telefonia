package com.telefonia_vivas.service;

import com.telefonia_vivas.entity.Cliente;
import com.telefonia_vivas.exception.RunExistenteException;
import com.telefonia_vivas.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteServiceSave {
    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    public Cliente crearCliente(Cliente cliente) {
        String run = cliente.getRun();

        if (clienteRepository.existsByRun(run)) {
            throw new RunExistenteException("{validation.persona.run.exists}");

        }

        Cliente clienteCreado = modelMapper.map(cliente, Cliente.class);

        return clienteRepository.save(cliente);
    }
}