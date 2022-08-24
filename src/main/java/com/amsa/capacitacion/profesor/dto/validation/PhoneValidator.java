package com.amsa.capacitacion.profesor.dto.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE,  ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
    validatedBy = {PhoneValidatorConstraint.class}
)
public @interface PhoneValidator {
    String message() default " Phone no valido";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
    String fieldName() default "Not valid";
}
