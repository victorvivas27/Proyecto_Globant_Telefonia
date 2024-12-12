package com.telefonia_vivas.service;

import com.telefonia_vivas.constants.ConstanteComuna;
import com.telefonia_vivas.dto.entrada.ComunaDtoEntrada;
import com.telefonia_vivas.dto.modificar.ComunaDtoModificar;
import com.telefonia_vivas.dto.salida.ComunaDtoSalida;
import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.interfaces.IComuna;
import com.telefonia_vivas.repository.ComunaRepository;
import com.telefonia_vivas.util.SalidaJson;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComunaService implements IComuna {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComunaService.class);
    private final ComunaServiceSave comunaServiceSave;
    private final ModelMapper modelMapper;
    private final ComunaRepository comunaRepository;

    @Override
    public ComunaDtoSalida crearComuna(ComunaDtoEntrada comunaDtoEntrada) {
        Comuna comuna = modelMapper.map(comunaDtoEntrada, Comuna.class);
        Comuna comunaCreada = comunaServiceSave.crearComuna(comuna);

        ComunaDtoSalida comunaDtoSalida = modelMapper.map(comunaCreada, ComunaDtoSalida.class);
        RegionDtoSalida regionDtoSalida = modelMapper.map(comunaCreada.getRegion(), RegionDtoSalida.class);


        comunaDtoSalida.setRegion(regionDtoSalida);

        LOGGER.info(ConstanteComuna.COMUNAS + "\n" + SalidaJson.toString(comunaDtoSalida));

        return comunaDtoSalida;
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
        return null;
    }

    @Override
    public ComunaDtoSalida actualizarComuna(ComunaDtoModificar comunaDtoModificar) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public void eliminarComuna(Long idComuna) throws ResourceNotFoundException {

    }
}
