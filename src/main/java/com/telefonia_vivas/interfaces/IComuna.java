package com.telefonia_vivas.interfaces;

import com.telefonia_vivas.dto.entrada.ComunaDtoEntrada;
import com.telefonia_vivas.dto.modificar.ComunaDtoModificar;
import com.telefonia_vivas.dto.salida.ComunaDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;

import java.util.List;

public interface IComuna {

    ComunaDtoSalida crearComuna(ComunaDtoEntrada comunaDtoEntrada) throws ResourceNotFoundException;

    List<ComunaDtoSalida> listarComuna();

    ComunaDtoSalida obtenerComunaPorId(Long idComuna) throws ResourceNotFoundException;

    ComunaDtoSalida actualizarComuna(ComunaDtoModificar comunaDtoModificar) throws ResourceNotFoundException;

    void eliminarComuna(Long idComuna) throws ResourceNotFoundException;

}
