package com.amsa.capacitacion.profesor.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Proffesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "address")
    private String address;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "profesor_id", referencedColumnName = "id")
    private List<Curso> cursos = new ArrayList<>();
    
    @Column(name = "update_time")
    @UpdateTimestamp
    private LocalDate updatime;
    
    @Column(name = "creation_time")
    @CreationTimestamp
    private LocalDate creationTime;
    
}
