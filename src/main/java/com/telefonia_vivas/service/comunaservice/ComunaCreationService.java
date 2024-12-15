package com.telefonia_vivas.service.comunaservice;

import com.telefonia_vivas.dto.entrada.ComunaDtoEntrada;
import com.telefonia_vivas.dto.salida.ComunaDtoSalida;
import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ComunaRepository;
import com.telefonia_vivas.service.mapper.fabricacomuna.FabricaComuna;
import com.telefonia_vivas.service.mapper.fabricacomuna.FabricaSalidaComuna;
import com.telefonia_vivas.service.validation.validadorcomuna.ValidadorComuna;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ComunaCreationService {
    private final ValidadorComuna validadorComuna;
    private final ComunaRepository comunaRepository;
    private final FabricaComuna fabricaComuna;
    private final FabricaSalidaComuna fabricaSalidaComuna;

    public ComunaDtoSalida crearComuna(ComunaDtoEntrada comunaDtoEntrada) throws ResourceNotFoundException {

        Region region = validadorComuna.validateComunaDto(comunaDtoEntrada);

        Comuna comuna = fabricaComuna.comunaAgregar(comunaDtoEntrada, region);

        Comuna comunaSave = comunaRepository.save(comuna);

        return fabricaSalidaComuna.construirComunaDto(comunaSave);
    }
}
