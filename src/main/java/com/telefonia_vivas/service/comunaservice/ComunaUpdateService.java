package com.telefonia_vivas.service.comunaservice;

import com.telefonia_vivas.constants.ConstanteComuna;
import com.telefonia_vivas.dto.modificar.ComunaDtoModificar;
import com.telefonia_vivas.dto.salida.ComunaDtoSalida;
import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ComunaRepository;
import com.telefonia_vivas.repository.RegionRepository;
import com.telefonia_vivas.service.mapper.fabricacomuna.FabricaComuna;
import com.telefonia_vivas.service.mapper.fabricacomuna.FabricaSalidaComuna;
import com.telefonia_vivas.service.validation.validadorcomuna.ValidadorComuna;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ComunaUpdateService {
    private final ModelMapper modelMapper;
    private final ComunaRepository comunaRepository;
    private final RegionRepository regionRepository;
    private final ValidadorComuna validadorComuna;
    private final FabricaComuna fabricaComuna;
    private final FabricaSalidaComuna fabricaSalidaComuna;

    public ComunaDtoSalida actualizarComuna(ComunaDtoModificar comunaDtoModificar) throws ResourceNotFoundException {
        validadorComuna.validateComunaDtoModificar(comunaDtoModificar);

        Comuna comunaExistente = comunaRepository.findById(comunaDtoModificar.getIdComuna())
                .orElseThrow(() -> new ResourceNotFoundException(
                        ConstanteComuna.ID_COMUNA_NO_EXISTE + comunaDtoModificar.getIdComuna()));

        comunaExistente = fabricaComuna.comunaModificar(comunaDtoModificar, comunaExistente);

        Comuna comunaSave = comunaRepository.save(comunaExistente);

        return fabricaSalidaComuna.construirComunaDto(comunaSave);
    }
}
