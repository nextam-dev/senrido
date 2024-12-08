/* =============================================================
 システム名：マキノ祭典　はなこシステム
 ファイル名：MCodeMasterService.java
 --------------------------------------------------------------
 2018(C) マキノ祭典. All Rights Reserved.
 */
package jp.co.senrido.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import jp.co.senrido.common.SenridoConstant;
import jp.co.senrido.dao.MCodeDao;
import jp.co.senrido.dao.TCustomerDao;
import jp.co.senrido.dao.TPrescribedLensStrengthDao;
import jp.co.senrido.dao.TVisitingHospitalDao;
import jp.co.senrido.dto.TCustomerDto;
import jp.co.senrido.dto.TPrescribedLensStrengthDto;
import jp.co.senrido.dto.TVisitingHospitalDto;
import jp.co.senrido.dto.UserDto;
import jp.co.senrido.entity.TCustomer;
import jp.co.senrido.entity.TPrescribedLensStrength;
import jp.co.senrido.entity.TVisitingHospital;
import jp.co.senrido.json.CommonIO;
import jp.co.senrido.utils.DateUtil;

/**
 * 詳細画面サービス
 *
 * @author kurokawa
 *
 */
@Service
public class S007MedicalRecordService extends BaseTransactionalService {

	@Autowired
	private TCustomerDao tCustomerDao;

	@Autowired
	private MCodeDao mCodeDao;

	@Autowired
	private TVisitingHospitalDao tVisitingHospitalDao;
	
	@Autowired
	private TPrescribedLensStrengthDao tPrescribedLensStrengthDao;

	@Autowired
	private JapaneseCalADConvService japaneseCalADConvService;

	@Autowired
	private MCodeMasterService mCodeMasterService;

	private static final String API_URL = "https://vision.googleapis.com/v1/images:annotate";
	private static final String API_KEY = "AIzaSyB5zybHKX28txBKuGFtW8DRbrIezAwwSb8";

