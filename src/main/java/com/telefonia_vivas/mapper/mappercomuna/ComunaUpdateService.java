package com.telefonia_vivas.mapper.mappercomuna;

import com.telefonia_vivas.constants.ConstanteComuna;
import com.telefonia_vivas.dto.modificar.ComunaDtoModificar;
import com.telefonia_vivas.dto.salida.ComunaDtoSalida;
import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.ComunaRepository;
import com.telefonia_vivas.repository.RegionRepository;
import com.telefonia_vivas.validation.validadorcomuna.ValidadorComuna;
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


    public ComunaDtoSalida actualizarComuna(ComunaDtoModificar comunaDtoModificar)
            throws ResourceNotFoundException {
        Comuna comunaExistente= validadorComuna.validarYObtenerComunaPorId(
                comunaDtoModificar.getIdComuna()
        );

        // Validar nombre si fue modificado
        if (!comunaExistente.getNombreComuna().equals(comunaDtoModificar.getNombreComuna())) {
            validadorComuna.validarNombreComunaParaModificacion(
                    comunaDtoModificar.getNombreComuna(),
                    comunaDtoModificar.getIdComuna()
            );
        }

        modelMapper.map(comunaDtoModificar, comunaExistente);

        Comuna comunaSave = comunaRepository.save(comunaExistente);

        return modelMapper.map(comunaSave, ComunaDtoSalida.class);
    }
}
