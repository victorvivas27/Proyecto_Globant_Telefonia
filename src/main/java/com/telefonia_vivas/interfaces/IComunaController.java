package com.telefonia_vivas.interfaces;

import com.telefonia_vivas.dto.entrada.ComunaDtoEntrada;
import com.telefonia_vivas.dto.salida.ComunaDtoSalida;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.util.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IComunaController {

    ResponseEntity<ApiResponse<ComunaDtoSalida>> crearComuna(ComunaDtoEntrada comunaDtoEntrada) throws ResourceNotFoundException;

    ResponseEntity<ApiResponse<List<ComunaDtoSalida>>> listarComuna();

    ResponseEntity<ApiResponse<ComunaDtoSalida>> buscarComunaID(Long idComuna) throws ResourceNotFoundException;

    ResponseEntity<ApiResponse<ComunaDtoSalida>> comunaModificar(ComunaDtoEntrada comunaDtoEntrada) throws ResourceNotFoundException;

    ResponseEntity<ApiResponse<Long>> eliminarComuna(Long idComuna) throws ResourceNotFoundException;
}
