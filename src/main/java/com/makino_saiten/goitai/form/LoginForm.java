/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：LoginForm.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author t_hirose
 *
 */
@Data
@NoArgsConstructor
public class LoginForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NonNull
	@NotBlank
    @Size(max=5)
	private String idTX;
	
	@NonNull
	@Pattern(regexp="[0-9]*")
	private String PasswordTX;
}
