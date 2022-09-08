package com.amsa.capacitacion.profesor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CursoRequestDTO implements Serializable {
    @NotNull(message = "Nombre del curso  no puede ser nulo.")
    private String name;
    
    @NotNull(message = "Nombre del profesor no puede ser nulo.")
    private String  profesorName;
}
