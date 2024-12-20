package com.telefonia_vivas.factory.comunaservice;

import com.telefonia_vivas.dto.entrada.ComunaDtoEntrada;
import com.telefonia_vivas.dto.salida.ComunaDtoSalida;
import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.mapper.mappercomuna.FabricaComuna;
import com.telefonia_vivas.mapper.mappercomuna.FabricaSalidaComuna;
import com.telefonia_vivas.repository.ComunaRepository;
import com.telefonia_vivas.repository.RegionRepository;
import com.telefonia_vivas.validation.validadorcomuna.ValidadorComuna;
import com.telefonia_vivas.validation.validadorregio.ValidadorRegion;
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
    private  final ValidadorRegion validadorRegion;
    private  final RegionRepository  regionRepository;

    public ComunaDtoSalida crearComuna(ComunaDtoEntrada comunaDtoEntrada) throws ResourceNotFoundException {

        validadorComuna.validateNombreComuna(comunaDtoEntrada.getNombreComuna());

       Region region=  validadorRegion.validarIdRegion(comunaDtoEntrada.getIdRegion());

        Comuna comuna = fabricaComuna.comunaAgregar(comunaDtoEntrada, region);

        Comuna comunaSave = comunaRepository.save(comuna);

        return fabricaSalidaComuna.construirComunaDto(comunaSave);
    }
}
