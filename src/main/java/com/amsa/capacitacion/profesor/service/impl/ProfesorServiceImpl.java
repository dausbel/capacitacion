package com.amsa.capacitacion.profesor.service.impl;

import com.amsa.capacitacion.profesor.dto.ProfesorRequestDTO;
import com.amsa.capacitacion.profesor.dto.ProfesorResponseDTO;
import com.amsa.capacitacion.profesor.entities.Profesor;
import com.amsa.capacitacion.profesor.exceptions.ProfesorException;
import com.amsa.capacitacion.profesor.mapper.ProfesorDTOtoEntity;
import com.amsa.capacitacion.profesor.mapper.ProfesorEntityToDTO;
import com.amsa.capacitacion.profesor.repositories.ProfesorRepository;
import com.amsa.capacitacion.profesor.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProfesorServiceImpl implements ProfesorService {
    
    
    private final ProfesorRepository profesorRepository;
    private final ProfesorDTOtoEntity mapperToEntity;
    private final ProfesorEntityToDTO mapperToDTO;
    
    @Override
    public ProfesorResponseDTO saveProfesor(final ProfesorRequestDTO profesorRequestDTO) {
        return Optional.ofNullable(profesorRepository.save(mapperToEntity.map(profesorRequestDTO))).map(mapperToDTO::map).orElseThrow(() -> new ProfesorException("Error al salvar el profesor", HttpStatus.BAD_REQUEST));
    }
    
    @Override
    public List<ProfesorResponseDTO> getAll() {
        return profesorRepository.findAll().stream().map(mapperToDTO::map).collect(Collectors.toList());
    }
    
    @Override
    public void deleteProfesor(final Long profesorId) {
        profesorRepository.deleteById(profesorId);
    }
    
    @Override
    public Long findProfesorByName(final String profesorName) {
        return Optional.ofNullable(profesorRepository.findByName(profesorName)).map(Profesor::getId).orElse(-1L);
    }
    
    @Override
    public String profesorNamebyId(final Long id) {
        return  profesorRepository.findById(id)
                                  .map(Profesor::getName)
                                  .orElseThrow(()->new ProfesorException("Profesor no encontrado", HttpStatus.NOT_FOUND));
    }
}
