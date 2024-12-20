package com.telefonia_vivas.factory.planservice;

import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.PlanRepository;
import com.telefonia_vivas.validation.validadorplan.ValidadorPlan;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class PlanDeleteService {

    private final ModelMapper modelMapper;
    private final PlanRepository planRepository;
    private final ValidadorPlan validadorPlan;

    public void eliminarPlan(Long idPlan) throws ResourceNotFoundException {

        validadorPlan.validarIdPlan(idPlan);

        planRepository.deleteById(idPlan);
    }
}
