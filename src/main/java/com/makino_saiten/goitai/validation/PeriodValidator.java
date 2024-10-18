/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：PeriodValidator.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.validation;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.makino_saiten.goitai.validation.constraints.Period;

/**
 * 期間チェック
 * @author tsuruda
 *
 */
public class PeriodValidator implements ConstraintValidator<Period, Object> {
    private String fieldFrom;
    private String fieldTo;
    private String message;
    private String fromToMessage;

    @Override
    public void initialize(Period annotation) {
        this.fieldFrom = annotation.fieldFrom();
        this.fieldTo = annotation.fieldTo();
        this.message = annotation.message();
        this.fromToMessage = annotation.fromToMessage();
    }

    @Override
    public boolean isValid(Object value,
            ConstraintValidatorContext context) {

        BeanWrapper beanWrapper = new BeanWrapperImpl(value);

        String strFrom = (String)beanWrapper.getPropertyValue(fieldFrom);
        String strTo = (String)beanWrapper.getPropertyValue(fieldTo);

        if(strFrom == null && strTo == null) {
        	return true;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        if (strFrom.indexOf("-") > 0 || strTo.indexOf("-") > 0) {
        	sdf = new SimpleDateFormat("yyyy-MM-dd");
        }
        Date from = null;
        Date to = null;
        try {
			if (strFrom != null && strFrom != "") {
				from = sdf.parse(strFrom);
			}
		} catch (Exception e) {
			// フォーマットエラー
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(fromToMessage)
            .addPropertyNode(fieldFrom)
            .addConstraintViolation();
            return false;
        }
        try {
			if (strTo != null && strTo != "") {
				to = sdf.parse(strTo);
			}
		} catch (Exception e) {
			// フォーマットエラー
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(fromToMessage)
            .addPropertyNode(fieldTo)
            .addConstraintViolation();
            return false;
        }

        if (from != null && to != null && from.compareTo(to) > 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
            .addPropertyNode(fieldFrom)
            .addConstraintViolation();
            return false;
        }
        return true;
    }

}