/* =============================================================
 * システム名：
 * ファイル名：
 * --------------------------------------------------------------
 */
package jp.co.senrido.form;

import javax.validation.Valid;

import jp.co.senrido.annotation.MessageName;
import jp.co.senrido.dto.TSurveyDto;
import jp.co.senrido.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Formクラス
 * @author hirose
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class S008QuestionnaireForm extends BaseSearchForm {

	private static final long serialVersionUID = 1L;

	/** ログインユーザ情報 */
	private UserDto userDto;
	
	/** アンケート情報 */
	@Valid
	@MessageName("アンケート情報")
	private TSurveyDto survey;
}
