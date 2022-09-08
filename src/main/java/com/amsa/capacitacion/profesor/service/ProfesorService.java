package com.amsa.capacitacion.profesor.service;

import com.amsa.capacitacion.profesor.dto.ProfesorRequestDTO;
import com.amsa.capacitacion.profesor.dto.ProfesorResponseDTO;

import java.util.List;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
public interface ProfesorService {
    
    ProfesorResponseDTO saveProfesor(ProfesorRequestDTO profesorRequestDTO);
    
    List<ProfesorResponseDTO> getAll();
    
    void deleteProfesor(Long profesorId);
    
    Long findProfesorByName(String profesorName);
    
    String profesorNamebyId(Long id);
    
}
