/**
 * 
 */
package com.makino_saiten.goitai.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.makino_saiten.goitai.utils.StringUtil;
import com.makino_saiten.goitai.validation.constraints.PatternBlank;

/**
 * @author tsuruda
 *
 */
public class PatternBlankValidator implements ConstraintValidator<PatternBlank, String> {
	String regexp;
	
    @Override
    public void initialize(PatternBlank annotation) {
    	regexp = annotation.regexp();
    }
    @Override
    public boolean isValid(String value,
    		ConstraintValidatorContext paramConstraintValidatorContext) {
    	if (StringUtil.isEmpty(value)) {
    		return true;
    	}
    	if(value.matches(regexp)) {
    		return true;
    	}
    	return false;
    }
}
