package com.telefonia_vivas.factory.clienteservice;

import com.telefonia_vivas.dto.salida.ClienteDtoConContrato;
import com.telefonia_vivas.entity.Cliente;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ClienteRepository;
import com.telefonia_vivas.validation.validadorcliente.ValidadorCliente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteGetByIdService {

    private final ModelMapper modelMapper;
    private final ClienteRepository clienteRepository;
    private final ValidadorCliente validadorCliente;

    public ClienteDtoConContrato obtenerClientePorId(Long idCliente) throws ResourceNotFoundException {

        validadorCliente.validarIdCliente(idCliente);

        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);


        return modelMapper.map(cliente, ClienteDtoConContrato.class);
    }
}
