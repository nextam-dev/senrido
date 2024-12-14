/* =============================================================
 * システム名：
 * ファイル名：
 * --------------------------------------------------------------
 */
package jp.co.senrido.controller;

import java.util.ArrayList;
import java.util.List;
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
import jp.co.senrido.dto.CodeNameDto;
import jp.co.senrido.dto.TCustomerDto;
import jp.co.senrido.entity.MCode;
import jp.co.senrido.form.S007MedicalRecordForm;
import jp.co.senrido.form.S007VisitingHospitalConditionForm;
import jp.co.senrido.form.S008QuestionnaireForm;
import jp.co.senrido.json.CommonIO;
import jp.co.senrido.service.MCodeMasterService;
import jp.co.senrido.service.S003PasswordReissueService;
import jp.co.senrido.service.S007MedicalRecordService;

/**
 * リクエスト制御クラス
 *
 * @author kurokawa
 */
@RestController
@RequestMapping(value = "**/s007MedicalNewRecord")
public class S007MedicalNewRecordRestController {

	@Autowired
	private MCodeMasterService mCodeMasterService;

	@Autowired
	private S007MedicalRecordService s007MedicalRecordService;

	@Autowired
	private MessageSource msg;

	/**
	 * 検索条件初期化
	 *
	 * @return
	 */
	@RequestMapping(value = "/initStatus", method = RequestMethod.POST)
	public CommonIO initStatus() throws Throwable {
		
		CommonIO io = new CommonIO();
		
		// コードマスタから選択肢を取得
		// 性別
		io.setSexList(mCodeMasterService.getMCode("sex"));
		

		return io;
	}
		
	/**
	 * 登録処理.
	 *
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public CommonIO insert(@RequestBody S007MedicalRecordForm form) throws Throwable {
		
		CommonIO io = new CommonIO();
		
		// 登録処理
		s007MedicalRecordService.insertCustomer(form.getCustomerInfo());

		return io;
	}

}