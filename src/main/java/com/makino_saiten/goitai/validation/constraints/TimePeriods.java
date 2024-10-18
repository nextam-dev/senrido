/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：TimePeriods.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */package com.makino_saiten.goitai.validation.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TimePeriods {
	TimePeriod[] value();    // @TimePeriods アノテーションの配列を返す value() メソッド
}