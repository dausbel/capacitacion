package com.amsa.capacitacion.profesor.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
@Data
public class ProfesorException extends RuntimeException{
    private String mensaje;
    private HttpStatus httpStatus;
    
    
    public ProfesorException(final String mensaje,final HttpStatus httpStatus) {
        super(mensaje);
        this.mensaje = mensaje;
        this.httpStatus = httpStatus;
    }
}
