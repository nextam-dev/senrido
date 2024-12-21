/* =============================================================
 * システム名：
 * ファイル名：
 * --------------------------------------------------------------
 */
package jp.co.senrido.form;

import java.util.List;

import jp.co.senrido.dto.TCustomerSearchDto;
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
public class S006CustomerInformationSearchForm extends BaseSearchForm {

	private static final long serialVersionUID = 1L;

	/** ログインユーザ情報 */
	private UserDto userDto;

	/** 受注区分コード */
	private String orderDivCode;

	/** 施行担当コード */
	private List<String> operationStaffCode;

	/** 故人名 */
	private String decedentName;

	/** 検索データ */
	private TCustomerSearchDto customerSearchList;

	/** ソート条件 */
	private String conditions;

}
