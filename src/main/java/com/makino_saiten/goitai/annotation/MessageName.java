/**
 * 
 */
package com.makino_saiten.goitai.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * メッセージ埋め字（論理名）アノテーション
 * 
 * @author y.kawatani
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MessageName {
	String value();
}
