package com.telefonia_vivas.service.mapper.fabricaplan;

import com.telefonia_vivas.dto.entrada.PlanDtoEntrada;
import com.telefonia_vivas.dto.modificar.PlanDtoModificar;
import com.telefonia_vivas.entity.Plan;
import org.springframework.stereotype.Component;

@Component
public class FabricaPlan {

    public Plan planCrear(PlanDtoEntrada planDtoEntrada) {
        Plan plan = new Plan();
        plan.setNombrePlan(planDtoEntrada.getNombrePlan());
        plan.setPrecio(planDtoEntrada.getPrecio());
        return plan;
    }

    public Plan planModificar(
            PlanDtoModificar planDtoModificar, Plan planExistente) {
        planExistente.setNombrePlan(planDtoModificar.getNombrePlan());
        planExistente.setPrecio(planDtoModificar.getPrecio());


        return planExistente;
    }
}
