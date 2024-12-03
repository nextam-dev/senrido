/* =============================================================
 * システム名：
 * ファイル名：
 * --------------------------------------------------------------
 */
package jp.co.senrido.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.senrido.common.SenridoConstant;
import jp.co.senrido.dto.TVisitingHospitalDto;
import jp.co.senrido.form.S007MedicalRecordForm;
import jp.co.senrido.form.S007MedicalRecordUpdateForm;
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
	private MCodeMasterService mCodeMasterService;

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
		Integer id = Integer.parseInt(form.getId());
		String visitDateStr = form.getVisitDate(); // String型
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime visitDate = (visitDateStr == null || visitDateStr.isEmpty()) ? LocalDateTime.now() // デフォルトで現在日時
				: LocalDateTime.parse(visitDateStr, formatter);

		// お客様情報
		io = s007MedicalRecordService.initData(id, visitDate);

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
		Integer id = Integer.parseInt(form.getId());
		String visitDateStr = form.getVisitDate();
		String resultCd = "";

		// Form→dto
		TVisitingHospitalDto dto = new TVisitingHospitalDto();

		if (form.getVisitingHospitalInfo() != null) {
			BeanUtils.copyProperties(form.getVisitingHospitalInfo(), dto);

			String consultationDateStr = form.getVisitingHospitalInfo().getConsultationDate();
			if (consultationDateStr != null && !consultationDateStr.isEmpty()) {
			    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			    LocalDate consultationDate = LocalDate.parse(consultationDateStr, formatter);
			    dto.setConsultationDate(consultationDate);
			}
			List<String> medicalHistoryList = form.getVisitingHospitalInfo().getMedicalHistory();
			if (medicalHistoryList != null && !medicalHistoryList.isEmpty()) {
				String medicalHistory = String.join(",", medicalHistoryList);
				dto.setMedicalHistory(medicalHistory);
			}
			String visitEyeDoctorStr = form.getVisitingHospitalInfo().getVisitEyeDoctor();
		    if (visitEyeDoctorStr != null) {
		        dto.setVisitEyeDoctor(Boolean.valueOf(visitEyeDoctorStr));
		    }
		    String glassesMakingStr = form.getVisitingHospitalInfo().getGlassesMaking();
		    if (glassesMakingStr != null) {
		        dto.setGlassesMaking(Boolean.valueOf(glassesMakingStr));
		    }
		    String prescriptionStr = form.getVisitingHospitalInfo().getPrescription();
		    if (prescriptionStr != null) {
		        dto.setPrescription(Boolean.valueOf(prescriptionStr));
		    }
			
		}
		
		dto.setId(id);
		if (visitDateStr != null && !visitDateStr.isEmpty()) {
		    LocalDateTime visitDate = LocalDateTime.parse(visitDateStr);
		    dto.setVisitDate(visitDate);
		}
		// 登録・更新処理
		resultCd = s007MedicalRecordService.upsertVisitingHospital(dto);

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
	 * 連番設定(template)
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addition", method = RequestMethod.POST)
	public CommonIO addition(@Valid @RequestBody S007MedicalRecordUpdateForm form) throws Throwable {
		CommonIO io = new CommonIO();

		String resultCd = "";

		// Form→dto
		// TCustomerInitDto dto = new TCustomerInitDto();
		// BeanUtils.copy(form.getStandardInfo(), dto);

		// 連番設定処理
		// resultCd = s007MedicalRecordService.addSeq(dto);

		// エラーの場合、処理を終了する
		if (Objects.equals(resultCd, SenridoConstant.ERROR)) {
			io.setResultCd(resultCd);
			// io.setMessage(msg.getMessage("error.notExist", null, Locale.JAPANESE));
			return io;
		}

		// io.setMessage(msg.getMessage("success.register", null, Locale.JAPANESE));
		io.setResultCd(SenridoConstant.SUCCESS);
		return io;
	}

}