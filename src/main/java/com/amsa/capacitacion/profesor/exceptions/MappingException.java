package com.amsa.capacitacion.profesor.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
@Data
public class MappingException extends RuntimeException{
    private String mensaje;
    private HttpStatus httpStatus;
    
    
    public MappingException(final String mensaje,final HttpStatus httpStatus) {
        super(mensaje);
        this.mensaje = mensaje;
        this.httpStatus = httpStatus;
    }
}
