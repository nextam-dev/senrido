/* =============================================================
 * システム名：
 * ファイル名：
 * --------------------------------------------------------------
 */
package jp.co.senrido.form;

import javax.validation.Valid;

import jp.co.senrido.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Formクラス
 * @author kurokawa
 *
 */
@Data
@NoArgsConstructor
public class S007VisitingHospitalConditionForm extends BaseSearchForm {

	private static final long serialVersionUID = 1L;

	/** ログインユーザ情報 */
	private UserDto userDto;
	
	/** お客様ID */
	private String id;
	
	/** 来店日 */
	private String visitDate;
	
	/** 各入力対象項目 */
	@Valid
	private UpdateVisitingHospitalForm visitingHospitalInfo;

}
