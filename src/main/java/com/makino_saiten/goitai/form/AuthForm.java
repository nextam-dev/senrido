/**
 * 
 */
package com.makino_saiten.goitai.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author t_hirose
 *
 */
@Data
@NoArgsConstructor
public class AuthForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String companyCd;
	
	@NotBlank
    @Size(max=5)
	private String empNo;
	
	@Pattern(regexp="[0-9]*")
	private String password;
}
