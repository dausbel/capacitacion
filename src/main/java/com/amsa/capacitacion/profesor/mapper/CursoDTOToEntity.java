package com.amsa.capacitacion.profesor.mapper;

import com.amsa.capacitacion.profesor.dto.CursoResponseDTO;
import com.amsa.capacitacion.profesor.entities.Curso;
import com.amsa.capacitacion.profesor.exceptions.MappingException;
import com.amsa.capacitacion.profesor.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CursoDTOToEntity implements IMapper<CursoResponseDTO, Curso> {
    private final ProfesorService profesorService;
    
    @Override
    public CursoResponseDTO map(final Curso in) {
     
        return Optional.of(profesorService.profesorNamebyId(in.getProfesorId()))
                .map(profesorName-> CursoResponseDTO.builder()
                                                 .name(in.getName())
                                                 .profesorName(profesorName)
                                                 .build()).orElseThrow(()-> new MappingException("No se pudo convertir la entidad", HttpStatus.BAD_REQUEST));
     
    }
}
