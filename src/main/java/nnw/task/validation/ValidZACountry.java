package nnw.task.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ZACountryValidator.class})
@Documented
public @interface ValidZACountry {
    String message() default "Validation for ZA country";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
