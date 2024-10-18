/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：TimePeriodValidator.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.makino_saiten.goitai.utils.StringUtil;
import com.makino_saiten.goitai.validation.constraints.TimePeriod;

/**
 * 時間チェック
 * @author tsuruda
 *
 */
public class TimePeriodValidator implements ConstraintValidator<TimePeriod, Object> {
    private String fieldFrom;
    private String fieldTo;
    private String message;
    private String fromToMessage;
 
    @Override
    public void initialize(TimePeriod annotation) {
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

        int from = 0;
        int to = 2359;
        if (!StringUtil.isEmpty(strFrom)) {
        	if (!strFrom.matches("([0-1][0-9]|2[0-3])[:]([0-5][0-9])")) {
        		// フォーマットエラー
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(fromToMessage)
                .addPropertyNode(fieldFrom)
                .addConstraintViolation();
                return false;
        	}
        	else {
        		from = Integer.parseInt(strFrom.replaceAll(":", ""));
        	}
        }
        if (!StringUtil.isEmpty(strTo)) {
        	if (!strTo.matches("([0-1][0-9]|2[0-3])[:]([0-5][0-9])")) {
        		// フォーマットエラー
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(fromToMessage)
                .addPropertyNode(fieldFrom)
                .addConstraintViolation();
                return false;
        	}
        	else {
        		to = Integer.parseInt(strTo.replaceAll(":", ""));
        	}
        }
        
        if (from >= to) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
            .addPropertyNode(fieldFrom)
            .addConstraintViolation();
            return false;
        }
        return true;
    }
 
}