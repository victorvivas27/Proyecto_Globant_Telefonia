package com.telefonia_vivas.service.planservice;

import com.telefonia_vivas.dto.salida.PlanDtoSalida;
import com.telefonia_vivas.entity.Plan;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.PlanRepository;
import com.telefonia_vivas.service.validation.validadorplan.ValidadorPlan;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlanGetByIdService {

    private final ModelMapper modelMapper;
    private final PlanRepository planRepository;
    private final ValidadorPlan validadorPlan;

    public PlanDtoSalida obtenerPlanPorId(Long idPlan) throws ResourceNotFoundException {

        validadorPlan.validarIdPlan(idPlan);

        Plan plan = planRepository.findById(idPlan).orElse(null);

        return modelMapper.map(plan, PlanDtoSalida.class);
    }

}
