/**
 * 
 */
package com.makino_saiten.goitai.validation.constraints;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;

import com.makino_saiten.goitai.validation.BiteSizeValidator;

/**
 * バイト数チェックアノテーション
 * @author yuta
 * 
 * 例
 * @HalfCharSize(biteMin = 6,biteMax = 9 , fullCharMin = 3, fullCharMax = 4)
 * ↓バリデーション結果
 * １２３→true
 * １２３４→true
 * １２３４５→false
 * 12345678→false
 * 12345→false
 * 123456→true
 * 1234567→true
 * 12345678→true
 * 123456789→true
 * 1234567890→false 
 * 
 * ※fullCharMax,fullCharMinは表示用数値です!しきい値としては運用されませんが、
 * fullCharMax:biteMaxの半分（切り捨て）
 * fullCharMin:biteMinの半分（切り上げ）
 * を書くようにしてください。
 *
 */
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy={BiteSizeValidator.class})
public @interface BiteSize {
     String message() default "{javax.validation.constraints.HalfCharSize.message}";
     String minMaxMessage() default "{validator.constraints.MinMax.message}";

 	Class<?>[] groups() default { };

 	Class<? extends Payload>[] payload() default { };

 	int biteMin() default 0;

 	int biteMax() default 21845;
 	
 	int fullCharMin() default 0;
 	
 	int fullCharMax() default 10922;

 	/**
 	 * Defines several {@link BiteSize} annotations on the same element.
 	 *
 	 * @see Size
 	 */
 	@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE})
 	@Retention(RUNTIME)
 	@Documented
 	@interface List {

 		BiteSize[] value();
 	}
}
