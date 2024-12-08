/* =============================================================
 * システム名：
 * ファイル名：
 * --------------------------------------------------------------
 */
package jp.co.senrido.form;

import javax.validation.Valid;

import jp.co.senrido.dto.TPrescribedLensStrengthDto;
import jp.co.senrido.dto.TVisitingHospitalDto;
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
	
	/** 各入力対象項目 */
	@Valid
	private TVisitingHospitalDto visitingHospitalInfo;
	
	/** 各入力対象項目 */
	@Valid
	private TPrescribedLensStrengthDto prescribedLensStrengthInfo;
	

}