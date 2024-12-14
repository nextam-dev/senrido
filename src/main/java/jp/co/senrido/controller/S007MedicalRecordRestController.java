/* =============================================================
 * システム名：
 * ファイル名：
 * --------------------------------------------------------------
 */
package jp.co.senrido.controller;

import java.util.Locale;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.senrido.common.SenridoConstant;
import jp.co.senrido.form.S007MedicalRecordForm;
import jp.co.senrido.form.S007VisitingHospitalConditionForm;
import jp.co.senrido.json.CommonIO;
import jp.co.senrido.service.MCodeMasterService;
import jp.co.senrido.service.S007MedicalRecordService;

/**
 * リクエスト制御クラス
 *
 * @author kurokawa
 */
@RestController
@RequestMapping(value = "**/s007MedicalRecord")
public class S007MedicalRecordRestController {

	@Autowired
	private S007MedicalRecordService s007MedicalRecordService;

	@Autowired
	private MessageSource msg;

	/**
	 * 初期表示(
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/initData", method = RequestMethod.POST)
	public CommonIO initData(@Valid @RequestBody S007MedicalRecordForm form) throws Throwable {
		CommonIO io = new CommonIO();

		// お客様情報
		io = s007MedicalRecordService.initData(form.getId(), form.getVisitDate());

		return io;
	}
	
	/**
	 * 登録・更新（お客様情報）
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertCustomer", method = RequestMethod.POST)
	public CommonIO upsertCustomer(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
		CommonIO io = new CommonIO();
		String resultCd = "";
		
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertCustomer(form.getCustomerInfo());

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		io.setResultCd(SenridoConstant.SUCCESS);
		io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		return io;
	}
	
	/**
	 * 登録・更新（作成度数）
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertPrescribedLensStrengthInfo", method = RequestMethod.POST)
	public CommonIO addList(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
		CommonIO io = new CommonIO();
		String resultCd = "";
		
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertPrescribedLensStrengthInfo(form.getPrescribedLensStrengthInfo());

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		io.setResultCd(SenridoConstant.SUCCESS);
		io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		return io;
	}

	/**
	 * 登録・更新（眼科への通院）
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertVisitingHospital", method = RequestMethod.POST)
	public CommonIO upsertVisitingHospital(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
		CommonIO io = new CommonIO();
		String resultCd = "";
		
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertVisitingHospital(form.getVisitingHospitalInfo());

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		io.setResultCd(SenridoConstant.SUCCESS);
		io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		return io;
	}
	
	/**
	 * 登録・更新（眼の手術）
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertOperation", method = RequestMethod.POST)
	public CommonIO upsertOperation(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
		CommonIO io = new CommonIO();
		String resultCd = "";
		
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertOperation(form.getSurgeryInfo());

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		io.setResultCd(SenridoConstant.SUCCESS);
		io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		return io;
	}
	
	/**
	 * 登録・更新（視力の低下を感じたのは）
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertImpairedVision", method = RequestMethod.POST)
	public CommonIO upsertImpairedVision(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
		CommonIO io = new CommonIO();
		String resultCd = "";
		
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertImpairedVision(form.getVisionLossInfo());

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		io.setResultCd(SenridoConstant.SUCCESS);
		io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		return io;
	}
	
	/**
	 * 登録・更新（メガネの装用）
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertWearingGlasses", method = RequestMethod.POST)
	public CommonIO upsertWearingGlasses(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
		CommonIO io = new CommonIO();
		String resultCd = "";
		
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertWearingGlasses(form.getGlassesUsageInfo());

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		io.setResultCd(SenridoConstant.SUCCESS);
		io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		return io;
	}
	
	/**
	 * 登録・更新（メガネ・CLの装用状況）
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertWearingSituation", method = RequestMethod.POST)
	public CommonIO upsertWearingSituation(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
		CommonIO io = new CommonIO();
		String resultCd = "";
		
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertWearingSituation(form.getUsageStatusInfo());

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		io.setResultCd(SenridoConstant.SUCCESS);
		io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		return io;
	}
	
	/**
	 * 登録・更新（メガネのトラブル）
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertGlassesTrouble", method = RequestMethod.POST)
	public CommonIO upsertGlassesTrouble(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
		CommonIO io = new CommonIO();
		String resultCd = "";
		
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertGlassesTrouble(form.getTroubleInfo());

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		io.setResultCd(SenridoConstant.SUCCESS);
		io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		return io;
	}

	/**
	 * 登録・更新（眼・身体の症状）
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertSymptoms", method = RequestMethod.POST)
	public CommonIO upsertSymptoms(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
		CommonIO io = new CommonIO();
		String resultCd = "";
		
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertSymptoms(form.getSymptomsInfo());

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		io.setResultCd(SenridoConstant.SUCCESS);
		io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		return io;
	}
	
	/**
	 * 登録・更新（眩しさを感じる物事）
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertDazzlingThings", method = RequestMethod.POST)
	public CommonIO upsertDazzlingThings(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
		CommonIO io = new CommonIO();
		String resultCd = "";
		
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertDazzlingThings(form.getGlareInfo());

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		io.setResultCd(SenridoConstant.SUCCESS);
		io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		return io;
	}
	
	/**
	 * 登録・更新（見づらさや疲れを感じるとき）
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertSeeDiscomfortFatigue", method = RequestMethod.POST)
	public CommonIO upsertSeeDiscomfortFatigue(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
		CommonIO io = new CommonIO();
		String resultCd = "";
		
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertSeeDiscomfortFatigue(form.getDiscomfortFatigueInfo());

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		io.setResultCd(SenridoConstant.SUCCESS);
		io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		return io;
	}
	
	/**
	 * 登録・更新（見えないと困るもの）
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertSeeProblem", method = RequestMethod.POST)
	public CommonIO upsertSeeProblem(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
		CommonIO io = new CommonIO();
		String resultCd = "";
		
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertSeeProblem(form.getCriticalVisibilityNeedsInfo());

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		io.setResultCd(SenridoConstant.SUCCESS);
		io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		return io;
	}
	
	/**
	 * 登録・更新（ご職業）
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertOccupation", method = RequestMethod.POST)
	public CommonIO upsertOccupation(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
		CommonIO io = new CommonIO();
		String resultCd = "";
		
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertOccupation(form.getOccupationInfo());

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		io.setResultCd(SenridoConstant.SUCCESS);
		io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		return io;
	}
	
	/**
	 * 登録・更新（趣味・部活）
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertHobbyAndClub", method = RequestMethod.POST)
	public CommonIO upsertHobbyAndClub(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
		CommonIO io = new CommonIO();
		String resultCd = "";
		
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertHobbyAndClub(form.getHobbiesClubActivitiesInfo());

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		io.setResultCd(SenridoConstant.SUCCESS);
		io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		return io;
	}
	
	/**
	 * 登録・更新（眼の使用状況）
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertUsageStatus", method = RequestMethod.POST)
	public CommonIO upsertUsageStatus(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
		CommonIO io = new CommonIO();
		String resultCd = "";
		
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertUsageStatus(form.getEyeUsageStatusInfo());

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		io.setResultCd(SenridoConstant.SUCCESS);
		io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		return io;
	}
	
	/**
	 * 登録・更新（過去の病歴）
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertCaseHistory", method = RequestMethod.POST)
	public CommonIO upsertCaseHistory(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
		CommonIO io = new CommonIO();
		String resultCd = "";
		
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertCaseHistory(form.getPastMedicalHistoryInfo());

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		io.setResultCd(SenridoConstant.SUCCESS);
		io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		return io;
	}
	
	/**
	 * 登録・更新（治療中の疫病（服用薬））
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertTreatmentDisease", method = RequestMethod.POST)
	public CommonIO upsertTreatmentDisease(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
		CommonIO io = new CommonIO();
		String resultCd = "";
		
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertTreatmentDisease(form.getOngoingDiseasesMedicationInfo());

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		io.setResultCd(SenridoConstant.SUCCESS);
		io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		return io;
	}

}