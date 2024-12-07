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
	 * 登録・更新
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upsertVisitingHospital", method = RequestMethod.POST)
	public CommonIO update(@Valid @RequestBody S007VisitingHospitalConditionForm form) throws Throwable {
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
	 * 登録・更新
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

}