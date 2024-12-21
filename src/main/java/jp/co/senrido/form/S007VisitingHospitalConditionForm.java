/* =============================================================
 * システム名：
 * ファイル名：
 * --------------------------------------------------------------
 */
package jp.co.senrido.form;

import javax.validation.Valid;

import jp.co.senrido.dto.TCriticalVisibilityNeedsDto;
import jp.co.senrido.dto.TCustomerDto;
import jp.co.senrido.dto.TDiscomfortFatigueDto;
import jp.co.senrido.dto.TEyePositionDto;
import jp.co.senrido.dto.TEyeUsageStatusDto;
import jp.co.senrido.dto.TFullCorrectionDto;
import jp.co.senrido.dto.TGlareDto;
import jp.co.senrido.dto.TGlassesUsageDto;
import jp.co.senrido.dto.THobbiesClubActivitiesDto;
import jp.co.senrido.dto.TOccupationDto;
import jp.co.senrido.dto.TOngoingDiseasesMedicationDto;
import jp.co.senrido.dto.TPastMedicalHistoryDto;
import jp.co.senrido.dto.TPrescribedLensStrengthDto;
import jp.co.senrido.dto.TSurgeryDto;
import jp.co.senrido.dto.TSymptomsDto;
import jp.co.senrido.dto.TTroubleDto;
import jp.co.senrido.dto.TUsageStatusDto;
import jp.co.senrido.dto.TVisionLossDto;
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
	private TCustomerDto customerInfo;
	
	/** 各入力対象項目 */
	@Valid
	private TEyePositionDto eyePositionInfo;
	
	/** 各入力対象項目 */
	@Valid
	private TPrescribedLensStrengthDto prescribedLensStrengthInfo;
	
	/** 各入力対象項目 */
	@Valid
	private TFullCorrectionDto FullCorrectionInfo;
		
	/** 各入力対象項目 */
	@Valid
	private TVisitingHospitalDto visitingHospitalInfo;
	
	/** 各入力対象項目 */
	@Valid
	private TSurgeryDto surgeryInfo;
	
	/** 各入力対象項目 */
	@Valid
	private TVisionLossDto visionLossInfo;
	
	/** 各入力対象項目 */
	@Valid
	private TGlassesUsageDto glassesUsageInfo;
	
	/** 各入力対象項目 */
	@Valid
	private TUsageStatusDto usageStatusInfo;
	
	/** 各入力対象項目 */
	@Valid
	private TTroubleDto troubleInfo;
	
	/** 各入力対象項目 */
	@Valid
	private TSymptomsDto symptomsInfo;

	/** 各入力対象項目 */
	@Valid
	private TGlareDto glareInfo;
	
	/** 各入力対象項目 */
	@Valid
	private TDiscomfortFatigueDto discomfortFatigueInfo;
	
	/** 各入力対象項目 */
	@Valid
	private TCriticalVisibilityNeedsDto criticalVisibilityNeedsInfo;
	
	/** 各入力対象項目 */
	@Valid
	private TOccupationDto occupationInfo;
	
	/** 各入力対象項目 */
	@Valid
	private THobbiesClubActivitiesDto hobbiesClubActivitiesInfo;
	
	/** 各入力対象項目 */
	@Valid
	private TEyeUsageStatusDto eyeUsageStatusInfo;

	/** 各入力対象項目 */
	@Valid
	private TPastMedicalHistoryDto pastMedicalHistoryInfo;
	
	/** 各入力対象項目 */
	@Valid
	private TOngoingDiseasesMedicationDto ongoingDiseasesMedicationInfo;
	
}
