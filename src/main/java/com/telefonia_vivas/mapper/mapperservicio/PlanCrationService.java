package com.telefonia_vivas.mapper.mapperservicio;

import com.telefonia_vivas.dto.entrada.PlanDtoEntrada;
import com.telefonia_vivas.dto.salida.PlanDtoSalida;
import com.telefonia_vivas.entity.Plan;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.mapper.mapperplan.FabricaPlan;
import com.telefonia_vivas.mapper.mapperplan.FabricaSalidaPlan;
import com.telefonia_vivas.repository.PlanRepository;
import com.telefonia_vivas.validation.validadorplan.ValidadorPlan;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class PlanCrationService {

    private final PlanRepository planDtoRepository;
    private final ValidadorPlan validadorPlan;
    private final FabricaPlan fabricaPlan;
    private final FabricaSalidaPlan fabricaSalidaPlan;

    public PlanDtoSalida crearPlan(PlanDtoEntrada planDtoEntrada) throws ResourceNotFoundException {

        validadorPlan.validateNombrePlan(planDtoEntrada.getNombrePlan());

        Plan plan = fabricaPlan.planCrear(planDtoEntrada);

        Plan planSave = planDtoRepository.save(plan);

        return fabricaSalidaPlan.construirPlanDto(planSave);
    }
}