	/**
	 * 初期表示
	 *
	 * @param dto
	 * @return
	 */
	@Transactional(rollbackFor = Throwable.class)
	public CommonIO initData(Integer id, String visitDate) throws Throwable {
		CommonIO io = new CommonIO();

		// お客様情報取得
		TCustomerDto customerInfo = searchByTCustomerInfo(id);

		// 眼科への通院情報取得
		List<TVisitingHospitalDto> visitingHospitalInfoList = searchByTvisitingHospitalInfo(id, visitDate);

		// 眼科への通院リスト取得
		io.setVisitingHospitalItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.MEDICAL_HISTORY));
		// 眼の症状リスト取得
		io.setEyeSymptomsItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.EYE_SYMPTOMS));
		// 身体の症状リスト取得
		io.setBodySymptomsItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.BODY_SYMPTOMS));
		// メガネトラブルリスト取得
		io.setGlassesIssuesItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.GLASSES_ISSUES));
		// フレームトラブルリスト取得
		io.setFrameIssuesItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.FRAME_ISSUES));
		// 眩しさを感じる物事リスト取得
		io.setGlareSourcesItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.GLARE_SOURCES));
		// メガネの装用現状リスト取得
		io.setUseGlassesCurrentItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.USE_GLASSES_CURRENT));
		// メガネの装用CL併用リスト取得
		io.setUseGlassesWithClItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.USE_GLASSES_WITH_CL));
		// メガネの装用用途リスト取得
		io.setUseGlassesPurposeItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.USE_GLASSES_PURPOSE));
		// 度数用途リスト取得
		io.setPrescriptionStrengthNameItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.PRESCRIPTION_STRENGTH_NAME));
		// ピッチリスト（輻輳 開散 水平斜位量 上下寄せ 上下斜位量 P）取得
		io.setPitchRangeRyePItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.PITCH_RANGE_EYE_P));
		// ピッチリスト（NPC アイポイント）取得
		io.setPitchRangeNpcEyepointItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.PITCH_RANGE_NPC_EYEPOINT));
		// ピッチリスト（V CV）取得
		io.setPitchRangeVCvItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.PITCH_RANGE_V_CV));
		// ピッチリスト（S C ADD）取得
		io.setPitchRangeSCAddItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.PITCH_RANGE_S_C_ADD));
		// ピッチリスト（AX）取得
		io.setPitchRangeAxItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.PITCH_RANGE_AX));
		// ピッチリスト（BASE）取得
		io.setPitchRangeBaseItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.PITCH_RANGE_BASE));
		// ピッチリスト（PD）取得
		io.setPitchRangePdItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.PITCH_RANGE_PD));
		// オプションリスト取得
		io.setOptionItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.OPTION));
		// 決済方法リスト取得
		io.setDepositKindCdItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.DEPOSIT_KIND_CD));
		// 完成連絡方法リスト取得
		io.setCompletionContactItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.COMPLETION_CONTACT));


		io.setCustomerInfo(customerInfo);
		io.setVisitingHospitalInfoList(visitingHospitalInfoList);
		return io;
	}

	/**
	 * 初期表示 お客様情報
	 *
	 * @param id
	 * @return headerInfo
	 */
	@Transactional(rollbackFor = Throwable.class)
	public TCustomerDto searchByTCustomerInfo(Integer id) throws Throwable {
		TCustomerDto customerInfo = new TCustomerDto();

		// 検索条件に該当するxxx情報を取得
		TCustomer entity = tCustomerDao.selectById(id);
		if (!ObjectUtils.isEmpty(entity)) {
			BeanUtils.copyProperties(entity, customerInfo);
		}

		// データ整形
		// 前回来店日
		if (!ObjectUtils.isEmpty(customerInfo.getPreviousVisitDate())) {
			// 和暦変換
			customerInfo.setPreviousVisitDateStr(
					DateUtil.changeFormat(customerInfo.getPreviousVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
		}
		// 前回来店日
		if (!ObjectUtils.isEmpty(customerInfo.getNextVisitDate())) {
			// 和暦変換
			customerInfo.setNextVisitDateStr(
					DateUtil.changeFormat(customerInfo.getNextVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
		}

		return customerInfo;
	}

	/**
	 * 初期表示 眼科への通院情報
	 *
	 * @param id
	 * @param visitDate
	 * @return headerInfo
	 */
	@Transactional(rollbackFor = Throwable.class)
	public List<TVisitingHospitalDto> searchByTvisitingHospitalInfo(Integer id, String visitDateStr) throws Throwable {
		List<TVisitingHospitalDto> visitingHospitalInfoList = new ArrayList<>();

		// 検索条件に該当するxxx情報を取得
		LocalDateTime visitDate = Timestamp.valueOf(visitDateStr).toLocalDateTime();
		List<TVisitingHospital> entityList = tVisitingHospitalDao.selectById(id, visitDate);
		if (!ObjectUtils.isEmpty(entityList)) {
			for (TVisitingHospital entity : entityList) {
				TVisitingHospitalDto dto = new TVisitingHospitalDto();
				BeanUtils.copyProperties(entity, dto);
				visitingHospitalInfoList.add(dto);
			}
		}

		// データ整形
		// 前回来店日
		/*
		 * if (!ObjectUtils.isEmpty(customerInfo.getPreviousVisitDate())) { // 和暦変換
		 * customerInfo.setPreviousVisitDateStr(
		 * DateUtil.changeFormat(customerInfo.getPreviousVisitDate(),
		 * DateUtil.DATE_FORMAT_YMD_SLASH)); }
		 */

		return visitingHospitalInfoList;
	}

	/**
	 * 登録・更新処理
	 *
	 * @param basicNo
	 * @return standardInfo
	 */

	@Transactional(rollbackFor = Throwable.class)
	public String upsertVisitingHospital(TVisitingHospitalDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;

		TVisitingHospital tVisitingHospital = new TVisitingHospital();

		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// お客様情報検索
		// LocalDateTime visitDate =
		// Timestamp.valueOf(dto.getVisitDate()).toLocalDateTime();
		List<TVisitingHospital> tVisitingHospitalResult = tVisitingHospitalDao.selectById(dto.getId(), localTimeNow);

		// 取得結果がnullの場合、登録
		if (ObjectUtils.isEmpty(tVisitingHospitalResult)) {

			// 登録情報を設定
			BeanUtils.copyProperties(dto, tVisitingHospital);

			tVisitingHospital.setId(dto.getId());
			tVisitingHospital.setVisitDate(localTimeNow);
			String visitEyeDoctorStr = dto.getVisitEyeDoctor();
			if (visitEyeDoctorStr != null) {
				tVisitingHospital.setVisitEyeDoctor(Boolean.valueOf(visitEyeDoctorStr));
			}
			tVisitingHospital.setConsultationDate(DateUtil.changeFormatStrToLocalDate(dto.getConsultationDate()));
			if (dto.getMedicalHistory() != null) {
				tVisitingHospital.setMedicalHistory(String.join(",", dto.getMedicalHistory()));
				tVisitingHospital.setMedicalHistoryName(
						changeCodeToName(SenridoConstant.DivCode.MEDICAL_HISTORY, dto.getMedicalHistory()));
			}
			String glassesMakingStr = dto.getGlassesMaking();
			if (glassesMakingStr != null) {
				tVisitingHospital.setGlassesMaking(Boolean.valueOf(glassesMakingStr));
			}
			String prescriptionStr = dto.getPrescription();
			if (prescriptionStr != null) {
				tVisitingHospital.setPrescription(Boolean.valueOf(prescriptionStr));
			}
			tVisitingHospital.setCreateDate(localTimeNow);
			tVisitingHospital.setCreateId(userDto.getUserCd());
			tVisitingHospital.setUpdateDate(localTimeNow);
			tVisitingHospital.setUpdateId(userDto.getUserCd());
			tVisitingHospital.setDelFlg(SenridoConstant.DELFLG_EFFECT);
			tVisitingHospitalDao.insert(tVisitingHospital);

			// 成功処理
			resultCd = SenridoConstant.SUCCESS;

		} else

		{

			// 更新情報を設定
			BeanUtils.copyProperties(dto, tVisitingHospital);

			/*
			 * tVisitingHospital.setVisitDate(
			 * DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(),
			 * DateUtil.DATE_FORMAT_YMD_HYPHEN));
			 */
			tVisitingHospital.setVisitDate(localTimeNow);
			String visitEyeDoctorStr = dto.getVisitEyeDoctor();
			if (visitEyeDoctorStr != null) {
				tVisitingHospital.setVisitEyeDoctor(Boolean.valueOf(visitEyeDoctorStr));
			}
			tVisitingHospital.setConsultationDate(DateUtil.changeFormatStrToLocalDate(dto.getConsultationDate()));
			if (dto.getMedicalHistory() != null) {
				tVisitingHospital.setMedicalHistory(String.join(",", dto.getMedicalHistory()));
				tVisitingHospital.setMedicalHistoryName(
						changeCodeToName(SenridoConstant.DivCode.MEDICAL_HISTORY, dto.getMedicalHistory()));
			}
			String glassesMakingStr = dto.getGlassesMaking();
			if (glassesMakingStr != null) {
				tVisitingHospital.setGlassesMaking(Boolean.valueOf(glassesMakingStr));
			}
			String prescriptionStr = dto.getPrescription();
			if (prescriptionStr != null) {
				tVisitingHospital.setPrescription(Boolean.valueOf(prescriptionStr));
			}
			tVisitingHospital.setUpdateDate(localTimeNow);
			tVisitingHospital.setUpdateId(userDto.getUserCd());
			tVisitingHospital.setDelFlg(SenridoConstant.DELFLG_EFFECT);
			tVisitingHospitalDao.update(tVisitingHospital);

			// 成功処理
			resultCd = SenridoConstant.SUCCESS;
		}

		return resultCd;
	}

	/**
	 * 登録・更新処理
	 *
	 * @param basicNo
	 * @return standardInfo
	 */

	@Transactional(rollbackFor = Throwable.class)
	public String upsertPrescribedLensStrengthInfo(TPrescribedLensStrengthDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;

		TPrescribedLensStrength tPrescribedLensStrength = new TPrescribedLensStrength();

		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// お客様情報検索
		// LocalDateTime visitDate =
		// Timestamp.valueOf(dto.getVisitDate()).toLocalDateTime();
		List<TVisitingHospital> tVisitingHospitalResult = tVisitingHospitalDao.selectById(dto.getId(), localTimeNow);

		// 取得結果がnullの場合、登録
		if (ObjectUtils.isEmpty(tVisitingHospitalResult)) {

			// 登録情報を設定
			BeanUtils.copyProperties(dto, tPrescribedLensStrength);

			tPrescribedLensStrength.setId(dto.getId());
			tPrescribedLensStrength.setVisitDate(localTimeNow);
			tPrescribedLensStrength.setCreateDate(localTimeNow);
			tPrescribedLensStrength.setCreateId(userDto.getUserCd());
			tPrescribedLensStrength.setUpdateDate(localTimeNow);
			tPrescribedLensStrength.setUpdateId(userDto.getUserCd());
			tPrescribedLensStrength.setDelFlg(SenridoConstant.DELFLG_EFFECT);
			tPrescribedLensStrengthDao.insert(tPrescribedLensStrength);

			// 成功処理
			resultCd = SenridoConstant.SUCCESS;

		} else

		{

			// 更新情報を設定
			BeanUtils.copyProperties(dto, tPrescribedLensStrength);

			/*
			 * tVisitingHospital.setVisitDate(
			 * DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(),
			 * DateUtil.DATE_FORMAT_YMD_HYPHEN));
			 */
			tPrescribedLensStrength.setVisitDate(localTimeNow);
			tPrescribedLensStrength.setUpdateDate(localTimeNow);
			tPrescribedLensStrength.setUpdateId(userDto.getUserCd());
			tPrescribedLensStrength.setDelFlg(SenridoConstant.DELFLG_EFFECT);
			tPrescribedLensStrengthDao.update(tPrescribedLensStrength);

			// 成功処理
			resultCd = SenridoConstant.SUCCESS;
		}

		return resultCd;
	}
}
