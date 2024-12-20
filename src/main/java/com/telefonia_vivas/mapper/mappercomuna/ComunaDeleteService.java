package com.telefonia_vivas.mapper.mappercomuna;

import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ComunaRepository;
import com.telefonia_vivas.validation.validadorcomuna.ValidadorComuna;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ComunaDeleteService {

    private final ValidadorComuna validadorComuna;
    private final ComunaRepository comunaRepository;

    public void eliminarComuna(Long idComuna) throws ResourceNotFoundException {

        validadorComuna.validarYObtenerComunaPorId(idComuna);

        comunaRepository.deleteById(idComuna);


    }
}

