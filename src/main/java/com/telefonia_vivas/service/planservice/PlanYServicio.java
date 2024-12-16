package com.telefonia_vivas.service.planservice;

import com.telefonia_vivas.dto.salida.PlanDtoSalida;
import com.telefonia_vivas.entity.Plan;
import com.telefonia_vivas.entity.Servicio;
import com.telefonia_vivas.repository.PlanRepository;
import com.telefonia_vivas.repository.ServicioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class PlanYServicio {

    private final PlanRepository planRepository;
    private final ServicioRepository servicioRepository;
    private final ModelMapper modelMapper;

    public PlanDtoSalida agregarServicioAPlan(Long idPlan, Long idServicio) {

        Plan plan = planRepository.findById(idPlan)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));


        Servicio servicio = servicioRepository.findById(idServicio)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));


        plan.getServicios().add(servicio);


        planRepository.save(plan);

        return modelMapper.map(plan, PlanDtoSalida.class);
    }
}
