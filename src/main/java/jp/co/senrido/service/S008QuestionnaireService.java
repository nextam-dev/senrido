/**
 * 
 */
package jp.co.senrido.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
		entity.setUsageStatusName(chaceCodeToName("usage_status", dto.getUsageStatus()));
		entity.setComputerTypeName(chaceCodeToName("computer_type", dto.getComputerType()));
		entity.setComputerUsageTimeName(chaceCodeToName("computer_usage_time", dto.getComputerUsageTime()));
		entity.setSmartphoneUsageTimeName(chaceCodeToName("smartphone_usage_time", dto.getSmartphoneUsageTime()));
		entity.setSmartphoneContentName(chaceCodeToName("smartphone_content", dto.getSmartphoneContent()));
		entity.setReadingName(chaceCodeToName("reading", dto.getReading()));
		entity.setGamingName(chaceCodeToName("gaming_name", dto.getGaming()));
		entity.setGamingTimeName(chaceCodeToName("gaming_time", dto.getGamingTime()));
		entity.setDrivingEyeName(chaceCodeToName("driving", dto.getDriving()));
		entity.setLicenseTypeName(chaceCodeToName("license_type", dto.getLicenseType()));
		entity.setOphthalmologyVisitName(chaceCodeToName("ophthalmology_visit", dto.getOphthalmologyVisit()));
		entity.setEyeFatigueName(chaceCodeToName("eye_fatigue", dto.getEyeFatigue()));
		entity.setEyeSymptomsName(chaceCodeToName("eye_symptoms", dto.getEyeSymptoms()));
		entity.setBodySymptomsName(chaceCodeToName("body_symptoms", dto.getBodySymptoms()));
		entity.setSurgeryName(chaceCodeToName("surgery", dto.getSurgery()));
		
		// Listをカンマ区切りに変更
		entity.setUsageStatus(String.join(",", dto.getUsageStatus()));
		entity.setComputerType(String.join(",", dto.getComputerType()));
		entity.setSmartphoneContent(String.join(",", dto.getSmartphoneContent()));
		entity.setGamingName(String.join(",", dto.getGamingName()));
		entity.setLicenseType(String.join(",", dto.getLicenseType()));
		entity.setOphthalmologyVisit(String.join(",", dto.getOphthalmologyVisit()));
		entity.setEyeSymptoms(String.join(",", dto.getEyeSymptoms()));
		entity.setBodySymptoms(String.join(",", dto.getBodySymptoms()));
		entity.setSurgery(String.join(",", dto.getSurgery()));
		
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
