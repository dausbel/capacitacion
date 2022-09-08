package com.amsa.capacitacion.profesor.service;

import com.amsa.capacitacion.profesor.dto.CursoRequestDTO;
import com.amsa.capacitacion.profesor.dto.CursoResponseDTO;
import com.amsa.capacitacion.profesor.dto.CursoRequestDTO;
import com.amsa.capacitacion.profesor.dto.CursoResponseDTO;

import java.util.List;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
public interface CursoService {
    
    CursoResponseDTO saveCurso(CursoRequestDTO cursoRequestDTO);
    
    List<CursoResponseDTO> getAll();
    
    void deleteCurso(Long cursoId);
    
    List<CursoResponseDTO> findAllCursoByProfesorName(String profesorName);
    
    List<CursoResponseDTO> findAllCursoByProfesorId(Long profesorId);
    
   
    
}
