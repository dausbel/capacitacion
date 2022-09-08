package com.amsa.capacitacion.profesor.repositories;

import com.amsa.capacitacion.profesor.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    
    Profesor findByName(String name);
    
    Optional<Profesor> findFirstByName(String name);
    
    Optional<Profesor> findById(Long profesorId);
}
