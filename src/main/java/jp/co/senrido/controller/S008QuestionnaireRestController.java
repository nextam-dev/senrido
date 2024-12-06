/* =============================================================
 * システム名：
 * ファイル名：
 * --------------------------------------------------------------
 */
package jp.co.senrido.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.senrido.dto.CodeNameDto;
import jp.co.senrido.form.S008QuestionnaireForm;
import jp.co.senrido.json.CommonIO;
import jp.co.senrido.service.MCodeMasterService;
import jp.co.senrido.service.S008QuestionnaireService;

/**
 * リクエスト制御クラス
 *
 * @author hirose
 */
@RestController
@RequestMapping(value = "**/s008Questionnaire")
public class S008QuestionnaireRestController {

	@Autowired
	private MCodeMasterService mCodeMasterService;
	
	@Autowired
	private S008QuestionnaireService s008QuestionnaireService;

	@Autowired
	private MessageSource msg;

	/**
	 * 検索条件初期化
	 *
	 * @return
	 */
	@RequestMapping(value = "/initStatus", method = RequestMethod.POST)
	public CommonIO initStatus(@RequestBody S008QuestionnaireForm form) throws Throwable {
		
		CommonIO io = new CommonIO();
		
		// お客様情報を取得
		
		// コードマスタから選択肢を取得
		io.setSexList(mCodeMasterService.getMCode("sex"));
		io.setUsageStatusList(mCodeMasterService.getMCode("usage_status"));
		io.setComputerTypeList(mCodeMasterService.getMCode("computer_type"));
		io.setComputerUsageTimeList(mCodeMasterService.getMCode("computer_usage_time"));
		io.setSmartphoneUsageTimeList(mCodeMasterService.getMCode("smartphone_usage_time"));
		io.setSmartphoneContentList(mCodeMasterService.getMCode("smartphone_content"));
		io.setReadingList(mCodeMasterService.getMCode("reading"));
		io.setGamingNameList(mCodeMasterService.getMCode("gaming_name"));
		io.setGamingTimeList(mCodeMasterService.getMCode("gaming_time"));
		io.setDrivingList(mCodeMasterService.getMCode("driving"));
		io.setLicenseTypeList(mCodeMasterService.getMCode("license_type"));
		io.setOphthalmologyVisitList(mCodeMasterService.getMCode("ophthalmology_visit"));
		io.setEyeFatigueList(mCodeMasterService.getMCode("eye_fatigue"));
		io.setEyeSymptomsList(mCodeMasterService.getMCode("eye_symptoms"));
		io.setBodySymptomsList(mCodeMasterService.getMCode("body_symptoms"));
		io.setSurgeryList(mCodeMasterService.getMCode("surgery"));
		io.setCovidDisclosureList(mCodeMasterService.getMCode("covid_disclosure"));
		// 2回目
		io.setCreatedGlassesUsageList(mCodeMasterService.getMCode("created_glasses_usage"));
		io.setChangesList(mCodeMasterService.getMCode("changes"));
		io.setGlassesConcernsList(mCodeMasterService.getMCode("glasses_concerns"));
		io.setEyeFatigueSecondList(mCodeMasterService.getMCode("eye_fatigue_second"));
		io.setPrescriptionStrengthList(mCodeMasterService.getMCode("prescription_strength"));

		return io;
	}
	
	/**
	 * 登録処理.
	 *
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public CommonIO insert(@RequestBody S008QuestionnaireForm form) throws Throwable {
		
		CommonIO io = new CommonIO();
		
		// 登録処理
		s008QuestionnaireService.insertSurvey(form.getSurvey());

		return io;
	}
}