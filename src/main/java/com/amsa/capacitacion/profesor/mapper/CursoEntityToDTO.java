package com.amsa.capacitacion.profesor.mapper;

import com.amsa.capacitacion.profesor.dto.CursoRequestDTO;
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
public class CursoEntityToDTO implements IMapper<Curso, CursoRequestDTO> {
    
    private final ProfesorService profesorService;
    
    @Override
    public Curso map(final CursoRequestDTO in) {
        return Optional.of(profesorService.findProfesorByName(in.getProfesorName()))
                       .filter(profesorId -> profesorId > 0L)
                       .map(profesorId -> Curso.builder().profesorId(profesorId).name(in.getName()).build())
                       .orElseThrow(() -> new MappingException("No se pudo convertir la entidad", HttpStatus.BAD_REQUEST));
        
    }
}
