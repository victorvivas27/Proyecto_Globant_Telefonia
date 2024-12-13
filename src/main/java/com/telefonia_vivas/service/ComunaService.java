package com.telefonia_vivas.service;

import com.telefonia_vivas.dto.entrada.ComunaDtoEntrada;
import com.telefonia_vivas.dto.modificar.ComunaDtoModificar;
import com.telefonia_vivas.dto.salida.ComunaDtoSalida;
import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.interfaces.IComuna;
import com.telefonia_vivas.repository.ComunaRepository;
import com.telefonia_vivas.repository.RegionRepository;
import com.telefonia_vivas.service.mapper.FabricaComuna;
import com.telefonia_vivas.service.mapper.FabricaSalidaComuna;
import com.telefonia_vivas.service.validation.ValidadorComuna;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ComunaService implements IComuna {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComunaService.class);
    private final ModelMapper modelMapper;
    private final ComunaRepository comunaRepository;
    private final RegionRepository regionRepository;
    private final ValidadorComuna validadorComuna;
    private final FabricaComuna fabricaComuna;
    private final FabricaSalidaComuna fabricaSalidaComuna;

    @Override
    public ComunaDtoSalida crearComuna(ComunaDtoEntrada comunaDtoEntrada) throws ResourceNotFoundException {
        Region region = validadorComuna.validateComunaDto(comunaDtoEntrada);

        Comuna comuna = fabricaComuna.comunaAgregar(comunaDtoEntrada, region);

        Comuna comunaSave = comunaRepository.save(comuna);

        return fabricaSalidaComuna.construirComunaDto(comunaSave);
    }


    @Override
    public List<ComunaDtoSalida> listarComuna() {
        List<Comuna> comunas = comunaRepository.findAll();

        return comunas.stream()
                .map(comuna -> modelMapper.map(comuna, ComunaDtoSalida.class))
                .toList();
    }

    @Override
    public ComunaDtoSalida obtenerComunaPorId(Long idComuna) throws ResourceNotFoundException {
        validadorComuna.validarIdComuna(idComuna);

        Comuna comuna = comunaRepository.findById(idComuna).orElse(null);


        return modelMapper.map(comuna, ComunaDtoSalida.class);
    }

    @Override
    public ComunaDtoSalida actualizarComuna(ComunaDtoModificar comunaDtoModificar) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public void eliminarComuna(Long idComuna) throws ResourceNotFoundException {
        validadorComuna.validarIdComuna(idComuna);

        comunaRepository.deleteById(idComuna);

        LOGGER.warn("Comuna eliminada con el id: " + idComuna);
    }
}
