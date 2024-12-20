package com.telefonia_vivas.mapper.mapperegion;

import com.telefonia_vivas.constants.ConstanteRegion;
import com.telefonia_vivas.dto.modificar.RegionDtoModificar;
import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.entity.Region;
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
public class RegionUpdateService {

    private final ModelMapper modelMapper;
    private final RegionRepository regionRepository;
    private final ValidadorRegion validadorRegion;


    public RegionDtoSalida actualizarRegion(RegionDtoModificar regionDtoModificar)
            throws ResourceNotFoundException {

       Region regionExistente= validadorRegion.validarIdRegion(
               regionDtoModificar.getIdRegion());

        // Validar nombre si fue modificado
        if (!regionExistente.getNombreRegion().equals(regionDtoModificar.getNombreRegion())) {
            validadorRegion.validarNombreComunaParaModificacion(
                    regionDtoModificar.getNombreRegion(),
                    regionDtoModificar.getIdRegion()
            );
        }


        modelMapper.map(regionDtoModificar, regionExistente);

        Region regionSave = regionRepository.save(regionExistente);

        return modelMapper.map(regionSave, RegionDtoSalida.class);
    }
}
