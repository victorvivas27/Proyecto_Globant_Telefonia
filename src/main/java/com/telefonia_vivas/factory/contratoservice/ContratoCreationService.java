package com.telefonia_vivas.factory.contratoservice;

import com.telefonia_vivas.dto.entrada.ContratoDtoEntrada;
import com.telefonia_vivas.dto.salida.ContratoDtoSalida;
import com.telefonia_vivas.entity.Cliente;
import com.telefonia_vivas.entity.Contrato;
import com.telefonia_vivas.entity.Estado;
import com.telefonia_vivas.entity.Plan;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ClienteRepository;
import com.telefonia_vivas.repository.ContratoRepository;
import com.telefonia_vivas.repository.PlanRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ContratoCreationService {

    private final ClienteRepository clienteRepository;
    private final PlanRepository planRepository;
    private final ContratoRepository contratoRepository;

    public ContratoDtoSalida crearContrato(ContratoDtoEntrada contratoDtoEntrada)
            throws ResourceNotFoundException {

        // Obtener entidades desde la base de datos
        Cliente cliente = clienteRepository.findById(contratoDtoEntrada.getIdCliente())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        Plan plan = planRepository.findById(contratoDtoEntrada.getIdPlan())
                .orElseThrow(() -> new IllegalArgumentException("Plan no encontrado"));

        // Crear entidad Contrato
        Contrato contrato = Contrato.builder()
                .cliente(cliente)
                .plan(plan)
                .estado(contratoDtoEntrada.getEstado())
                .build();

        // Guardar en la base de datos
        Contrato contratoGuardado = contratoRepository.save(contrato);

        // Mapear entidad a DTO de salida
        return ContratoDtoSalida.builder()
                .idContrato(contratoGuardado.getIdContrato())
                .idCliente(contratoGuardado.getCliente().getIdCliente())
                .idPlan(contratoGuardado.getPlan().getIdPlan())
                .estado(contratoGuardado.getEstado())
                .build();
    }


    public ContratoDtoSalida actualizarEstado(Long idContrato, Estado estado) throws ResourceNotFoundException {
        Contrato contrato = contratoRepository.findById(idContrato)
                .orElseThrow(() -> new ResourceNotFoundException("Contrato no encontrado"));

        contrato.setEstado(estado);
        contrato = contratoRepository.save(contrato);

        return ContratoDtoSalida.builder()
                .idContrato(contrato.getIdContrato())
                .idCliente(contrato.getCliente().getIdCliente())
                .idPlan(contrato.getPlan().getIdPlan())
                .estado(contrato.getEstado())
                .build();
    }

}