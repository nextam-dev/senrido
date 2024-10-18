/**
 * 
 */
package jp.nextam.senrido.dto;

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

	public String getEmployeeCode() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getLoginCount() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEmployeeCode(String employeeCode2) {
		// TODO Auto-generated method stub
		
	}

	public void setEmployeeName(String employeeName2) {
		// TODO Auto-generated method stub
		
	}

	public void setEmployeeKana(String employeeKana2) {
		// TODO Auto-generated method stub
		
	}

	public void setSecCode(String secCode2) {
		// TODO Auto-generated method stub
		
	}

	public void setGroupCode(String groupCode2) {
		// TODO Auto-generated method stub
		
	}
}
