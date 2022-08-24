package com.amsa.capacitacion.profesor.dto.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
public class PhoneValidatorConstraint implements ConstraintValidator<PhoneValidator, String> {
    
    private Pattern pattern = Pattern.compile("^\\+?[0-9]{2}-?[0-9]{8,12}$");
    
    @Override
    public boolean isValid(final String s, final ConstraintValidatorContext constraintValidatorContext) {
        return pattern.matcher(s).matches();
    }
}
