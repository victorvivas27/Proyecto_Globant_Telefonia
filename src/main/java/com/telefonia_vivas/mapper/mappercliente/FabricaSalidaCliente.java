package com.telefonia_vivas.mapper.mappercliente;

import com.telefonia_vivas.dto.salida.ClienteDtoSalida;
import com.telefonia_vivas.dto.salida.DireccionDtoSalida;
import com.telefonia_vivas.entity.Cliente;
import com.telefonia_vivas.mapper.mapperdireccion.FabricaSalidaDireccion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FabricaSalidaCliente {
    private final FabricaSalidaDireccion fabricaSalidaDireccion;

    public ClienteDtoSalida construirClienteDto(Cliente cliente) {

        ClienteDtoSalida clienteDtoSalida = new ClienteDtoSalida();

        clienteDtoSalida.setIdCliente(cliente.getIdCliente());

        clienteDtoSalida.setNombre(cliente.getNombre());

        clienteDtoSalida.setRun(cliente.getRun());

        clienteDtoSalida.setFechaNacimiento(cliente.getFechaNacimiento());

        if (cliente.getDireccion() != null) {
            DireccionDtoSalida direccionDtoSalida =
                    fabricaSalidaDireccion.construirDireccionDto(cliente.getDireccion());
            clienteDtoSalida.setDireccion(direccionDtoSalida);
        }

        return clienteDtoSalida;
    }
}
