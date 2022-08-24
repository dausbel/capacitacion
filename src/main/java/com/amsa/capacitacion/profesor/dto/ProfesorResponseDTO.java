package com.amsa.capacitacion.profesor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
public class ProfesorResponseDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String email;
    private String phone;
    private String address;
}
