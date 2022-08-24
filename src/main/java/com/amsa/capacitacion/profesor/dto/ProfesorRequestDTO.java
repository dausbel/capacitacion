package com.amsa.capacitacion.profesor.dto;

import com.amsa.capacitacion.profesor.dto.validation.PhoneValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
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
public class ProfesorRequestDTO implements Serializable {
    
    @NotNull(message = "Nombre no puede ser nulo.")
    private String name;
    
    @Email(message = "No es un correo valido.")
    private String email;
    @PhoneValidator(message = "No valido el telefono")
    private String phone;
    
    private String address;
}
