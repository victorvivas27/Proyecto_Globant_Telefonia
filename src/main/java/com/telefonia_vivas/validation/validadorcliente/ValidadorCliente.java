package com.telefonia_vivas.validation.validadorcliente;

import com.telefonia_vivas.constants.ConstanteCliente;
import com.telefonia_vivas.entity.Cliente;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ValidadorCliente {

    private final ClienteRepository clienteRepository;

    public Cliente validarIdCliente(Long idCliente) throws ResourceNotFoundException {

        if (idCliente == null) {
            throw new IllegalArgumentException(ConstanteCliente.CLIENTE_ID_NO_ENCONTRADO);
        }
        return clienteRepository.findById(idCliente)
                .orElseThrow(() -> new ResourceNotFoundException(
                        ConstanteCliente.CLIENTE_ID_NO_ENCONTRADO + idCliente));
    }


}
