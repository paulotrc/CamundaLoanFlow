package br.paulotrc.svcimovel.entites.validators;

import br.paulotrc.svcimovel.entites.validators.TipoImovelPatternValidator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = TipoImovelPatternValidator.class)
public @interface TipoImovelValidator {
    String regexp();
    String message() default "Precisa ser uma das seguintes opções: \"{regexp}\"";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
