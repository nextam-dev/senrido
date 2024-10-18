/**
 * 
 */
package com.makino_saiten.goitai.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author t_hirose
 *
 */
@Component
@Data
@NoArgsConstructor
public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String employeeCode;

	private String employeeNo;

	private String employeeName;
	
	private String employeeKana;

	private String secCode;

	private String groupCode;

	private String positionCode;

	private String employeeCategoryCode;

	private String secName;
	
	private Integer loginCount;
}
