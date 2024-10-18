/**
 * 
 */
package com.makino_saiten.goitai.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * セッション未必須アノテーション
 *
 * @author takamasa
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NonRequiredSession {
}
