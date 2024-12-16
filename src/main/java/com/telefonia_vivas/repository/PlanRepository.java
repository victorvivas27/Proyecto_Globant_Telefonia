package com.telefonia_vivas.repository;

import com.telefonia_vivas.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    boolean existsByNombrePlan(String nombrePlan);

    boolean existsByNombrePlanAndIdPlanNot(String nombrePlan, Long idPlan);

    @Modifying
    @Query("DELETE FROM Plan p WHERE p.id = :idPlan")
    void deleteById(@Param("idPlan") Long idPlan);
}
