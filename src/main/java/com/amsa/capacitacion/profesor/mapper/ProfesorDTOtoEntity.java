package com.amsa.capacitacion.profesor.mapper;

import com.amsa.capacitacion.profesor.dto.ProfesorRequestDTO;
import com.amsa.capacitacion.profesor.dto.ProfesorResponseDTO;
import com.amsa.capacitacion.profesor.entities.Profesor;
import org.springframework.stereotype.Component;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
@Component
public class ProfesorDTOtoEntity implements IMapper< Profesor, ProfesorRequestDTO> {
    
    @Override
    public Profesor map(final ProfesorRequestDTO in) {
        return Profesor.builder()
                .address(in.getAddress())
                .email(in.getEmail())
                .name(in.getName())
                .phone(in.getPhone())
                .build();
       
    }
}
