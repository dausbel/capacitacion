package com.amsa.capacitacion.profesor.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curso_id")
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "profesor_id")
    private Long profesorId;
    
    @Column(name = "update_time")
    @UpdateTimestamp
    private LocalDate updatime;
    
    @Column(name = "creation_time")
    @CreationTimestamp
    private LocalDate creationTime;
}
