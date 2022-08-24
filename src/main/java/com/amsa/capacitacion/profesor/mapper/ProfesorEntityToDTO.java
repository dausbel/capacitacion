package com.amsa.capacitacion.profesor.mapper;

import com.amsa.capacitacion.profesor.dto.ProfesorResponseDTO;
import com.amsa.capacitacion.profesor.entities.Profesor;
import org.springframework.stereotype.Component;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
@Component
public class ProfesorEntityToDTO implements IMapper<ProfesorResponseDTO, Profesor> {
    
    @Override
    public ProfesorResponseDTO map(final Profesor in) {
        return ProfesorResponseDTO
            .builder()
            .address(in.getAddress())
            .email(in.getEmail())
            .name(in.getName())
            .phone(in.getPhone())
            .build();
    }
}
