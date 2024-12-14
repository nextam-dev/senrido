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
import jp.co.senrido.dao.TCriticalVisibilityNeedsDao;
import jp.co.senrido.dao.TCustomerDao;
import jp.co.senrido.dao.TDiscomfortFatigueDao;
import jp.co.senrido.dao.TEyeUsageStatusDao;
import jp.co.senrido.dao.TGlareDao;
import jp.co.senrido.dao.TGlassesUsageDao;
import jp.co.senrido.dao.THobbiesClubActivitiesDao;
import jp.co.senrido.dao.TOccupationDao;
import jp.co.senrido.dao.TOngoingDiseasesMedicationDao;
import jp.co.senrido.dao.TPastMedicalHistoryDao;
import jp.co.senrido.dao.TPrescribedLensStrengthDao;
import jp.co.senrido.dao.TSurgeryDao;
import jp.co.senrido.dao.TSymptomsDao;
import jp.co.senrido.dao.TTroubleDao;
import jp.co.senrido.dao.TUsageStatusDao;
import jp.co.senrido.dao.TVisionLossDao;
import jp.co.senrido.dao.TVisitingHospitalDao;
import jp.co.senrido.dto.TCriticalVisibilityNeedsDto;
import jp.co.senrido.dto.TCustomerDto;
import jp.co.senrido.dto.TCustomerInitDto;
import jp.co.senrido.dto.TDiscomfortFatigueDto;
import jp.co.senrido.dto.TEyeUsageStatusDto;
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
import jp.co.senrido.entity.TCriticalVisibilityNeeds;
import jp.co.senrido.entity.TCustomer;
import jp.co.senrido.entity.TDiscomfortFatigue;
import jp.co.senrido.entity.TEyeUsageStatus;
import jp.co.senrido.entity.TGlare;
import jp.co.senrido.entity.TGlassesUsage;
import jp.co.senrido.entity.THobbiesClubActivities;
import jp.co.senrido.entity.TOccupation;
import jp.co.senrido.entity.TOngoingDiseasesMedication;
import jp.co.senrido.entity.TPastMedicalHistory;
import jp.co.senrido.entity.TPrescribedLensStrength;
import jp.co.senrido.entity.TSurgery;
import jp.co.senrido.entity.TSurvey;
import jp.co.senrido.entity.TSymptoms;
import jp.co.senrido.entity.TTrouble;
import jp.co.senrido.entity.TUsageStatus;
import jp.co.senrido.entity.TVisionLoss;
import jp.co.senrido.entity.TVisitingHospital;
import jp.co.senrido.entity.ext.TCustomerExt;
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
	private TSurgeryDao tSurgeryDao;

	@Autowired
	private TVisionLossDao tVisionLossDao;

	@Autowired
	private TGlassesUsageDao tGlassesUsageDao;

	@Autowired
	private TUsageStatusDao tUsageStatusDao;

	@Autowired
	private TPrescribedLensStrengthDao tPrescribedLensStrengthDao;

	@Autowired
	private TTroubleDao tTroubleDao;

	@Autowired
	private TSymptomsDao tSymptomsDao;

	@Autowired
	private TGlareDao tGlareDao;

	@Autowired
	private TDiscomfortFatigueDao tDiscomfortFatigueDao;

	@Autowired
	private TCriticalVisibilityNeedsDao tCriticalVisibilityNeedsDao;

	@Autowired
	private TOccupationDao tOccupationDao;

	@Autowired
	private THobbiesClubActivitiesDao tHobbiesClubActivitiesDao;

	@Autowired
	private TEyeUsageStatusDao tEyeUsageStatusDao;

	@Autowired
	private TPastMedicalHistoryDao tPastMedicalHistoryDao;

	@Autowired
	private TOngoingDiseasesMedicationDao tOngoingDiseasesMedicationDao;

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
		List<TVisitingHospitalDto> visitingHospitalInfoList = searchByTvisitingHospitalInfo(id);
		// 眼の手術情報取得
		List<TSurgeryDto> surgeryInfoList = searchByTSurgeryInfo(id);
		// 視力低下情報取得
		List<TVisionLossDto> visionLossInfoList = searchByTVisionLossInfo(id);
		// メガネ装用情報取得
		List<TGlassesUsageDto> glassesUsageInfoList = searchByTGlassesUsageInfo(id);
		// 装用情報取得
		List<TUsageStatusDto> usageStatusInfoList = searchByTUsageStatusInfo(id);
		// 装用情報取得
		List<TTroubleDto> troubleInfoList = searchByTTroubleInfo(id);
		// 症状情報取得
		List<TSymptomsDto> symptomsInfoList = searchByTSymptomsInfo(id);
		// 眩しさ情報取得
		List<TGlareDto> glareInfoList = searchByTGlareInfo(id);
		// 見づらさ疲れ情報取得
		List<TDiscomfortFatigueDto> discomfortFatigueInfoList = searchByTDiscomfortFatigueInfo(id);
		// 見えないと困るもの情報取得
		List<TCriticalVisibilityNeedsDto> criticalVisibilityNeedsInfoList = searchByTCriticalVisibilityNeedsInfo(id);
		// 職業情報取得
		List<TOccupationDto> occupationInfoList = searchByTOccupationInfo(id);
		// 趣味部活情報取得
		List<THobbiesClubActivitiesDto> hobbiesClubActivitiesInfoList = searchByTHobbiesClubActivitiesInfo(id);

		// 過去の病歴情報取得
		List<TPastMedicalHistoryDto> pastMedicalHistoryInfoList = searchByTPastMedicalHistoryInfo(id);
		// 治療中の疫病・服用薬情報取得
		List<TOngoingDiseasesMedicationDto> ongoingDiseasesMedicationInfoList = searchByTOngoingDiseasesMedicationInfo(id);

		// 性別リスト取得
		io.setSexList(mCodeMasterService.getMCode("sex"));
		// 眼科への通院リスト取得
		io.setVisitingHospitalItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.MEDICAL_HISTORY));
		// 眼の症状リスト取得
		io.setSurgeryTargetItems(mCodeMasterService.getMCode(SenridoConstant.DivCode.SURGERY_TARGET));
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
		io.setPrescriptionStrengthNameItems(
				mCodeMasterService.getMCode(SenridoConstant.DivCode.PRESCRIPTION_STRENGTH_NAME));
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
		io.setSurgeryInfoList(surgeryInfoList);
		io.setVisionLossInfoList(visionLossInfoList);
		io.setGlassesUsageInfoList(glassesUsageInfoList);
		io.setUsageStatusInfoList(usageStatusInfoList);
		io.setTroubleInfoList(troubleInfoList);
		io.setSymptomsInfoList(symptomsInfoList);
		io.setGlareInfoList(glareInfoList);
		io.setDiscomfortFatigueInfoList(discomfortFatigueInfoList);
		io.setCriticalVisibilityNeedsInfoList(criticalVisibilityNeedsInfoList);
		io.setOccupationInfoList(occupationInfoList);
		io.setHobbiesClubActivitiesInfoList(hobbiesClubActivitiesInfoList);
		io.setPastMedicalHistoryInfoList(pastMedicalHistoryInfoList);
		io.setOngoingDiseasesMedicationInfoList(ongoingDiseasesMedicationInfoList);
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
		TCustomerExt entity = tCustomerDao.selectByTCustomerInfo(id);
		if (!ObjectUtils.isEmpty(entity)) {
			BeanUtils.copyProperties(entity, customerInfo);
		}

		// データ整形
		// 生年月日
		if (!ObjectUtils.isEmpty(entity.getBirthday())) {
			customerInfo.setBirthday(entity.getBirthday().toString());
			// 和暦変換
			customerInfo.setBirthdayStr(DateUtil.changeFormat(entity.getBirthday(), DateUtil.DATE_FORMAT_YMD_SLASH));
		}
		// 前回来店日
		if (!ObjectUtils.isEmpty(entity.getPreviousVisitDate())) {
			// 和暦変換
			customerInfo.setPreviousVisitDateStr(
					DateUtil.changeFormat(entity.getPreviousVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
		}
		// 次回来店日
		if (!ObjectUtils.isEmpty(entity.getNextVisitDate())) {
			customerInfo.setNextVisitDate(entity.getNextVisitDate().toString());
			// 和暦変換
			customerInfo.setNextVisitDateStr(
					DateUtil.changeFormat(entity.getNextVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
		}

		return customerInfo;
	}

	/**
	 * 初期表示
	 *
	 * @param id
	 * @param visitDate
	 * @return headerInfo
	 */
	@Transactional(rollbackFor = Throwable.class)
	public List<TVisitingHospitalDto> searchByTvisitingHospitalInfo(Integer id) throws Throwable {
		List<TVisitingHospitalDto> visitingHospitalInfoList = new ArrayList<>();

		// 検索条件に該当するxxx情報を取得
		List<TVisitingHospital> entityList = tVisitingHospitalDao.selectById(id);
		if (!ObjectUtils.isEmpty(entityList)) {
			for (TVisitingHospital entity : entityList) {
				TVisitingHospitalDto dto = new TVisitingHospitalDto();
				BeanUtils.copyProperties(entity, dto);
				if (!ObjectUtils.isEmpty(entity.getVisitDate())) { // 和暦変換
					dto.setVisitDateStr(DateUtil.changeFormat(entity.getVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
				}
				if (!ObjectUtils.isEmpty(entity.getConsultationDate())) { // 和暦変換
					dto.setConsultationDateStr(
							DateUtil.changeFormat(entity.getConsultationDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
				}
				if (entity.getVisitEyeDoctor() != null && entity.getVisitEyeDoctor().toString() == "true") {
					dto.setVisitEyeDoctor("あり");
				} else if (entity.getVisitEyeDoctor() != null && entity.getVisitEyeDoctor().toString() == "false") {
					dto.setVisitEyeDoctor("なし");
				}
				if (entity.getGlassesMaking() != null && entity.getGlassesMaking().toString() == "true") {
					dto.setGlassesMaking("あり");
				} else if (entity.getGlassesMaking() != null && entity.getGlassesMaking().toString() == "false") {
					dto.setGlassesMaking("なし");
				}
				if (entity.getPrescription() != null && entity.getPrescription().toString() == "true") {
					dto.setPrescription("あり");
				} else if (entity.getPrescription() != null && entity.getPrescription().toString() == "false") {
					dto.setPrescription("なし");
				}

				visitingHospitalInfoList.add(dto);
			}
		}

		return visitingHospitalInfoList;
	}

	/**
	 * 初期表示
	 *
	 * @param id
	 * @param visitDate
	 * @return headerInfo
	 */
	@Transactional(rollbackFor = Throwable.class)
	public List<TSurgeryDto> searchByTSurgeryInfo(Integer id) throws Throwable {
		List<TSurgeryDto> surgeryInfoList = new ArrayList<>();

		// 検索条件に該当するxxx情報を取得
		List<TSurgery> entityList = tSurgeryDao.selectById(id);
		if (!ObjectUtils.isEmpty(entityList)) {
			for (TSurgery entity : entityList) {
				TSurgeryDto dto = new TSurgeryDto();
				BeanUtils.copyProperties(entity, dto);
				if (!ObjectUtils.isEmpty(entity.getVisitDate())) { // 和暦変換
					dto.setVisitDateStr(DateUtil.changeFormat(entity.getVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
				}
				if (!ObjectUtils.isEmpty(entity.getSurgeryDate())) { // 和暦変換
					dto.setSurgeryDateStr(
							DateUtil.changeFormat(entity.getSurgeryDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
				}
				if (!ObjectUtils.isEmpty(entity.getSurgeryPlannedDate())) { // 和暦変換
					dto.setSurgeryPlannedDateStr(
							DateUtil.changeFormat(entity.getSurgeryPlannedDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
				}

				surgeryInfoList.add(dto);
			}
		}

		return surgeryInfoList;
	}

	/**
	 * 初期表示
	 *
	 * @param id
	 * @param visitDate
	 * @return headerInfo
	 */
	@Transactional(rollbackFor = Throwable.class)
	public List<TVisionLossDto> searchByTVisionLossInfo(Integer id) throws Throwable {
		List<TVisionLossDto> visionLossInfoList = new ArrayList<>();

		// 検索条件に該当するxxx情報を取得
		List<TVisionLoss> entityList = tVisionLossDao.selectById(id);
		if (!ObjectUtils.isEmpty(entityList)) {
			for (TVisionLoss entity : entityList) {
				TVisionLossDto dto = new TVisionLossDto();
				BeanUtils.copyProperties(entity, dto);
				if (!ObjectUtils.isEmpty(entity.getVisitDate())) { // 和暦変換
					dto.setVisitDateStr(DateUtil.changeFormat(entity.getVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
				}
				if (entity.getDecreaseEyesight() != null) {
					dto.setDecreaseEyesight(entity.getDecreaseEyesight().toString());
				}

				visionLossInfoList.add(dto);
			}
		}

		return visionLossInfoList;
	}

	/**
	 * 初期表示
	 *
	 * @param id
	 * @param visitDate
	 * @return headerInfo
	 */
	@Transactional(rollbackFor = Throwable.class)
	public List<TGlassesUsageDto> searchByTGlassesUsageInfo(Integer id) throws Throwable {
		List<TGlassesUsageDto> glassesUsageInfoList = new ArrayList<>();

		// 検索条件に該当するxxx情報を取得
		List<TGlassesUsage> entityList = tGlassesUsageDao.selectById(id);
		if (!ObjectUtils.isEmpty(entityList)) {
			for (TGlassesUsage entity : entityList) {
				TGlassesUsageDto dto = new TGlassesUsageDto();
				BeanUtils.copyProperties(entity, dto);
				if (!ObjectUtils.isEmpty(entity.getVisitDate())) { // 和暦変換
					dto.setVisitDateStr(DateUtil.changeFormat(entity.getVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
				}
				if (entity.getUseGlasses() != null) {
					dto.setUseGlasses(entity.getUseGlasses().toString());
				}

				glassesUsageInfoList.add(dto);
			}
		}

		return glassesUsageInfoList;
	}

	/**
	 * 初期表示
	 *
	 * @param id
	 * @param visitDate
	 * @return headerInfo
	 */
	@Transactional(rollbackFor = Throwable.class)
	public List<TUsageStatusDto> searchByTUsageStatusInfo(Integer id) throws Throwable {
		List<TUsageStatusDto> usageStatusInfoList = new ArrayList<>();

		// 検索条件に該当するxxx情報を取得
		List<TUsageStatus> entityList = tUsageStatusDao.selectById(id);
		if (!ObjectUtils.isEmpty(entityList)) {
			for (TUsageStatus entity : entityList) {
				TUsageStatusDto dto = new TUsageStatusDto();
				BeanUtils.copyProperties(entity, dto);
				if (!ObjectUtils.isEmpty(entity.getVisitDate())) { // 和暦変換
					dto.setVisitDateStr(DateUtil.changeFormat(entity.getVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
				}

				usageStatusInfoList.add(dto);
			}
		}

		return usageStatusInfoList;
	}

	/**
	 * 初期表示
	 *
	 * @param id
	 * @param visitDate
	 * @return headerInfo
	 */
	@Transactional(rollbackFor = Throwable.class)
	public List<TTroubleDto> searchByTTroubleInfo(Integer id) throws Throwable {
		List<TTroubleDto> troubleInfoList = new ArrayList<>();

		// 検索条件に該当するxxx情報を取得
		List<TTrouble> entityList = tTroubleDao.selectById(id);
		if (!ObjectUtils.isEmpty(entityList)) {
			for (TTrouble entity : entityList) {
				TTroubleDto dto = new TTroubleDto();
				BeanUtils.copyProperties(entity, dto);
				if (!ObjectUtils.isEmpty(entity.getVisitDate())) { // 和暦変換
					dto.setVisitDateStr(DateUtil.changeFormat(entity.getVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
				}

				troubleInfoList.add(dto);
			}
		}

		return troubleInfoList;
	}

	/**
	 * 初期表示
	 *
	 * @param id
	 * @param visitDate
	 * @return headerInfo
	 */
	@Transactional(rollbackFor = Throwable.class)
	public List<TSymptomsDto> searchByTSymptomsInfo(Integer id) throws Throwable {
		List<TSymptomsDto> symptomsInfoList = new ArrayList<>();

		// 検索条件に該当するxxx情報を取得
		List<TSymptoms> entityList = tSymptomsDao.selectById(id);
		if (!ObjectUtils.isEmpty(entityList)) {
			for (TSymptoms entity : entityList) {
				TSymptomsDto dto = new TSymptomsDto();
				BeanUtils.copyProperties(entity, dto);
				if (!ObjectUtils.isEmpty(entity.getVisitDate())) { // 和暦変換
					dto.setVisitDateStr(DateUtil.changeFormat(entity.getVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
				}

				symptomsInfoList.add(dto);
			}
		}

		return symptomsInfoList;
	}

	/**
	 * 初期表示
	 *
	 * @param id
	 * @param visitDate
	 * @return headerInfo
	 */
	@Transactional(rollbackFor = Throwable.class)
	public List<TGlareDto> searchByTGlareInfo(Integer id) throws Throwable {
		List<TGlareDto> glareInfoList = new ArrayList<>();

		// 検索条件に該当するxxx情報を取得
		List<TGlare> entityList = tGlareDao.selectById(id);
		if (!ObjectUtils.isEmpty(entityList)) {
			for (TGlare entity : entityList) {
				TGlareDto dto = new TGlareDto();
				BeanUtils.copyProperties(entity, dto);
				if (!ObjectUtils.isEmpty(entity.getVisitDate())) { // 和暦変換
					dto.setVisitDateStr(DateUtil.changeFormat(entity.getVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
				}
				if (entity.getEyePainStrongLight() != null && entity.getEyePainStrongLight().toString() == "true") {
					dto.setEyePainStrongLight("あり");
				} else if (entity.getEyePainStrongLight() != null
						&& entity.getEyePainStrongLight().toString() == "false") {
					dto.setEyePainStrongLight("なし");
				}
				glareInfoList.add(dto);
			}
		}

		return glareInfoList;
	}

	/**
	 * 初期表示
	 *
	 * @param id
	 * @param visitDate
	 * @return headerInfo
	 */
	@Transactional(rollbackFor = Throwable.class)
	public List<TDiscomfortFatigueDto> searchByTDiscomfortFatigueInfo(Integer id) throws Throwable {
		List<TDiscomfortFatigueDto> discomfortFatigueInfoList = new ArrayList<>();

		// 検索条件に該当するxxx情報を取得
		List<TDiscomfortFatigue> entityList = tDiscomfortFatigueDao.selectById(id);
		if (!ObjectUtils.isEmpty(entityList)) {
			for (TDiscomfortFatigue entity : entityList) {
				TDiscomfortFatigueDto dto = new TDiscomfortFatigueDto();
				BeanUtils.copyProperties(entity, dto);
				if (!ObjectUtils.isEmpty(entity.getVisitDate())) { // 和暦変換
					dto.setVisitDateStr(DateUtil.changeFormat(entity.getVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
				}
				discomfortFatigueInfoList.add(dto);
			}
		}

		return discomfortFatigueInfoList;
	}

	/**
	 * 初期表示
	 *
	 * @param id
	 * @param visitDate
	 * @return headerInfo
	 */
	@Transactional(rollbackFor = Throwable.class)
	public List<TCriticalVisibilityNeedsDto> searchByTCriticalVisibilityNeedsInfo(Integer id) throws Throwable {
		List<TCriticalVisibilityNeedsDto> criticalVisibilityNeedsInfoList = new ArrayList<>();

		// 検索条件に該当するxxx情報を取得
		List<TCriticalVisibilityNeeds> entityList = tCriticalVisibilityNeedsDao.selectById(id);
		if (!ObjectUtils.isEmpty(entityList)) {
			for (TCriticalVisibilityNeeds entity : entityList) {
				TCriticalVisibilityNeedsDto dto = new TCriticalVisibilityNeedsDto();
				BeanUtils.copyProperties(entity, dto);
				if (!ObjectUtils.isEmpty(entity.getVisitDate())) { // 和暦変換
					dto.setVisitDateStr(DateUtil.changeFormat(entity.getVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
				}
				criticalVisibilityNeedsInfoList.add(dto);
			}
		}

		return criticalVisibilityNeedsInfoList;
	}

	/**
	 * 初期表示
	 *
	 * @param id
	 * @param visitDate
	 * @return headerInfo
	 */
	@Transactional(rollbackFor = Throwable.class)
	public List<TOccupationDto> searchByTOccupationInfo(Integer id) throws Throwable {
		List<TOccupationDto> occupationInfoList = new ArrayList<>();

		// 検索条件に該当するxxx情報を取得
		List<TOccupation> entityList = tOccupationDao.selectById(id);
		if (!ObjectUtils.isEmpty(entityList)) {
			for (TOccupation entity : entityList) {
				TOccupationDto dto = new TOccupationDto();
				BeanUtils.copyProperties(entity, dto);
				if (!ObjectUtils.isEmpty(entity.getVisitDate())) { // 和暦変換
					dto.setVisitDateStr(DateUtil.changeFormat(entity.getVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
				}
				occupationInfoList.add(dto);
			}
		}

		return occupationInfoList;
	}

	/**
	 * 初期表示
	 *
	 * @param id
	 * @param visitDate
	 * @return headerInfo
	 */
	@Transactional(rollbackFor = Throwable.class)
	public List<THobbiesClubActivitiesDto> searchByTHobbiesClubActivitiesInfo(Integer id) throws Throwable {
		List<THobbiesClubActivitiesDto> hobbiesClubActivitiesInfoList = new ArrayList<>();

		// 検索条件に該当するxxx情報を取得
		List<THobbiesClubActivities> entityList = tHobbiesClubActivitiesDao.selectById(id);
		if (!ObjectUtils.isEmpty(entityList)) {
			for (THobbiesClubActivities entity : entityList) {
				THobbiesClubActivitiesDto dto = new THobbiesClubActivitiesDto();
				BeanUtils.copyProperties(entity, dto);
				if (!ObjectUtils.isEmpty(entity.getVisitDate())) { // 和暦変換
					dto.setVisitDateStr(DateUtil.changeFormat(entity.getVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
				}
				hobbiesClubActivitiesInfoList.add(dto);
			}
		}

		return hobbiesClubActivitiesInfoList;
	}

	/**
	 * 初期表示
	 *
	 * @param id
	 * @param visitDate
	 * @return headerInfo
	 */
	@Transactional(rollbackFor = Throwable.class)
	public List<TPastMedicalHistoryDto> searchByTPastMedicalHistoryInfo(Integer id) throws Throwable {
		List<TPastMedicalHistoryDto> pastMedicalHistoryInfoList = new ArrayList<>();

		// 検索条件に該当するxxx情報を取得
		List<TPastMedicalHistory> entityList = tPastMedicalHistoryDao.selectById(id);
		if (!ObjectUtils.isEmpty(entityList)) {
			for (TPastMedicalHistory entity : entityList) {
				TPastMedicalHistoryDto dto = new TPastMedicalHistoryDto();
				BeanUtils.copyProperties(entity, dto);
				if (!ObjectUtils.isEmpty(entity.getVisitDate())) { // 和暦変換
					dto.setVisitDateStr(DateUtil.changeFormat(entity.getVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
				}
				pastMedicalHistoryInfoList.add(dto);
			}
		}

		return pastMedicalHistoryInfoList;
	}
	
	/**
	 * 初期表示
	 *
	 * @param id
	 * @param visitDate
	 * @return headerInfo
	 */
	@Transactional(rollbackFor = Throwable.class)
	public List<TOngoingDiseasesMedicationDto> searchByTOngoingDiseasesMedicationInfo(Integer id) throws Throwable {
		List<TOngoingDiseasesMedicationDto> ongoingDiseasesMedicationInfoList = new ArrayList<>();

		// 検索条件に該当するxxx情報を取得
		List<TOngoingDiseasesMedication> entityList = tOngoingDiseasesMedicationDao.selectById(id);
		if (!ObjectUtils.isEmpty(entityList)) {
			for (TOngoingDiseasesMedication entity : entityList) {
				TOngoingDiseasesMedicationDto dto = new TOngoingDiseasesMedicationDto();
				BeanUtils.copyProperties(entity, dto);
				if (!ObjectUtils.isEmpty(entity.getVisitDate())) { // 和暦変換
					dto.setVisitDateStr(DateUtil.changeFormat(entity.getVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
				}
				ongoingDiseasesMedicationInfoList.add(dto);
			}
		}

		return ongoingDiseasesMedicationInfoList;
	}

	/**
	 * アンケート登録処理.
	 * 
	 * @param fromAddress
	 * @throws Throwable
	 */
	public void insertCustomer(TCustomerInitDto dto) throws Throwable {

		TCustomer tCustomer = new TCustomer();

		// お客様ID最大値取得
		Integer maxId = null;

		maxId = tCustomerDao.selectMaxId();

		maxId++;

		// お客様情報に基本情報を登録
		// コピー
		BeanUtils.copyProperties(dto, tCustomer);
		// 日付項目は個別に設定
		tCustomer.setBirthday(DateUtil.changeFormatStrToLocalDate(dto.getBirthday()));
		tCustomer.setId(maxId);
		tCustomer.setDelFlg(false);
		tCustomer.setUpdateDate(this.createCurrentDate());
		tCustomer.setUpdateId("system");
		tCustomer.setCreateDate(this.createCurrentDate());
		tCustomer.setCreateId("system");
		tCustomerDao.insert(tCustomer);

	}

	/**
	 * 登録・更新処理
	 *
	 * @param basicNo
	 * @return standardInfo
	 */

	@Transactional(rollbackFor = Throwable.class)
	public String upsertCustomer(TCustomerDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;
		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// 登録済み情報を取得する
		TCustomer tCustomer = tCustomerDao.selectById(dto.getId());

		// 更新情報を設定
		BeanUtils.copyProperties(dto, tCustomer);

		tCustomer.setNextVisitDate(DateUtil.changeFormatStrToLocalDate(dto.getNextVisitDate()));
		tCustomer.setUpdateDate(localTimeNow);
		tCustomer.setUpdateId(userDto.getUserCd());
		tCustomer.setDelFlg(SenridoConstant.DELFLG_EFFECT);
		tCustomerDao.update(tCustomer);

		// 成功処理
		resultCd = SenridoConstant.SUCCESS;

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
		List<TPrescribedLensStrength> tPrescribedLensStrengthResult = tPrescribedLensStrengthDao.selectById(dto.getId(),
				localTimeNow);

		// 取得結果がnullの場合、登録
		if (ObjectUtils.isEmpty(tPrescribedLensStrengthResult)) {

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

	/**
	 * 登録・更新処理
	 *
	 * @param basicNo
	 * @return standardInfo
	 */

	@Transactional(rollbackFor = Throwable.class)
	public String upsertVisitingHospital(TVisitingHospitalDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;

		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// お客様情報検索
		TVisitingHospital tVisitingHospital = tVisitingHospitalDao.selectByDto(dto.getId(),
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));

		boolean isInsert = false;
		if (tVisitingHospital == null) {
			tVisitingHospital = new TVisitingHospital();
			isInsert = true;
		}

		// 登録情報を設定
		BeanUtils.copyProperties(dto, tVisitingHospital);

		tVisitingHospital.setId(dto.getId());
		tVisitingHospital.setVisitDate(
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		String visitEyeDoctorStr = dto.getVisitEyeDoctor();
		if (visitEyeDoctorStr != null) {
			tVisitingHospital.setVisitEyeDoctor(Boolean.valueOf(visitEyeDoctorStr));
		}
		tVisitingHospital.setConsultationDate(DateUtil.changeFormatStrToLocalDate(dto.getConsultationDate()));
		if (dto.getMedicalHistory() != null) {
			tVisitingHospital.setMedicalHistory(String.join(",", dto.getMedicalHistory()));
			tVisitingHospital.setMedicalHistoryName(
					chaceCodeToName(SenridoConstant.DivCode.MEDICAL_HISTORY, dto.getMedicalHistory()));
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

		if (isInsert) {
			tVisitingHospital.setCreateDate(localTimeNow);
			tVisitingHospital.setCreateId(userDto.getUserCd());
			tVisitingHospitalDao.insert(tVisitingHospital);
		} else {
			tVisitingHospitalDao.update(tVisitingHospital);
		}

		resultCd = SenridoConstant.SUCCESS;

		return resultCd;
	}

	/**
	 * 登録・更新処理
	 *
	 * @param basicNo
	 * @return standardInfo
	 */

	@Transactional(rollbackFor = Throwable.class)
	public String upsertOperation(TSurgeryDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;

		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// お客様情報検索
		TSurgery tSurgery = tSurgeryDao.selectByDto(dto.getId(),
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));

		boolean isInsert = false;
		if (tSurgery == null) {
			tSurgery = new TSurgery();
			isInsert = true;
		}

		BeanUtils.copyProperties(dto, tSurgery);

		tSurgery.setId(dto.getId());
		tSurgery.setVisitDate(
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		tSurgery.setSurgeryDate(
				DateUtil.changeFormatStrToLocalDateTime(dto.getSurgeryDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		tSurgery.setSurgeryPlannedDate(
				DateUtil.changeFormatStrToLocalDateTime(dto.getSurgeryPlannedDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		if (dto.getCataract() != null) {
			tSurgery.setCataract(String.join(",", dto.getCataract()));
			tSurgery.setCataractName((SenridoConstant.Surgery.CATARACT)
					+ chaceCodeToName(SenridoConstant.DivCode.SURGERY_TARGET, dto.getCataract()));
		}
		if (dto.getGlaucoma() != null) {
			tSurgery.setGlaucoma(String.join(",", dto.getGlaucoma()));
			tSurgery.setGlaucomaName((SenridoConstant.Surgery.GLAUCOMA)
					+ chaceCodeToName(SenridoConstant.DivCode.SURGERY_TARGET, dto.getGlaucoma()));
		}
		if (dto.getFloaters() != null) {
			tSurgery.setFloaters(String.join(",", dto.getFloaters()));
			tSurgery.setFloatersName((SenridoConstant.Surgery.FLOATERS)
					+ chaceCodeToName(SenridoConstant.DivCode.SURGERY_TARGET, dto.getFloaters()));
		}
		if (dto.getRetinalDetachment() != null) {
			tSurgery.setRetinalDetachment(String.join(",", dto.getRetinalDetachment()));
			tSurgery.setRetinalDetachmentName((SenridoConstant.Surgery.RETINAL_DETACHMENT)
					+ chaceCodeToName(SenridoConstant.DivCode.SURGERY_TARGET, dto.getRetinalDetachment()));
		}
		if (dto.getStrabismus() != null) {
			tSurgery.setStrabismus(String.join(",", dto.getStrabismus()));
			tSurgery.setStrabismusName((SenridoConstant.Surgery.STRABISMUS)
					+ chaceCodeToName(SenridoConstant.DivCode.SURGERY_TARGET, dto.getStrabismus()));
		}
		if (dto.getVitreousBody() != null) {
			tSurgery.setVitreousBody(String.join(",", dto.getVitreousBody()));
			tSurgery.setVitreousBodyName((SenridoConstant.Surgery.VITREOUS_BODY)
					+ chaceCodeToName(SenridoConstant.DivCode.SURGERY_TARGET, dto.getVitreousBody()));
		}
		if (dto.getLasik() != null) {
			tSurgery.setLasik(String.join(",", dto.getLasik()));
			tSurgery.setLasikName((SenridoConstant.Surgery.LASIK)
					+ chaceCodeToName(SenridoConstant.DivCode.SURGERY_TARGET, dto.getLasik()));
		}
		if (dto.getIclIol() != null) {
			tSurgery.setIclIol(String.join(",", dto.getIclIol()));
			tSurgery.setIclIolName((SenridoConstant.Surgery.ICL_IOL)
					+ chaceCodeToName(SenridoConstant.DivCode.SURGERY_TARGET, dto.getIclIol()));
		}

		tSurgery.setUpdateDate(localTimeNow);
		tSurgery.setUpdateId(userDto.getUserCd());
		tSurgery.setDelFlg(SenridoConstant.DELFLG_EFFECT);

		if (isInsert) {
			tSurgery.setCreateDate(localTimeNow);
			tSurgery.setCreateId(userDto.getUserCd());
			tSurgeryDao.insert(tSurgery);
		} else {
			tSurgeryDao.update(tSurgery);
		}

		resultCd = SenridoConstant.SUCCESS;

		return resultCd;
	}

	/**
	 * 登録・更新処理
	 *
	 * @param basicNo
	 * @return standardInfo
	 */

	@Transactional(rollbackFor = Throwable.class)
	public String upsertImpairedVision(TVisionLossDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;

		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// お客様情報検索
		TVisionLoss tVisionLoss = tVisionLossDao.selectByDto(dto.getId(),
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));

		boolean isInsert = false;
		if (tVisionLoss == null) {
			tVisionLoss = new TVisionLoss();
			isInsert = true;
		}

		// 登録情報を設定
		BeanUtils.copyProperties(dto, tVisionLoss);

		tVisionLoss.setId(dto.getId());
		tVisionLoss.setVisitDate(
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		if (dto.getDecreaseEyesight() != null) {
			tVisionLoss.setDecreaseEyesight(Integer.parseInt(dto.getDecreaseEyesight()));
		}
		tVisionLoss.setUpdateDate(localTimeNow);
		tVisionLoss.setUpdateId(userDto.getUserCd());
		tVisionLoss.setDelFlg(SenridoConstant.DELFLG_EFFECT);

		if (isInsert) {
			tVisionLoss.setCreateDate(localTimeNow);
			tVisionLoss.setCreateId(userDto.getUserCd());
			tVisionLossDao.insert(tVisionLoss);
		} else {
			tVisionLossDao.update(tVisionLoss);
		}

		resultCd = SenridoConstant.SUCCESS;

		return resultCd;
	}

	/**
	 * 登録・更新処理
	 *
	 * @param basicNo
	 * @return standardInfo
	 */

	@Transactional(rollbackFor = Throwable.class)
	public String upsertWearingGlasses(TGlassesUsageDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;

		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// お客様情報検索
		TGlassesUsage tGlassesUsage = tGlassesUsageDao.selectByDto(dto.getId(),
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));

		boolean isInsert = false;
		if (tGlassesUsage == null) {
			tGlassesUsage = new TGlassesUsage();
			isInsert = true;
		}

		// 登録情報を設定
		BeanUtils.copyProperties(dto, tGlassesUsage);

		tGlassesUsage.setId(dto.getId());
		tGlassesUsage.setVisitDate(
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		if (dto.getUseGlasses() != null) {
			tGlassesUsage.setUseGlasses(Integer.parseInt(dto.getUseGlasses()));
		}
		tGlassesUsage.setUpdateDate(localTimeNow);
		tGlassesUsage.setUpdateId(userDto.getUserCd());
		tGlassesUsage.setDelFlg(SenridoConstant.DELFLG_EFFECT);

		if (isInsert) {
			tGlassesUsage.setCreateDate(localTimeNow);
			tGlassesUsage.setCreateId(userDto.getUserCd());
			tGlassesUsageDao.insert(tGlassesUsage);
		} else {
			tGlassesUsageDao.update(tGlassesUsage);
		}

		resultCd = SenridoConstant.SUCCESS;

		return resultCd;
	}

	/**
	 * 登録・更新処理
	 *
	 * @param basicNo
	 * @return standardInfo
	 */

	@Transactional(rollbackFor = Throwable.class)
	public String upsertWearingSituation(TUsageStatusDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;

		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// お客様情報検索
		TUsageStatus tUsageStatus = tUsageStatusDao.selectByDto(dto.getId(),
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));

		boolean isInsert = false;
		if (tUsageStatus == null) {
			tUsageStatus = new TUsageStatus();
			isInsert = true;
		}

		// 登録情報を設定
		BeanUtils.copyProperties(dto, tUsageStatus);

		tUsageStatus.setId(dto.getId());
		tUsageStatus.setVisitDate(
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		if (dto.getCurrentStatusCd() != null) {
			tUsageStatus.setCurrentStatusCd(String.join(",", dto.getCurrentStatusCd()));
			tUsageStatus.setGlassesClUsageCurrentName(
					chaceCodeToName(SenridoConstant.DivCode.USE_GLASSES_CURRENT, dto.getCurrentStatusCd()));
		}
		if (dto.getCombinedUseClCd() != null) {
			tUsageStatus.setCombinedUseClCd(String.join(",", dto.getCombinedUseClCd()));
			tUsageStatus.setGlassesClUsageCombinedName(
					chaceCodeToName(SenridoConstant.DivCode.USE_GLASSES_WITH_CL, dto.getCombinedUseClCd()));
		}
		if (dto.getGlassesPurpose() != null) {
			tUsageStatus.setGlassesPurpose(String.join(",", dto.getGlassesPurpose()));
			tUsageStatus.setGlassesPurposeName(
					chaceCodeToName(SenridoConstant.DivCode.USE_GLASSES_PURPOSE, dto.getGlassesPurpose()));
		}
		tUsageStatus.setUpdateDate(localTimeNow);
		tUsageStatus.setUpdateId(userDto.getUserCd());
		tUsageStatus.setDelFlg(SenridoConstant.DELFLG_EFFECT);

		if (isInsert) {
			tUsageStatus.setCreateDate(localTimeNow);
			tUsageStatus.setCreateId(userDto.getUserCd());
			tUsageStatusDao.insert(tUsageStatus);
		} else {
			tUsageStatusDao.update(tUsageStatus);
		}

		resultCd = SenridoConstant.SUCCESS;

		return resultCd;
	}

	/**
	 * 登録・更新処理
	 *
	 * @param basicNo
	 * @return standardInfo
	 */

	@Transactional(rollbackFor = Throwable.class)
	public String upsertGlassesTrouble(TTroubleDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;

		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// お客様情報検索
		TTrouble tTrouble = tTroubleDao.selectByDto(dto.getId(),
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));

		boolean isInsert = false;
		if (tTrouble == null) {
			tTrouble = new TTrouble();
			isInsert = true;
		}

		// 登録情報を設定
		BeanUtils.copyProperties(dto, tTrouble);

		tTrouble.setId(dto.getId());
		tTrouble.setVisitDate(
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		if (dto.getGlassesIssues() != null) {
			tTrouble.setGlassesIssues(String.join(",", dto.getGlassesIssues()));
			tTrouble.setGlassesIssuesName(
					chaceCodeToName(SenridoConstant.DivCode.GLASSES_ISSUES, dto.getGlassesIssues()));
		}
		if (dto.getFrameIssues() != null) {
			tTrouble.setFrameIssues(String.join(",", dto.getFrameIssues()));
			tTrouble.setFrameIssuesName(chaceCodeToName(SenridoConstant.DivCode.FRAME_ISSUES, dto.getFrameIssues()));
		}
		tTrouble.setUpdateDate(localTimeNow);
		tTrouble.setUpdateId(userDto.getUserCd());
		tTrouble.setDelFlg(SenridoConstant.DELFLG_EFFECT);

		if (isInsert) {
			tTrouble.setCreateDate(localTimeNow);
			tTrouble.setCreateId(userDto.getUserCd());
			tTroubleDao.insert(tTrouble);
		} else {
			tTroubleDao.update(tTrouble);
		}

		resultCd = SenridoConstant.SUCCESS;

		return resultCd;
	}

	/**
	 * 登録・更新処理
	 *
	 * @param basicNo
	 * @return standardInfo
	 */

	@Transactional(rollbackFor = Throwable.class)
	public String upsertSymptoms(TSymptomsDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;

		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// お客様情報検索
		TSymptoms tSymptoms = tSymptomsDao.selectByDto(dto.getId(),
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));

		boolean isInsert = false;
		if (tSymptoms == null) {
			tSymptoms = new TSymptoms();
			isInsert = true;
		}

		// 登録情報を設定
		BeanUtils.copyProperties(dto, tSymptoms);

		tSymptoms.setId(dto.getId());
		tSymptoms.setVisitDate(
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		if (dto.getEyeSymptoms() != null) {
			tSymptoms.setEyeSymptoms(String.join(",", dto.getEyeSymptoms()));
			tSymptoms.setEyeSymptomsName(chaceCodeToName(SenridoConstant.DivCode.EYE_SYMPTOMS, dto.getEyeSymptoms()));
		}
		if (dto.getBodySymptoms() != null) {
			tSymptoms.setBodySymptoms(String.join(",", dto.getBodySymptoms()));
			tSymptoms
					.setBodySymptomsName(chaceCodeToName(SenridoConstant.DivCode.BODY_SYMPTOMS, dto.getBodySymptoms()));
		}
		tSymptoms.setUpdateDate(localTimeNow);
		tSymptoms.setUpdateId(userDto.getUserCd());
		tSymptoms.setDelFlg(SenridoConstant.DELFLG_EFFECT);

		if (isInsert) {
			tSymptoms.setCreateDate(localTimeNow);
			tSymptoms.setCreateId(userDto.getUserCd());
			tSymptomsDao.insert(tSymptoms);
		} else {
			tSymptomsDao.update(tSymptoms);
		}

		resultCd = SenridoConstant.SUCCESS;

		return resultCd;
	}

	/**
	 * 登録・更新処理
	 *
	 * @param basicNo
	 * @return standardInfo
	 */

	@Transactional(rollbackFor = Throwable.class)
	public String upsertDazzlingThings(TGlareDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;

		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// お客様情報検索
		TGlare tGlare = tGlareDao.selectByDto(dto.getId(),
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));

		boolean isInsert = false;
		if (tGlare == null) {
			tGlare = new TGlare();
			isInsert = true;
		}

		// 登録情報を設定
		BeanUtils.copyProperties(dto, tGlare);

		tGlare.setId(dto.getId());
		tGlare.setVisitDate(
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		if (dto.getGlareSources() != null) {
			tGlare.setGlareSources(String.join(",", dto.getGlareSources()));
			tGlare.setGlareSourcesName(chaceCodeToName(SenridoConstant.DivCode.GLARE_SOURCES, dto.getGlareSources()));
		}
		String eyePainStrongLightStr = dto.getEyePainStrongLight();
		if (eyePainStrongLightStr != null) {
			tGlare.setEyePainStrongLight(Boolean.valueOf(eyePainStrongLightStr));
		}

		tGlare.setUpdateDate(localTimeNow);
		tGlare.setUpdateId(userDto.getUserCd());
		tGlare.setDelFlg(SenridoConstant.DELFLG_EFFECT);

		if (isInsert) {
			tGlare.setCreateDate(localTimeNow);
			tGlare.setCreateId(userDto.getUserCd());
			tGlareDao.insert(tGlare);
		} else {
			tGlareDao.update(tGlare);
		}

		resultCd = SenridoConstant.SUCCESS;

		return resultCd;
	}

	/**
	 * 登録・更新処理
	 *
	 * @param basicNo
	 * @return standardInfo
	 */

	@Transactional(rollbackFor = Throwable.class)
	public String upsertSeeDiscomfortFatigue(TDiscomfortFatigueDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;

		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// お客様情報検索
		TDiscomfortFatigue tDiscomfortFatigue = tDiscomfortFatigueDao.selectByDto(dto.getId(),
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));

		boolean isInsert = false;
		if (tDiscomfortFatigue == null) {
			tDiscomfortFatigue = new TDiscomfortFatigue();
			isInsert = true;
		}

		// 登録情報を設定
		BeanUtils.copyProperties(dto, tDiscomfortFatigue);

		tDiscomfortFatigue.setId(dto.getId());
		tDiscomfortFatigue.setVisitDate(
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		tDiscomfortFatigue.setUpdateDate(localTimeNow);
		tDiscomfortFatigue.setUpdateId(userDto.getUserCd());
		tDiscomfortFatigue.setDelFlg(SenridoConstant.DELFLG_EFFECT);

		if (isInsert) {
			tDiscomfortFatigue.setCreateDate(localTimeNow);
			tDiscomfortFatigue.setCreateId(userDto.getUserCd());
			tDiscomfortFatigueDao.insert(tDiscomfortFatigue);
		} else {
			tDiscomfortFatigueDao.update(tDiscomfortFatigue);
		}

		resultCd = SenridoConstant.SUCCESS;

		return resultCd;
	}

	/**
	 * 登録・更新処理
	 *
	 * @param basicNo
	 * @return standardInfo
	 */

	@Transactional(rollbackFor = Throwable.class)
	public String upsertSeeProblem(TCriticalVisibilityNeedsDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;

		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// お客様情報検索
		TCriticalVisibilityNeeds tCriticalVisibilityNeeds = tCriticalVisibilityNeedsDao.selectByDto(dto.getId(),
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));

		boolean isInsert = false;
		if (tCriticalVisibilityNeeds == null) {
			tCriticalVisibilityNeeds = new TCriticalVisibilityNeeds();
			isInsert = true;
		}

		// 登録情報を設定
		BeanUtils.copyProperties(dto, tCriticalVisibilityNeeds);

		tCriticalVisibilityNeeds.setId(dto.getId());
		tCriticalVisibilityNeeds.setVisitDate(
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		tCriticalVisibilityNeeds.setUpdateDate(localTimeNow);
		tCriticalVisibilityNeeds.setUpdateId(userDto.getUserCd());
		tCriticalVisibilityNeeds.setDelFlg(SenridoConstant.DELFLG_EFFECT);

		if (isInsert) {
			tCriticalVisibilityNeeds.setCreateDate(localTimeNow);
			tCriticalVisibilityNeeds.setCreateId(userDto.getUserCd());
			tCriticalVisibilityNeedsDao.insert(tCriticalVisibilityNeeds);
		} else {
			tCriticalVisibilityNeedsDao.update(tCriticalVisibilityNeeds);
		}

		resultCd = SenridoConstant.SUCCESS;

		return resultCd;
	}

	/**
	 * 登録・更新処理
	 *
	 * @param basicNo
	 * @return standardInfo
	 */

	@Transactional(rollbackFor = Throwable.class)
	public String upsertOccupation(TOccupationDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;

		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// お客様情報検索
		TOccupation tOccupation = tOccupationDao.selectByDto(dto.getId(),
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));

		boolean isInsert = false;
		if (tOccupation == null) {
			tOccupation = new TOccupation();
			isInsert = true;
		}

		// 登録情報を設定
		BeanUtils.copyProperties(dto, tOccupation);

		tOccupation.setId(dto.getId());
		tOccupation.setVisitDate(
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		tOccupation.setUpdateDate(localTimeNow);
		tOccupation.setUpdateId(userDto.getUserCd());
		tOccupation.setDelFlg(SenridoConstant.DELFLG_EFFECT);

		if (isInsert) {
			tOccupation.setCreateDate(localTimeNow);
			tOccupation.setCreateId(userDto.getUserCd());
			tOccupationDao.insert(tOccupation);
		} else {
			tOccupationDao.update(tOccupation);
		}

		resultCd = SenridoConstant.SUCCESS;

		return resultCd;
	}

	/**
	 * 登録・更新処理
	 *
	 * @param basicNo
	 * @return standardInfo
	 */

	@Transactional(rollbackFor = Throwable.class)
	public String upsertHobbyAndClub(THobbiesClubActivitiesDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;

		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// お客様情報検索
		THobbiesClubActivities tHobbiesClubActivities = tHobbiesClubActivitiesDao.selectByDto(dto.getId(),
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));

		boolean isInsert = false;
		if (tHobbiesClubActivities == null) {
			tHobbiesClubActivities = new THobbiesClubActivities();
			isInsert = true;
		}

		// 登録情報を設定
		BeanUtils.copyProperties(dto, tHobbiesClubActivities);

		tHobbiesClubActivities.setId(dto.getId());
		tHobbiesClubActivities.setVisitDate(
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		tHobbiesClubActivities.setUpdateDate(localTimeNow);
		tHobbiesClubActivities.setUpdateId(userDto.getUserCd());
		tHobbiesClubActivities.setDelFlg(SenridoConstant.DELFLG_EFFECT);

		if (isInsert) {
			tHobbiesClubActivities.setCreateDate(localTimeNow);
			tHobbiesClubActivities.setCreateId(userDto.getUserCd());
			tHobbiesClubActivitiesDao.insert(tHobbiesClubActivities);
		} else {
			tHobbiesClubActivitiesDao.update(tHobbiesClubActivities);
		}

		resultCd = SenridoConstant.SUCCESS;

		return resultCd;
	}

	/**
	 * 登録・更新処理
	 *
	 * @param basicNo
	 * @return standardInfo
	 */

	@Transactional(rollbackFor = Throwable.class)
	public String upsertUsageStatus(TEyeUsageStatusDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;

		TEyeUsageStatus tEyeUsageStatus = new TEyeUsageStatus();

		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// お客様情報検索
		// LocalDateTime visitDate =
		// Timestamp.valueOf(dto.getVisitDate()).toLocalDateTime();
		List<TEyeUsageStatus> tEyeUsageStatusResult = tEyeUsageStatusDao.selectById(dto.getId(), localTimeNow);

		// 取得結果がnullの場合、登録
		if (ObjectUtils.isEmpty(tEyeUsageStatusResult)) {

			// 登録情報を設定
			BeanUtils.copyProperties(dto, tEyeUsageStatus);

			tEyeUsageStatus.setId(dto.getId());
			tEyeUsageStatus.setVisitDate(localTimeNow);
			tEyeUsageStatus.setCreateDate(localTimeNow);
			tEyeUsageStatus.setCreateId(userDto.getUserCd());
			tEyeUsageStatus.setUpdateDate(localTimeNow);
			tEyeUsageStatus.setUpdateId(userDto.getUserCd());
			tEyeUsageStatus.setDelFlg(SenridoConstant.DELFLG_EFFECT);
			tEyeUsageStatusDao.insert(tEyeUsageStatus);

			// 成功処理
			resultCd = SenridoConstant.SUCCESS;

		} else

		{

			// 更新情報を設定
			BeanUtils.copyProperties(dto, tEyeUsageStatus);

			/*
			 * tVisitingHospital.setVisitDate(
			 * DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(),
			 * DateUtil.DATE_FORMAT_YMD_HYPHEN));
			 */
			tEyeUsageStatus.setVisitDate(localTimeNow);
			tEyeUsageStatus.setUpdateDate(localTimeNow);
			tEyeUsageStatus.setUpdateId(userDto.getUserCd());
			tEyeUsageStatus.setDelFlg(SenridoConstant.DELFLG_EFFECT);
			tEyeUsageStatusDao.update(tEyeUsageStatus);

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
	public String upsertCaseHistory(TPastMedicalHistoryDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;

		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// お客様情報検索
		TPastMedicalHistory tPastMedicalHistory = tPastMedicalHistoryDao.selectByDto(dto.getId(),
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));

		boolean isInsert = false;
		if (tPastMedicalHistory == null) {
			tPastMedicalHistory = new TPastMedicalHistory();
			isInsert = true;
		}

		// 登録情報を設定
		BeanUtils.copyProperties(dto, tPastMedicalHistory);

		tPastMedicalHistory.setId(dto.getId());
		tPastMedicalHistory.setVisitDate(
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		tPastMedicalHistory.setUpdateDate(localTimeNow);
		tPastMedicalHistory.setUpdateId(userDto.getUserCd());
		tPastMedicalHistory.setDelFlg(SenridoConstant.DELFLG_EFFECT);

		if (isInsert) {
			tPastMedicalHistory.setCreateDate(localTimeNow);
			tPastMedicalHistory.setCreateId(userDto.getUserCd());
			tPastMedicalHistoryDao.insert(tPastMedicalHistory);
		} else {
			tPastMedicalHistoryDao.update(tPastMedicalHistory);
		}

		resultCd = SenridoConstant.SUCCESS;

		return resultCd;
	}

	/**
	 * 登録・更新処理
	 *
	 * @param basicNo
	 * @return standardInfo
	 */

	@Transactional(rollbackFor = Throwable.class)
	public String upsertTreatmentDisease(TOngoingDiseasesMedicationDto dto) throws Throwable {
		String resultCd = SenridoConstant.ERROR;

		// 現在日時取得
		LocalDateTime localTimeNow = createCurrentDate();

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// お客様情報検索
		TOngoingDiseasesMedication tOngoingDiseasesMedication = tOngoingDiseasesMedicationDao.selectByDto(dto.getId(),
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));

		boolean isInsert = false;
		if (tOngoingDiseasesMedication == null) {
			tOngoingDiseasesMedication = new TOngoingDiseasesMedication();
			isInsert = true;
		}

		// 登録情報を設定
		BeanUtils.copyProperties(dto, tOngoingDiseasesMedication);

		tOngoingDiseasesMedication.setId(dto.getId());
		tOngoingDiseasesMedication.setVisitDate(
				DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		tOngoingDiseasesMedication.setUpdateDate(localTimeNow);
		tOngoingDiseasesMedication.setUpdateId(userDto.getUserCd());
		tOngoingDiseasesMedication.setDelFlg(SenridoConstant.DELFLG_EFFECT);

		if (isInsert) {
			tOngoingDiseasesMedication.setCreateDate(localTimeNow);
			tOngoingDiseasesMedication.setCreateId(userDto.getUserCd());
			tOngoingDiseasesMedicationDao.insert(tOngoingDiseasesMedication);
		} else {
			tOngoingDiseasesMedicationDao.update(tOngoingDiseasesMedication);
		}

		resultCd = SenridoConstant.SUCCESS;

		return resultCd;
	}
}
