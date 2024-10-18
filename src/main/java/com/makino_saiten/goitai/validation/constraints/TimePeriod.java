/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：TimePeriod.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.validation.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
import javax.validation.Constraint;
import javax.validation.Payload;

import com.makino_saiten.goitai.validation.TimePeriodValidator;
import com.makino_saiten.goitai.validation.constraints.TimePeriods;
/**
 * 時刻比較Validationインタフェース
 * @author tsuruda
 *
 */

@Constraint(validatedBy={TimePeriodValidator.class})
@Repeatable(TimePeriods.class)
public @interface TimePeriod {
     String message() default "{validator.constraints.TimePeriod.message}";
     String fromToMessage() default "{TimeFormat.invalid}";

     Class<?>[] groups() default {};

     Class<? extends Payload>[] payload() default {};

     String fieldFrom() default "";
     String fieldTo() default "";

     @Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.ANNOTATION_TYPE})
     @Retention(RetentionPolicy.RUNTIME)
     @Documented
     public static @interface List
     {
         TimePeriod[] value();
     }
}
