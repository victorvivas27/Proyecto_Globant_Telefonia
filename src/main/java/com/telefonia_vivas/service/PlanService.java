package com.telefonia_vivas.service;

import com.telefonia_vivas.dto.entrada.PlanDtoEntrada;
import com.telefonia_vivas.dto.modificar.PlanDtoModificar;
import com.telefonia_vivas.dto.salida.PlanDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.factory.planservice.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PlanService {

    private final PlanCrationService planCrationService;
    private final PlanListService planListService;
    private final PlanGetByIdService planGetByIdService;
    private final PlanUpdateService planUpdateService;
    private final PlanDeleteService planDeleteService;
    private final PlanYServicio planYServicio;

    public PlanDtoSalida crearPlan(PlanDtoEntrada planDtoEntrada) throws ResourceNotFoundException {

        return planCrationService.crearPlan(planDtoEntrada);
    }


    public List<PlanDtoSalida> listarPlanes() {

        return planListService.listarPlanes();
    }


    public PlanDtoSalida obtenerPlanPorId(Long idPlan) throws ResourceNotFoundException {

        return planGetByIdService.obtenerPlanPorId(idPlan);
    }


    public PlanDtoSalida actualizarPLan(PlanDtoModificar planDtoModificar) throws ResourceNotFoundException {

        return planUpdateService.actualizarPLan(planDtoModificar);
    }


    public void eliminarPlan(Long idPlan) throws ResourceNotFoundException {

        planDeleteService.eliminarPlan(idPlan);

    }

    public PlanDtoSalida agregarServicioAPlan(Long idPlan, Long idServicio) throws ResourceNotFoundException {

        return planYServicio.agregarServicioAPlan(idPlan, idServicio);
    }
}
