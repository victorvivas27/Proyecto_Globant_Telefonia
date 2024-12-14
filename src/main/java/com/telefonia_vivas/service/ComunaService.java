package com.telefonia_vivas.service;

import com.telefonia_vivas.dto.entrada.ComunaDtoEntrada;
import com.telefonia_vivas.dto.modificar.ComunaDtoModificar;
import com.telefonia_vivas.dto.salida.ComunaDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.interfaces.IComuna;
import com.telefonia_vivas.service.comunaservice.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ComunaService implements IComuna {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComunaService.class);

    private final ComunaCreationService comunaCreationService;
    private final ComunaListService comunaListService;
    private final ComunaGetByIdService comunaGetByIdService;
    private final ComunaUpdateService comunaUpdateService;
    private final ComunaDeleteService comunaDeleteService;

    @Override
    public ComunaDtoSalida crearComuna(ComunaDtoEntrada comunaDtoEntrada) throws ResourceNotFoundException {

        return comunaCreationService.crearComuna(comunaDtoEntrada);
    }


    @Override
    public List<ComunaDtoSalida> listarComuna() {

        return comunaListService.listarComunas();
    }

    @Override
    public ComunaDtoSalida obtenerComunaPorId(Long idComuna) throws ResourceNotFoundException {

        return comunaGetByIdService.obtenerComunaPorId(idComuna);
    }

    @Override
    public ComunaDtoSalida actualizarComuna(ComunaDtoModificar comunaDtoModificar) throws ResourceNotFoundException {

        return comunaUpdateService.actualizarComuna(comunaDtoModificar);
    }

    @Override
    public void eliminarComuna(Long idComuna) throws ResourceNotFoundException {

        comunaDeleteService.eliminarComuna(idComuna);
    }
}
