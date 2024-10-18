/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：PeriodValidator.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.validation;

import java.io.UnsupportedEncodingException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.makino_saiten.goitai.validation.constraints.BiteSize;
import com.mysql.jdbc.StringUtils;

/**
 * バイト数チェック
 * @author yuta
 *
 */
public class BiteSizeValidator implements ConstraintValidator<BiteSize, Object> {
	private Integer min;
	private Integer max;
	private Integer fullCharMin;
	private Integer fullCharMax;
	private String message;
	private String minMaxMessage;


	@Override
	public void initialize(BiteSize annotation) {
		this.min = annotation.biteMin();
		this.max = annotation.biteMax();
		this.message = annotation.message();
		this.minMaxMessage = annotation.minMaxMessage();

		this.fullCharMax = annotation.fullCharMax();
		this.fullCharMin = annotation.fullCharMin();

	}



	@Override
	public boolean isValid(Object value,
			ConstraintValidatorContext context) {

		//最大最小逆転していた場合にはその旨をエラー通知
		if (min > max || fullCharMin > fullCharMax) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(minMaxMessage)
			.addConstraintViolation();
			return false;
		}

		Integer targetBiteLen;
		//文字列長を取得しチェック
		try {
			if(value == null) {
				targetBiteLen = 0;
			}
			else{
				String targetStr = value.toString();
				targetBiteLen = StringUtils.getBytes(targetStr,"Shift_JIS").length;
			}

			if((min != null && min > targetBiteLen) || (max != null && max < targetBiteLen)) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(message)
				.addConstraintViolation();
				return false;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}