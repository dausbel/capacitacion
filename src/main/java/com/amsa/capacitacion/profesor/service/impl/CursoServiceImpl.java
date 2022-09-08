package com.amsa.capacitacion.profesor.service.impl;

import com.amsa.capacitacion.profesor.dto.CursoRequestDTO;
import com.amsa.capacitacion.profesor.dto.CursoResponseDTO;
import com.amsa.capacitacion.profesor.entities.Profesor;
import com.amsa.capacitacion.profesor.exceptions.CursoException;
import com.amsa.capacitacion.profesor.mapper.CursoDTOToEntity;
import com.amsa.capacitacion.profesor.mapper.CursoEntityToDTO;
import com.amsa.capacitacion.profesor.repositories.CursoRepository;
import com.amsa.capacitacion.profesor.repositories.ProfesorRepository;
import com.amsa.capacitacion.profesor.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CursoServiceImpl implements CursoService {
    
    private final CursoRepository cursoRepository;
    private final CursoEntityToDTO mapperToDTO;
    private final CursoDTOToEntity mapperToEntity;
    private final ProfesorRepository profesorRepository;
    @Override
    public CursoResponseDTO saveCurso(final CursoRequestDTO cursoRequestDTO) {
        return Optional.ofNullable(cursoRepository.save(mapperToDTO.map(cursoRequestDTO))).map(mapperToEntity::map).orElseThrow(() -> new CursoException("Error al salvar el curso", HttpStatus.BAD_REQUEST));
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<CursoResponseDTO> getAll() {
        return cursoRepository.findAll().stream().map(mapperToEntity::map).collect(Collectors.toList());
    }
    
    @Override
    public void deleteCurso(final Long cursoId) {
        cursoRepository.deleteById(cursoId);
    }
    
    @Override
    public List<CursoResponseDTO> findAllCursoByProfesorName(final String profesorName) {
        return profesorRepository.findFirstByName(profesorName)
                                 .map(Profesor::getId).map(profesorId ->
                                       cursoRepository.findAllByProfesorId(profesorId)
                                       .stream()
                                       .map(mapperToEntity::map)
                                       .collect(Collectors.toList()))
                                 .orElse(new ArrayList<>());
     }
    
    @Override
    public List<CursoResponseDTO> findAllCursoByProfesorId(final Long profesorId) {
       return cursoRepository.findAllByProfesorId(profesorId)
                       .stream()
                       .map(mapperToEntity::map)
                       .collect(Collectors.toList());
    }
}
