package com.amsa.capacitacion.profesor.controller;

import com.amsa.capacitacion.profesor.dto.ProfesorRequestDTO;
import com.amsa.capacitacion.profesor.dto.ProfesorResponseDTO;
import com.amsa.capacitacion.profesor.service.ProfesorService;
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
import java.util.List;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("api/profesor")
@RestController

public class ProfesorController {
    
    private final ProfesorService profesorService;
    
    @PostMapping("/v1/guardar")
    public ResponseEntity<ProfesorResponseDTO> saveProfesor(@Valid @RequestBody ProfesorRequestDTO requestDTO) {
        log.info("Salvando Profesor: " + requestDTO);
        return new ResponseEntity<>(this.profesorService.saveProfesor(requestDTO), HttpStatus.CREATED);
    }
    
    @GetMapping("/v1/all")
    public ResponseEntity<List<ProfesorResponseDTO>> getAllProfesor() {
        log.info("Obteniendo todos los profesores");
        return new ResponseEntity<>(this.profesorService.getAll(), HttpStatus.OK);
    }
    
    @DeleteMapping("/v1/{profesorId}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable("profesorId") Long id) {
        log.info("Eliminando profesor por id: " + id);
        this.profesorService.deleteProfesor(id);
        return ResponseEntity.noContent().build();
    }
}
