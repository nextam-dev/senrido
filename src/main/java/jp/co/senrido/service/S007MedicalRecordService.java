/* =============================================================
 システム名：マキノ祭典　はなこシステム
 ファイル名：MCodeMasterService.java
 --------------------------------------------------------------
 2018(C) マキノ祭典. All Rights Reserved.
 */
package jp.co.senrido.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import jp.co.senrido.common.SenridoConstant;
import jp.co.senrido.dao.MCodeDao;
import jp.co.senrido.dao.TCustomerDao;
import jp.co.senrido.dao.TVisitingHospitalDao;
import jp.co.senrido.dto.CodeNameDto;
import jp.co.senrido.dto.TCustomerDto;
import jp.co.senrido.dto.TVisitingHospitalDto;
import jp.co.senrido.dto.UserDto;
import jp.co.senrido.entity.MCode;
import jp.co.senrido.entity.TCustomer;
import jp.co.senrido.entity.TVisitingHospital;
import jp.co.senrido.json.CommonIO;
import jp.co.senrido.utils.DateUtil;
import jp.co.senrido.utils.ObjectUtil;

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
	private JapaneseCalADConvService japaneseCalADConvService;

	@Autowired
	private MCodeMasterService mCodeMasterService;

	/**
	 * 初期表示
	 *
	 * @param dto
	 * @return
	 */
	@Transactional(rollbackFor = Throwable.class)
	public CommonIO initData(Integer id, LocalDateTime visitDate) throws Throwable {
		CommonIO io = new CommonIO();

		// お客様情報取得
		TCustomerDto customerInfo = searchByTCustomerInfo(id);

		// 眼科への通院情報取得
		List<TVisitingHospitalDto> visitingHospitalInfoList = searchByTvisitingHospitalInfo(id, visitDate);

		// 眼科への通院リスト取得
		io.setVisitingHospitalItems(ObjectUtil
				.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.MEDICAL_HISTORY), CodeNameDto.class));
		// 眼の症状リスト取得
		io.setEyeSymptomsItems(ObjectUtil.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.EYE_SYMPTOMS),
				CodeNameDto.class));
		// 身体の症状リスト取得
		io.setBodySymptomsItems(ObjectUtil.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.BODY_SYMPTOMS),
				CodeNameDto.class));
		// メガネトラブルリスト取得
		io.setGlassesIssuesItems(ObjectUtil
				.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.GLASSES_ISSUES), CodeNameDto.class));
		// フレームトラブルリスト取得
		io.setFrameIssuesItems(ObjectUtil.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.FRAME_ISSUES),
				CodeNameDto.class));
		// 眩しさを感じる物事リスト取得
		io.setGlareSourcesItems(ObjectUtil.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.GLARE_SOURCES),
				CodeNameDto.class));
		// メガネの装用現状リスト取得
		io.setUseGlassesCurrentItems(ObjectUtil
				.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.USE_GLASSES_CURRENT), CodeNameDto.class));
		// メガネの装用CL併用リスト取得
		io.setUseGlassesWithClItems(ObjectUtil
				.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.USE_GLASSES_WITH_CL), CodeNameDto.class));
		// メガネの装用用途リスト取得
		io.setUseGlassesPurposeItems(ObjectUtil
				.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.USE_GLASSES_PURPOSE), CodeNameDto.class));
		// ピッチリスト（輻輳 開散 水平斜位量 上下寄せ 上下斜位量 P）取得
		io.setPitchRangeRyePItems(ObjectUtil
				.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.PITCH_RANGE_EYE_P), CodeNameDto.class));
		// ピッチリスト（NPC アイポイント）取得
		io.setPitchRangeNpcEyepointItems(ObjectUtil.copyList(
				mCodeMasterService.getMCode(SenridoConstant.DivCode.PITCH_RANGE_NPC_EYEPOINT), CodeNameDto.class));
		// ピッチリスト（V CV）取得
		io.setPitchRangeVCvItems(ObjectUtil
				.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.PITCH_RANGE_V_CV), CodeNameDto.class));
		// ピッチリスト（S C ADD）取得
		io.setPitchRangeSCAddItems(ObjectUtil
				.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.PITCH_RANGE_S_C_ADD), CodeNameDto.class));
		// ピッチリスト（AX）取得
		io.setPitchRangeAxItems(ObjectUtil.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.PITCH_RANGE_AX),
				CodeNameDto.class));
		// ピッチリスト（BASE）取得
		io.setPitchRangeBaseItems(ObjectUtil
				.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.PITCH_RANGE_BASE), CodeNameDto.class));
		// ピッチリスト（PD）取得
		io.setPitchRangePdItems(ObjectUtil.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.PITCH_RANGE_PD),
				CodeNameDto.class));
		// オプションリスト取得
		io.setOptionItems(ObjectUtil
				.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.OPTION), CodeNameDto.class));
		// 決済方法リスト取得
		io.setDepositKindCdItems(ObjectUtil
				.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.DEPOSIT_KIND_CD), CodeNameDto.class));
		// 完成連絡方法リスト取得
		io.setCompletionContactItems(ObjectUtil
				.copyList(mCodeMasterService.getMCode(SenridoConstant.DivCode.COMPLETION_CONTACT), CodeNameDto.class));

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
	public List<TVisitingHospitalDto> searchByTvisitingHospitalInfo(Integer id, LocalDateTime visitDate)
			throws Throwable {
		List<TVisitingHospitalDto> visitingHospitalInfoList = new ArrayList<>();

		// 検索条件に該当するxxx情報を取得
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
		List<TVisitingHospital> tVisitingHospitalResult = tVisitingHospitalDao.selectById(dto.getId(),
				dto.getVisitDate());

		// 名称検索
		List<String> medicalHistoryListFromDto = Arrays.asList(dto.getMedicalHistory().split(","));
		List<String> nameList = mCodeDao.selectByCode((SenridoConstant.DivCode.MEDICAL_HISTORY),
				medicalHistoryListFromDto);

		// 取得結果がnullの場合、登録
		if (ObjectUtils.isEmpty(tVisitingHospitalResult)) {

			// 登録情報を設定
			BeanUtils.copyProperties(dto, tVisitingHospital);

			tVisitingHospital.setId(2);
			tVisitingHospital.setVisitDate(localTimeNow);
			if (!ObjectUtils.isEmpty(nameList)) {
				String medicalHistoryName = String.join(",", nameList);
				tVisitingHospital.setMedicalHistoryName(medicalHistoryName);
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

			tVisitingHospital.setId(2);
			tVisitingHospital.setUpdateDate(localTimeNow);
			tVisitingHospital.setUpdateId(userDto.getUserCd());

			tVisitingHospitalDao.update(tVisitingHospital);

			// 成功処理
			resultCd = SenridoConstant.SUCCESS;
		}

		return resultCd;
	}

	/**
	 * 連番設定
	 *
	 * @param dto
	 * @return
	 */
	/*
	 * @Transactional(rollbackFor = Throwable.class) public Integer addSeq(Integer
	 * id, LocalDateTime visitDate, String tName) throws Throwable { Integer maxseq
	 * = null;
	 * 
	 * // tNameの連番最大値を取得 maxseq =
	 * commonDao.selectInfoByIdAndVisitDate(id,visitDate,tName); maxseq ++;
	 * 
	 * return maxseq; }
	 */

}
