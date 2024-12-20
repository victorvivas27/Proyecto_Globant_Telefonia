package com.telefonia_vivas.factory.regionservice;

import com.telefonia_vivas.constants.ConstanteRegion;
import com.telefonia_vivas.dto.modificar.RegionDtoModificar;
import com.telefonia_vivas.dto.salida.RegionDtoSalida;
import com.telefonia_vivas.entity.Region;
import com.telefonia_vivas.exception.ResourceNotFoundException;
import com.telefonia_vivas.mapper.mapperegion.FabricaRegion;
import com.telefonia_vivas.mapper.mapperegion.FabricaSalidaRegion;
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
    private final FabricaRegion fabricaRegion;
    private final FabricaSalidaRegion fabricaSalidaRegion;

    public RegionDtoSalida actualizarRegion(RegionDtoModificar regionDtoModificar) throws ResourceNotFoundException {
        validadorRegion.validateRegionDtoModificar(regionDtoModificar);

        Region regionExistente = regionRepository.findById(regionDtoModificar.getIdRegion())
                .orElseThrow(() -> new ResourceNotFoundException(
                        ConstanteRegion.ID_REGION_NO_EXISTE + regionDtoModificar.getIdRegion()));

        regionExistente = fabricaRegion.regionModificar(regionDtoModificar, regionExistente);

        Region regionSave = regionRepository.save(regionExistente);

        return fabricaSalidaRegion.construirRegionDto(regionSave);
    }
}
