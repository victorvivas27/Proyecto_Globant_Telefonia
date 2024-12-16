package com.telefonia_vivas.service.validation.validadorplan;

import com.telefonia_vivas.constants.ConstantePlan;
import com.telefonia_vivas.dto.modificar.PlanDtoModificar;
import com.telefonia_vivas.entity.Plan;
import com.telefonia_vivas.exception.NombreExistenteException;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.PlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidadorPlan {

    private final PlanRepository planRepository;

    public void validateNombrePlan(String nombrePlan) {
        if (nombrePlan == null || nombrePlan.isBlank()) {
            throw new IllegalArgumentException(ConstantePlan.NOMBRE_PLAN_NOT_NULL);
        }
        if (planRepository.existsByNombrePlan(nombrePlan)) {
            throw new NombreExistenteException(ConstantePlan.NOMBRE_EXISTE);
        }

    }

    public void validateNombrePlanModificacion(String nombrePlan, Long idPlan) {
        if (nombrePlan == null || nombrePlan.isBlank()) {
            throw new IllegalArgumentException(ConstantePlan.NOMBRE_PLAN_NOT_NULL);
        }

        // Verificar si el nombre ya existe en otro plan, excluyendo el plan que se está modificando
        if (planRepository.existsByNombrePlanAndIdPlanNot(nombrePlan, idPlan)) {
            throw new NombreExistenteException(ConstantePlan.NOMBRE_EXISTE);
        }
    }

    public void validarIdPlan(Long idPlan) throws ResourceNotFoundException {
        if (idPlan == null || !planRepository.existsById(idPlan)) {
            throw new ResourceNotFoundException(ConstantePlan.ID_PLAN_NO_EXISTE + idPlan);
        }
    }

    public void validatePlanDtoModificar(PlanDtoModificar planDtoModificar) throws ResourceNotFoundException {
        validarIdPlan(planDtoModificar.getIdPlan());

        Plan planExistente = planRepository.findById(planDtoModificar.getIdPlan())
                .orElseThrow(() -> new ResourceNotFoundException(
                        ConstantePlan.ID_PLAN_NO_EXISTE + planDtoModificar.getIdPlan()));

        // Verificar si el nombre del plan ha cambiado
        if (!planExistente.getNombrePlan().equals(planDtoModificar.getNombrePlan())) {
            validateNombrePlanModificacion(planDtoModificar.getNombrePlan(), planDtoModificar.getIdPlan());
        }
    }
}
