package com.telefonia_vivas.service.comunaservice;

import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ComunaRepository;
import com.telefonia_vivas.service.validation.validadorcomuna.ValidadorComuna;
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

        validadorComuna.validarIdComuna(idComuna);

        comunaRepository.deleteById(idComuna);


    }
}

