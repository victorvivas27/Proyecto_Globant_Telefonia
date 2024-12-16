package com.telefonia_vivas.service.planservice;

import com.telefonia_vivas.dto.salida.PlanDtoSalida;
import com.telefonia_vivas.entity.Plan;
import com.telefonia_vivas.repository.PlanRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanListService {

    private final PlanRepository planRepository;
    private final ModelMapper modelMapper;

    public List<PlanDtoSalida> listarPlanes() {

        List<Plan> planes = planRepository.findAll();

        return planes.stream()
                .map(plan -> modelMapper.map(plan, PlanDtoSalida.class))
                .toList();
    }
}
