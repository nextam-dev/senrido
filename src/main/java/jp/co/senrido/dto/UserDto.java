/**
 * 
 */
package jp.co.senrido.dto;

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
	
	private String userCd;

	private String name;

	private String kana;
	
	private String shopCd;
	
	private Integer loginCount;
}
