package com.telefonia_vivas.service;


import com.telefonia_vivas.constants.ConstanteComuna;
import com.telefonia_vivas.constants.ConstanteRegion;
import com.telefonia_vivas.entity.Comuna;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.NombreExistenteException;
import com.telefonia_vivas.exception.RegionNotFoundException;
import com.telefonia_vivas.repository.ComunaRepository;
import com.telefonia_vivas.repository.RegionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Transactional
public class ComunaServiceSave {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComunaServiceSave.class);

    private final ModelMapper modelMapper;
    private final ComunaRepository comunaRepository;
    private final RegionRepository regionRepository;


    public Comuna crearComuna(Comuna comuna) {

        String nombre = comuna.getNombreComuna();


        if (comunaRepository.existsByNombreComuna(nombre)) {

            throw new NombreExistenteException(ConstanteComuna.NOMBRE_EXCISTE);
        }


        Region region = regionRepository.findById(comuna.getRegion().getIdRegion())
                .orElseThrow(() -> new RegionNotFoundException(ConstanteRegion.REGION_NO_EXISTE));


        comuna.setRegion(region);


        Comuna comunaCreada = new Comuna();
        comunaCreada.setNombreComuna(comuna.getNombreComuna());
        comunaCreada.setRegion(comuna.getRegion());

        return comunaRepository.save(comunaCreada);


    }
}
