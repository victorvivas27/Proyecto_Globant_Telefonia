package com.telefonia_vivas.mapper.mappercliente;

import com.telefonia_vivas.dto.entrada.ClienteDtoEntrada;
import com.telefonia_vivas.entity.Cliente;
import com.telefonia_vivas.entity.Direccion;
import org.springframework.stereotype.Component;

@Component
public class FabricaCliente {

    public Cliente clienteAgregar(ClienteDtoEntrada clieneteDtoEntrada, Direccion direccion) {

        Cliente cliente = new Cliente();

        cliente.setNombre(clieneteDtoEntrada.getNombre());

        cliente.setRun(clieneteDtoEntrada.getRun());

        cliente.setFechaNacimiento(clieneteDtoEntrada.getFechaNacimiento());


        cliente.setDireccion(direccion);

        return cliente;
    }
}
