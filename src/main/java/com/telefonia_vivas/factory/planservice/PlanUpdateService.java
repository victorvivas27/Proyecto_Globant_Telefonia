package com.telefonia_vivas.factory.planservice;

import com.telefonia_vivas.constants.ConstantePlan;
import com.telefonia_vivas.dto.modificar.PlanDtoModificar;
import com.telefonia_vivas.dto.salida.PlanDtoSalida;
import com.telefonia_vivas.entity.Plan;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.mapper.mapperplan.FabricaPlan;
import com.telefonia_vivas.mapper.mapperplan.FabricaSalidaPlan;
import com.telefonia_vivas.repository.PlanRepository;
import com.telefonia_vivas.validation.validadorplan.ValidadorPlan;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class PlanUpdateService {

    private final ModelMapper modelMapper;
    private final PlanRepository planRepository;
    private final ValidadorPlan validadorPlan;
    private final FabricaPlan fabricaPlan;
    private final FabricaSalidaPlan fabricaSalidaPlan;

    public PlanDtoSalida actualizarPLan(PlanDtoModificar planDtoModificar) throws ResourceNotFoundException {

        validadorPlan.validatePlanDtoModificar(planDtoModificar);

        Plan planExistente = planRepository.findById(planDtoModificar.getIdPlan())
                .orElseThrow(() -> new ResourceNotFoundException(
                        ConstantePlan.ID_PLAN_NO_EXISTE + planDtoModificar.getIdPlan()));

        planExistente = fabricaPlan.planModificar(planDtoModificar, planExistente);

        Plan planSave = planRepository.save(planExistente);

        return fabricaSalidaPlan.construirPlanDto(planSave);
    }
}
