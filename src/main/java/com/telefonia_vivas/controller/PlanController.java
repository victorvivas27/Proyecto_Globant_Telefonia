package com.telefonia_vivas.controller;

import com.telefonia_vivas.constants.ConstantePlan;
import com.telefonia_vivas.dto.entrada.PlanDtoEntrada;
import com.telefonia_vivas.dto.modificar.PlanDtoModificar;
import com.telefonia_vivas.dto.salida.PlanDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.service.PlanService;
import com.telefonia_vivas.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/v1/plan")
public class PlanController {

    private final PlanService planService;

    @PostMapping
    public ResponseEntity<ApiResponse<PlanDtoSalida>> crearPlan(
            @RequestBody @Valid PlanDtoEntrada planDtoEntrada) throws ResourceNotFoundException {

        PlanDtoSalida planDtoSalida = planService.crearPlan(planDtoEntrada);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        ConstantePlan.PLAN_CREADO,
                        HttpStatus.CREATED.value(),
                        planDtoSalida
                ));
    }

    @PostMapping("/{idPlan}/servicios/{idServicio}")
    public ResponseEntity<PlanDtoSalida> agregarServicioAPlan(
            @PathVariable Long idPlan,
            @PathVariable Long idServicio) throws ResourceNotFoundException {
        PlanDtoSalida planDtoSalida = planService.agregarServicioAPlan(idPlan, idServicio);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        ConstantePlan.PLAN_CREADO,
                        HttpStatus.CREATED.value(),
                        planDtoSalida
                ).getData());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PlanDtoSalida>>> listarPlan() {

        List<PlanDtoSalida> planDtoSalidas = planService.listarPlanes();

        ApiResponse<List<PlanDtoSalida>> response = new ApiResponse<>(
                ConstantePlan.PLAN_LIST,
                HttpStatus.OK.value(),
                planDtoSalidas
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idPlan}")
    public ResponseEntity<ApiResponse<PlanDtoSalida>> buscarPlanID(
            @PathVariable Long idPlan) throws ResourceNotFoundException {

        PlanDtoSalida planDtoSalida = planService.obtenerPlanPorId(idPlan);

        ApiResponse<PlanDtoSalida> response = new ApiResponse<>(

                ConstantePlan.PLAN_ENCONTRADA,
                HttpStatus.OK.value(),
                planDtoSalida
        );

        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    public ResponseEntity<ApiResponse<PlanDtoSalida>> planModificar(
            @RequestBody @Valid PlanDtoModificar planDtoModificar) throws ResourceNotFoundException {

        PlanDtoSalida planDtoSalida = planService.actualizarPLan(planDtoModificar);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        ConstantePlan.PLAN_MODIFICADO,
                        HttpStatus.CREATED.value(),
                        planDtoSalida
                ));
    }


    @DeleteMapping("/{idPlan}")
    public ResponseEntity<ApiResponse<Long>> eliminarRegion(
            @PathVariable Long idPlan) throws ResourceNotFoundException {

        planService.eliminarPlan(idPlan);

        ApiResponse<Long> response = new ApiResponse(
                ConstantePlan.PLAN_ELIMINADO,
                HttpStatus.OK.value(),
                idPlan
        );
        return ResponseEntity.ok(response);
    }
}
