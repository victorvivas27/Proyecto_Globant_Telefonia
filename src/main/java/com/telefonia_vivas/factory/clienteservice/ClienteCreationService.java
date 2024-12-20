package com.telefonia_vivas.factory.clienteservice;

import com.telefonia_vivas.dto.entrada.ClienteDtoEntrada;
import com.telefonia_vivas.dto.entrada.DireccionDtoEntrada;
import com.telefonia_vivas.dto.salida.ClienteDtoSalida;
import com.telefonia_vivas.entity.Cliente;
import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.entity.Direccion;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.mapper.mappercliente.FabricaCliente;
import com.telefonia_vivas.mapper.mappercliente.FabricaSalidaCliente;
import com.telefonia_vivas.mapper.mapperdireccion.FabricaDireccion;
import com.telefonia_vivas.repository.ClienteRepository;
import com.telefonia_vivas.validation.validadorcomuna.ValidadorComuna;
import com.telefonia_vivas.validation.validadordireccion.ValidadorDireccion;
import com.telefonia_vivas.validation.validadorregio.ValidadorRegion;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ClienteCreationService {
    private final ValidadorDireccion validadorDireccion;
    private final ClienteRepository clienteRepository;
    private final FabricaCliente fabricaCliente;
    private final FabricaSalidaCliente fabricaSalidaCliente;
    private final ValidadorRegion validadorRegion;
    private final ValidadorComuna validadorComuna;
    private final FabricaDireccion fabricaDireccion;

    public ClienteDtoSalida crearCliente(ClienteDtoEntrada clienteDtoEntrada) throws ResourceNotFoundException {
        if (clienteRepository.existsByRun(clienteDtoEntrada.getRun())) {
            throw new IllegalArgumentException("El RUN ya está registrado: " + clienteDtoEntrada.getRun());
        }
        DireccionDtoEntrada direccionDtoEntrada = clienteDtoEntrada.getDireccion();

        Region region = validadorRegion.validarIdRegion(direccionDtoEntrada.getIdRegion());

        Comuna comuna = validadorComuna.validarIdComuna(direccionDtoEntrada.getIdComuna());


        Direccion direccion = fabricaDireccion.direccionCrear(direccionDtoEntrada, region, comuna);

        Cliente cliente = fabricaCliente.clienteAgregar(clienteDtoEntrada, direccion);

        Cliente clienteSave = clienteRepository.save(cliente);

        return fabricaSalidaCliente.construirClienteDto(clienteSave);


    }
}
