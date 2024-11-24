/**
 * 
 */
package jp.co.senrido.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * @author takam
 *
 */
@Getter
@Setter
public class TSurveyDto {

	/** お客様ID */
	private Integer id;

    /** 来店日 */
	private LocalDateTime visitDate;

	/** お客様名 */
	private String name;

	/** お客様名カナ */
	private String nameKana;

	/** 生年月日 */
	private LocalDate birthday;
	
	/** メールアドレス */
	private String mmail;

	/** 性別 */
	private String sex;

	/** 性別その他 */
	private String sexOther;

	/** 郵便番号 */
	private String zipcode;

	/** 住所 */
	private String address;

	/** 電話番号 */
	private String telephone;

	/** 紹介者 */
	private String referrer;
}
