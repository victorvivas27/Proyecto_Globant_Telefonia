package com.telefonia_vivas.factory.planservice;

import com.telefonia_vivas.dto.salida.PlanDtoSalida;
import com.telefonia_vivas.entity.Plan;
import com.telefonia_vivas.entity.Servicio;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.PlanRepository;
import com.telefonia_vivas.repository.ServicioRepository;
import com.telefonia_vivas.validation.validadorplan.ValidadorPlan;
import com.telefonia_vivas.validation.validadorservicio.ValidadorServicio;
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
    private final ValidadorPlan validadorPlan;
    private final ValidadorServicio validadorServicio;

    public PlanDtoSalida agregarServicioAPlan(Long idPlan, Long idServicio) throws ResourceNotFoundException {

        Plan plan = validadorPlan.validarIdPlan(idPlan);

        Servicio servicio = validadorServicio.validarIdServicio(idServicio);

        plan.getServicios().add(servicio);

        planRepository.save(plan);

        return modelMapper.map(plan, PlanDtoSalida.class);
    }
}
