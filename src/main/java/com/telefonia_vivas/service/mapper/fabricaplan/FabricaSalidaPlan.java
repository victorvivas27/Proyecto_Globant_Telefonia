package com.telefonia_vivas.service.mapper.fabricaplan;

import com.telefonia_vivas.dto.salida.PlanDtoSalida;
import com.telefonia_vivas.entity.Plan;
import org.springframework.stereotype.Component;

@Component
public class FabricaSalidaPlan {

    public PlanDtoSalida construirPlanDto(Plan plan) {

        PlanDtoSalida planDtoSalida = new PlanDtoSalida();

        planDtoSalida.setIdPlan(plan.getIdPlan());

        planDtoSalida.setNombrePlan(plan.getNombrePlan());

        planDtoSalida.setPrecio(plan.getPrecio());

        planDtoSalida.setServicios(plan.getServicios());


        return planDtoSalida;
    }
}
