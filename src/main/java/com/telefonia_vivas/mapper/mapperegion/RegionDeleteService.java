package com.telefonia_vivas.mapper.mapperegion;

import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.repository.RegionRepository;
import com.telefonia_vivas.validation.validadorregio.ValidadorRegion;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class RegionDeleteService {

    private final ModelMapper modelMapper;
    private final RegionRepository regionRepository;
    private final ValidadorRegion validadorRegion;

    public void eliminarRegion(Long idRegion) throws ResourceNotFoundException {

        validadorRegion.validarIdRegion(idRegion);

        regionRepository.deleteById(idRegion);
    }
}
