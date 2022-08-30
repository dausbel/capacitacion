package com.amsa.capacitacion.profesor.exceptions;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
@Getter
@Builder
public class ErrorMensaje implements Serializable {
    private final String mensaje;
}
