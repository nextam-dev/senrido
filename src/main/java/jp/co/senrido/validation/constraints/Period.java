/**
 * 
 */
package jp.co.senrido.validation.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
import javax.validation.Constraint;
import javax.validation.Payload;

import jp.co.senrido.validation.PeriodValidator;
import jp.co.senrido.validation.constraints.Periods;
/**
 * @author tsuruda
 *
 */
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy={PeriodValidator.class})
@Repeatable(Periods.class)
public @interface Period {
     String message() default "{validator.constraints.Period.message}";
     String fromToMessage() default "{DateFormat.invalid}";

     Class<?>[] groups() default {};

     Class<? extends Payload>[] payload() default {};

     String fieldFrom() default "from";
     String fieldTo() default "to";

     @Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.ANNOTATION_TYPE})
     @Retention(RetentionPolicy.RUNTIME)
     @Documented
     public static @interface List
     {
         Period[] value();
     }
}