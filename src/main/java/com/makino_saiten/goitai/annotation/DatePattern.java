/**
 *
 */
package com.makino_saiten.goitai.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 日付フィールドに付与するアノテーション
 *
 * @author takamasa
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DatePattern {
	String pattern();
}
