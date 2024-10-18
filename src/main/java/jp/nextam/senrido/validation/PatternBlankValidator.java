/**
 * 
 */
package jp.nextam.senrido.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.nextam.senrido.utils.StringUtil;
import jp.nextam.senrido.validation.constraints.PatternBlank;

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
