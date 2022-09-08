package com.amsa.capacitacion.profesor.repositories;

import com.amsa.capacitacion.profesor.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    
    Optional<Curso> findByProfesorId(Long profesorId);
    
    List<Curso> findAllByProfesorId(Long profesorId);
}
