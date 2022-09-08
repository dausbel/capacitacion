package com.amsa.capacitacion.profesor.controller;

import com.amsa.capacitacion.profesor.dto.CursoRequestDTO;
import com.amsa.capacitacion.profesor.dto.CursoResponseDTO;
import com.amsa.capacitacion.profesor.service.CursoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("api/curso")
@RestController
@Validated
public class CursoController {
    
    private final CursoService cursoService;
    
    @PostMapping("/v1/guardar")
    public ResponseEntity<CursoResponseDTO> saveProfesor(@Valid @RequestBody CursoRequestDTO cursoRequestDTO) {
        log.info("Salvando Curso: " + cursoRequestDTO);
        return new ResponseEntity<>(this.cursoService.saveCurso(cursoRequestDTO), HttpStatus.CREATED);
    }
    
    
    @GetMapping("/v1/all")
    public ResponseEntity<List<CursoResponseDTO>> getAllCurso() {
        log.info("Obteniendo todos los cursos");
        return new ResponseEntity<>(this.cursoService.getAll(), HttpStatus.OK);
    }
    
    @DeleteMapping("/v1/{cursoId}")
    public ResponseEntity<Void> deleteCurso(@PathVariable("cursoId") Long id) {
        log.info("Eliminando curso por id: " + id);
        this.cursoService.deleteCurso(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/v1/all/{profesorName}")
    public ResponseEntity<List<CursoResponseDTO>> getAllCursoByProfesorName(
        @NotNull(message = "No puede ser vacio o nulo") @PathVariable("profesorName") String profesorName) {
        log.info("Obteniendo todos los curso por nombre del profesor: " + profesorName);
        return new ResponseEntity<>(this.cursoService.findAllCursoByProfesorName(profesorName), HttpStatus.OK);
    }
    
    
    @GetMapping("/v1/allById/{profesorId}")
    public ResponseEntity<List<CursoResponseDTO>> getAllCursobyProfesorId(
        @NotNull(message = "No puede ser vacio o nulo") @PathVariable("profesorName") long profesorId) {
        log.info("Obteniendo todos los curso por id del profesor: " + profesorId);
        return new ResponseEntity<>(this.cursoService.findAllCursoByProfesorId(profesorId), HttpStatus.OK);
    }
}
