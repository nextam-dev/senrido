/**
 * 
 */
package jp.co.senrido.dto;

import java.util.List;

import org.seasar.doma.Column;

import lombok.Getter;
import lombok.Setter;

/**
 * アンケート用
 * @author takam
 *
 */
@Getter
@Setter
public class TSurveyDto {

	/** お客様ID */
	private Integer id;

    /** 来店日 */
	private String visitDate;
	
    /** 初回フラグ */
	private String firstTimeFlag;

	/** お客様名 */
	private String name;

	/** お客様名カナ */
	private String nameKana;

	/** 生年月日 */
	private String birthday;
	
	/** メールアドレス */
	private String mail;

	/** 性別 */
	private String sex;

	/** 性別その他 */
	private String sexOther;

	/** 性別名称 */
	private String sexName;

	/** 郵便番号 */
	private String zipcode;

	/** 住所 */
	private String address;

	/** 電話番号 */
	private String telephone;

	/** 紹介者 */
	private String referrer;
	
	/** 職業・職種 */
	private String occupationType;

	/** お仕事の内容 */
	private String jobDescription;

	/** 使用状況 */
	private List<String> usageStatus;

	/** 使用状況その他 */
	private String usageStatusOther;

	/** 使用状況名称 */
	private String usageStatusName;

	/** 使用開始年齢 */
	private String usageStartAge;

	/** パソコン種類 */
	private List<String> computerType;

	/** パソコン種類その他 */
	private String computerTypeOther;

	/** パソコン種類名称 */
	private String computerTypeName;

	/** パソコン使用時間 */
	private String computerUsageTime;

	/** パソコン使用時間その他 */
	private String computerUsageTimeOther;

	/** パソコン使用時間名称 */
	private String computerUsageTimeName;

	/** 距離 */
	private String distance;

	/** スマートフォン使用時間 */
	private String smartphoneUsageTime;

	/** スマートフォン使用時間その他 */
	private String smartphoneUsageTimeOther;

	/** スマートフォン使用時間名称 */
	private String smartphoneUsageTimeName;

	/** スマートフォン見るもの */
	private List<String> smartphoneContent;

	/** スマートフォン見るものその他 */
	private String smartphoneContentOther;

	/** スマートフォン見るもの名称 */
	private String smartphoneContentName;

	/** 読書 */
	private String reading;

	/** 読書その他 */
	private String readingOther;

	/** 読書名称 */
	private String readingName;

	/** ゲーム */
	private List<String> gaming;

	/** ゲームその他 */
	private String gamingOther;

	/** ゲーム名称 */
	private String gamingName;

	/** ゲーム時間 */
	private String gamingTime;

	/** ゲーム時間その他 */
	private String gamingTimeOther;

	/** ゲーム時間名称 */
	private String gamingTimeName;

	/** 運転 */
	private String driving;

	/** 運転その他 */
	private String drivingOther;

	/** 運転名称 */
	private String drivingName;

	/** 免許種類 */
	private List<String> licenseType;

	/** 免許種類その他 */
	private String licenseTypeOther;

	/** 免許種類名称 */
	private String licenseTypeName;

	/** 眼科受診 */
	private List<String> ophthalmologyVisit;

	/** 眼科受診その他 */
	private String ophthalmologyVisitOther;

	/** 眼科受診名称 */
	private String ophthalmologyVisitName;

	/** 眼の疲れ */
	private String eyeFatigue;

	/** 眼の疲れ名称 */
	private String eyeFatigueName;

	/** 疲れを感じるとき */
	private String fatigueTiming;

	/** 目の症状 */
	private List<String> eyeSymptoms;

	/** 目の症状その他 */
	private String eyeSymptomsOther;

	/** 目の症状名称 */
	private String eyeSymptomsName;

	/** 身体の症状 */
	private List<String> bodySymptoms;

	/** 身体の症状その他 */
	private String bodySymptomsOther;

	/** 身体の症状名称 */
	private String bodySymptomsName;

	/** 手術 */
	private List<String> surgery;

	/** 手術その他 */
	private String surgeryOther;

	/** 手術名称 */
	private String surgeryName;

	/** 趣味 */
	private String hobbies;

	/** コロナ開示 */
	private String covidDisclosure;

	/** コロナ開示その他 */
	private String covidDisclosureOther;
	
	/** コロナ開示 名称*/
	private String covidDisclosureName;

	/** 備考 */
	private String remarks;
	
	/** 作成メガネ使用状況 */
	private String createdGlassesUsage;
	
	/** 作成メガネ使用状況その他 */
	private String createdGlassesUsageOther;
	
	/** 作成メガネ使用状況名称 */
	private String createdGlassesUsageName;
	
	/** 変化 */
	private List<String> changes;
	
	/** 変化名称 */
	private String changesName;
	
	/** メガネ気になること */
	private List<String> glassesConcerns;
	
	/** メガネ気になることその他 */
	private String glassesConcernsOther;
	
	/** メガネ気になること名称 */
	private String glassesConcernsName;
	
	/** 環境変化 */
	private String environmentalChanges;
	
	/** 目の疲れ2回目 */
	private String eyeFatigueSecond;
	
	/** 目の疲れ名称 */
	private String eyeFatigueSecondName;
	
	/** 度数 */
	private String prescriptionStrength;
	
	/** 度数その他 */
	private String prescriptionStrengthOther;
	
	/** 度数名称 */
	private String prescriptionStrengthName;
}
