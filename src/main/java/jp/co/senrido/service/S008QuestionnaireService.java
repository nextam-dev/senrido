/**
 * 
 */
package jp.co.senrido.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import jp.co.senrido.common.SenridoConstant;
import jp.co.senrido.dao.TCustomerDao;
import jp.co.senrido.dao.TSurveyDao;
import jp.co.senrido.dto.TSurveyDto;
import jp.co.senrido.entity.TCustomer;
import jp.co.senrido.entity.TSurvey;
import jp.co.senrido.helper.SendMailHelper;
import jp.co.senrido.utils.DateUtil;
import jp.co.senrido.utils.ObjectUtil;

/**
 * @author takam
 *
 */
@Service
public class S008QuestionnaireService extends BaseTransactionalService {
	
	@Autowired
	private SendMailHelper mailHelper;
	
	@Autowired
	private TCustomerDao tCustomerDao;
	
	@Autowired
	private TSurveyDao tSurveyDao;
	
	/**
	 * アンケート検索処理.
	 * 
	 * @param id
	 * @param visitDate
	 * @return
	 * @throws Throwable
	 */
	public TSurveyDto serachSurvey(String id, String visitDate ) throws Throwable {
		
		TSurveyDto dto = new TSurveyDto();
		
		// 検索処理
		TSurvey entity = tSurveyDao.selectById(dto.getId(), DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		
		// カンマ区切りをリストに変換
		dto.setUsageStatus(changeCanmaToList(entity.getUsageStatus(), SenridoConstant.HALF_CAMMA));
		dto.setComputerType(changeCanmaToList(entity.getComputerType(), SenridoConstant.HALF_CAMMA));
		dto.setSmartphoneContent(changeCanmaToList(entity.getSmartphoneContent(), SenridoConstant.HALF_CAMMA));
		dto.setGaming(changeCanmaToList(entity.getGaming(), SenridoConstant.HALF_CAMMA));
		dto.setLicenseType(changeCanmaToList(entity.getLicenseType(), SenridoConstant.HALF_CAMMA));
		dto.setOphthalmologyVisit(changeCanmaToList(entity.getOphthalmologyVisit(), SenridoConstant.HALF_CAMMA));
		dto.setEyeSymptoms(changeCanmaToList(entity.getEyeSymptoms(), SenridoConstant.HALF_CAMMA));
		dto.setBodySymptoms(changeCanmaToList(entity.getBodySymptoms(), SenridoConstant.HALF_CAMMA));
		dto.setSurgery(changeCanmaToList(entity.getSurgery(), SenridoConstant.HALF_CAMMA));
		// 2回目以降分
		dto.setChanges(changeCanmaToList(entity.getChanges(), SenridoConstant.HALF_CAMMA));
		dto.setGlassesConcerns(changeCanmaToList(entity.getGlassesConcerns(), SenridoConstant.HALF_CAMMA));
		dto.setPrescriptionStrength(changeCanmaToList(entity.getPrescriptionStrength(), SenridoConstant.HALF_CAMMA));
		
		return dto;
	}
	
    /**
     * アンケート登録処理.
     * 
     * @param fromAddress
     * @throws Throwable
     */
	public void insertSurvey(TSurveyDto dto) throws Throwable {
		
		TCustomer tCustomer = new TCustomer();
		// お客様IDが設定されている場合、お客様情報を取得
		if (!ObjectUtils.isEmpty(dto.getId())) {
			tCustomer = tCustomerDao.selectById(dto.getId());
			if (tCustomer == null) {
				dto.setId(null);
				tCustomer = new TCustomer();
			}
		}
		
		// お客様IDが設定されていない場合、お客様情報に基本情報を登録
		if (ObjectUtils.isEmpty(dto.getId())) {
			// コピー
			BeanUtils.copyProperties(dto, tCustomer);
			// 日付項目は個別に設定
			tCustomer.setBirthday(DateUtil.changeFormatStrToLocalDateTime(dto.getBirthday(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
			
			tCustomer.setDelFlg(false);
			tCustomer.setUpdateDate(this.createCurrentDate());
			tCustomer.setUpdateId("system");
			tCustomer.setCreateDate(this.createCurrentDate());
			tCustomer.setCreateId("system");
			tCustomerDao.insert(tCustomer);
			
			// 登録したお客様IDを設定
			dto.setId(tCustomer.getId());
		}
		
		// アンケート情報を登録
		TSurvey entity = tSurveyDao.selectById(dto.getId(), DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		boolean isInsert = false;
		if (entity == null) {
			entity = new TSurvey();
			isInsert = true;
		}
		
		BeanUtils.copyProperties(dto, entity);
		// 日付項目は個別に設定
		entity.setVisitDate(DateUtil.changeFormatStrToLocalDateTime(dto.getVisitDate(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		entity.setBirthday(DateUtil.changeFormatStrToLocalDateTime(dto.getBirthday(), DateUtil.DATE_FORMAT_YMD_HYPHEN));
		
		// 選択肢を名称に変換
		entity.setUsageStatusName(changeCodeToName("usage_status", dto.getUsageStatus()));
		entity.setComputerTypeName(changeCodeToName("computer_type", dto.getComputerType()));
		entity.setComputerUsageTimeName(changeCodeToName("computer_usage_time", dto.getComputerUsageTime()));
		entity.setSmartphoneUsageTimeName(changeCodeToName("smartphone_usage_time", dto.getSmartphoneUsageTime()));
		entity.setSmartphoneContentName(changeCodeToName("smartphone_content", dto.getSmartphoneContent()));
		entity.setReadingName(changeCodeToName("reading", dto.getReading()));
		entity.setGamingName(changeCodeToName("gaming_name", dto.getGaming()));
		entity.setGamingTimeName(changeCodeToName("gaming_time", dto.getGamingTime()));
		entity.setDrivingEyeName(changeCodeToName("driving", dto.getDriving()));
		entity.setLicenseTypeName(changeCodeToName("license_type", dto.getLicenseType()));
		entity.setOphthalmologyVisitName(changeCodeToName("ophthalmology_visit", dto.getOphthalmologyVisit()));
		entity.setEyeFatigueName(changeCodeToName("eye_fatigue", dto.getEyeFatigue()));
		entity.setEyeSymptomsName(changeCodeToName("eye_symptoms", dto.getEyeSymptoms()));
		entity.setBodySymptomsName(changeCodeToName("body_symptoms", dto.getBodySymptoms()));
		entity.setSurgeryName(changeCodeToName("surgery", dto.getSurgery()));
		// 2回目以降分
		entity.setCreatedGlassesUsageName(changeCodeToName("created_glasses_usage", dto.getCreatedGlassesUsage()));
		entity.setChangesName(changeCodeToName("changes", dto.getChanges()));
		entity.setGlassesConcernsName(changeCodeToName("glasses_concerns", dto.getGlassesConcerns()));
		entity.setEyeFatigueSecondName(changeCodeToName("eye_fatigue_second", dto.getEyeFatigueSecond()));
		entity.setPrescriptionStrengthName(changeCodeToName("prescription_strength", dto.getPrescriptionStrength()));
		
		// Listをカンマ区切りに変更
		String delimita = SenridoConstant.HALF_CAMMA;
		entity.setUsageStatus(String.join(delimita, dto.getUsageStatus()));
		entity.setComputerType(String.join(delimita, dto.getComputerType()));
		entity.setSmartphoneContent(String.join(delimita, dto.getSmartphoneContent()));
		entity.setGaming(String.join(delimita, dto.getGaming()));
		entity.setLicenseType(String.join(delimita, dto.getLicenseType()));
		entity.setOphthalmologyVisit(String.join(delimita, dto.getOphthalmologyVisit()));
		entity.setEyeSymptoms(String.join(delimita, dto.getEyeSymptoms()));
		entity.setBodySymptoms(String.join(delimita, dto.getBodySymptoms()));
		entity.setSurgery(String.join(delimita, dto.getSurgery()));
		// 2回目以降分
		entity.setChanges(String.join(delimita, dto.getChanges()));
		entity.setGlassesConcerns(String.join(delimita, dto.getGlassesConcerns()));
		entity.setPrescriptionStrength(String.join(delimita, dto.getPrescriptionStrength()));
		
		entity.setDelFlg(false);
		entity.setUpdateDate(this.createCurrentDate());
		entity.setUpdateId("system");
		if (isInsert) {
			entity.setCreateDate(this.createCurrentDate());
			entity.setCreateId("system");
			tSurveyDao.insert(entity);
		} else {
			tSurveyDao.update(entity);
		}
		
		// TODO アンケート結果を頭書き情報へ登録
		
		// TODO アンケート登録後のメール送信（千里堂様の管理者宛にメールを出す）
		
	}
}
