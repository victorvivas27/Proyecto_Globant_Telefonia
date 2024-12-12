package com.telefonia_vivas.repository;

import com.telefonia_vivas.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByRun(String run);

    boolean existsByRunAndIdClienteNot(String run, Long idCliente);
}
