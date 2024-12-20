package com.telefonia_vivas.mapper.mappercomuna;

import com.telefonia_vivas.dto.entrada.ComunaDtoEntrada;
import com.telefonia_vivas.dto.salida.ComunaDtoSalida;
import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ComunaRepository;
import com.telefonia_vivas.repository.RegionRepository;
import com.telefonia_vivas.validation.validadorcomuna.ValidadorComuna;
import com.telefonia_vivas.validation.validadorregio.ValidadorRegion;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ComunaCreationService {
    private final ValidadorComuna validadorComuna;
    private final ComunaRepository comunaRepository;
    private final ValidadorRegion validadorRegion;
    private final RegionRepository regionRepository;
    private final ModelMapper modelMapper;

    public ComunaDtoSalida crearComuna(ComunaDtoEntrada comunaDtoEntrada)
            throws ResourceNotFoundException {

        validadorComuna.validateNombreComuna(comunaDtoEntrada.getNombreComuna());

        Region region = validadorRegion.validarIdRegion(comunaDtoEntrada.getIdRegion());

        Comuna comuna = Comuna.builder()
                .nombreComuna(comunaDtoEntrada.getNombreComuna())
                .region(region)
                .build();

        region.getComunas().add(comuna);

        Comuna comunaSave = comunaRepository.save(comuna);

        return modelMapper.map(comunaSave, ComunaDtoSalida.class);
    }
}
