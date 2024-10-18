package com.makino_saiten.goitai.validation.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.makino_saiten.goitai.validation.PatternBlankValidator;

@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy={PatternBlankValidator.class})
public @interface PatternBlank {
	String message() default "{}";

	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	String regexp() default "";
    @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public static @interface List
    {
    	PatternBlank[] value();
    }
}
