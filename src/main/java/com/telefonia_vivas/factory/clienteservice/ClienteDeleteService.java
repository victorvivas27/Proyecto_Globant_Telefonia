package com.telefonia_vivas.factory.clienteservice;

import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ClienteRepository;
import com.telefonia_vivas.validation.validadorcliente.ValidadorCliente;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ClienteDeleteService {

    private final ValidadorCliente validadorCliente;
    private final ClienteRepository clienteRepository;

    public void eliminarCliente(Long idCliente) throws ResourceNotFoundException {

        validadorCliente.validarIdCliente(idCliente);

        clienteRepository.deleteById(idCliente);


    }
}
