/* =============================================================
 * システム名：
 * ファイル名：
 * --------------------------------------------------------------
 */
package jp.co.senrido.form;

import jp.co.senrido.dto.TSurveyDto;
import jp.co.senrido.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Formクラス
 * @author kurokawa
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class S007MedicalRecordForm extends BaseSearchForm {

	private static final long serialVersionUID = 1L;

	/** ログインユーザ情報 */
	private UserDto userDto;
	
	/** お客様ID */
	private Integer id;
	
	/** 来店日 */
	private String visitDate;
	
	/** アンケート情報 */
	private TSurveyDto survey;

}
