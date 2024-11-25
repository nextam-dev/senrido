/**
 * 
 */
package jp.co.senrido.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Data;

/**
 * @author takam
 *
 */
@Entity(listener = TSurveyListener.class)
@Table(name = "t_survey")
@Data
public class TSurvey {

	/** お客様ID */
	@Id
	@Column(name = "id")
	Integer id;

	/** 来店日 */
	@Id
	@Column(name = "visit_date")
	LocalDateTime visitDate;

	/** 初回フラグ */
	@Column(name = "first_time_flag")
	Boolean firstTimeFlag;

	/** お名前 */
	@Column(name = "name")
	String name;

	/** お名前カナ */
	@Column(name = "name_kana")
	String nameKana;

	/** 性別 */
	@Column(name = "sex")
	String sex;

	/** 性別その他 */
	@Column(name = "sex_other")
	String sexOther;

	/** 生年月日 */
	@Column(name = "birthday")
	LocalDateTime birthday;

	/** メールアドレス */
	@Column(name = "mail")
	String mail;

	/** 郵便番号 */
	@Column(name = "zipcode")
	String zipcode;

	/** 住所 */
	@Column(name = "address")
	String address;

	/** 電話番号 */
	@Column(name = "telephone")
	String telephone;

	/** 紹介者 */
	@Column(name = "referrer")
	String referrer;

	/** 職業・職種 */
	@Column(name = "occupation_type")
	String occupationType;

	/** お仕事の内容 */
	@Column(name = "job_description")
	String jobDescription;

	/** 使用状況 */
	@Column(name = "usage_status")
	String usageStatus;

	/** 使用状況その他 */
	@Column(name = "usage_status_other")
	String usageStatusOther;

	/** 使用状況名称 */
	@Column(name = "usage_status_name")
	String usageStatusName;

	/** 使用開始年齢 */
	@Column(name = "usage_start_age")
	String usageStartAge;

	/** パソコン種類 */
	@Column(name = "computer_type")
	String computerType;

	/** パソコン種類その他 */
	@Column(name = "computer_type_other")
	String computerTypeOther;

	/** パソコン種類名称 */
	@Column(name = "computer_type_name")
	String computerTypeName;

	/** パソコン使用時間 */
	@Column(name = "computer_usage_time")
	String computerUsageTime;

	/** パソコン使用時間その他 */
	@Column(name = "computer_usage_time_other")
	String computerUsageTimeOther;

	/** パソコン使用時間名称 */
	@Column(name = "computer_usage_time_name")
	String computerUsageTimeName;

	/** 距離 */
	@Column(name = "distance")
	String distance;

	/** スマートフォン使用時間 */
	@Column(name = "smartphone_usage_time")
	String smartphoneUsageTime;

	/** スマートフォン使用時間その他 */
	@Column(name = "smartphone_usage_time_other")
	String smartphoneUsageTimeOther;

	/** スマートフォン使用時間名称 */
	@Column(name = "smartphone_usage_time_name")
	String smartphoneUsageTimeName;

	/** スマートフォン見るもの */
	@Column(name = "smartphone_content")
	String smartphoneContent;

	/** スマートフォン見るものその他 */
	@Column(name = "smartphone_content_other")
	String smartphoneContentOther;

	/** スマートフォン見るもの名称 */
	@Column(name = "smartphone_content_name")
	String smartphoneContentName;

	/** 読書 */
	@Column(name = "reading")
	String reading;

	/** 読書その他 */
	@Column(name = "reading_other")
	String readingOther;

	/** 読書名称 */
	@Column(name = "reading_name")
	String readingName;

	/** ゲーム */
	@Column(name = "gaming")
	String gaming;

	/** ゲームその他 */
	@Column(name = "gaming_other")
	String gamingOther;

	/** ゲーム名称 */
	@Column(name = "gaming_name")
	String gamingName;

	/** ゲーム時間 */
	@Column(name = "gaming_time")
	String gamingTime;

	/** ゲーム時間その他 */
	@Column(name = "gaming_time_other")
	String gamingTimeOther;

	/** ゲーム時間名称 */
	@Column(name = "gaming_time_name")
	String gamingTimeName;

	/** 運転 */
	@Column(name = "driving")
	String driving;

	/** 運転その他 */
	@Column(name = "driving_other")
	String drivingOther;

	/** 運転目名称 */
	@Column(name = "driving_eye_name")
	String drivingEyeName;

	/** 免許種類 */
	@Column(name = "license_type")
	String licenseType;

	/** 免許種類その他 */
	@Column(name = "license_type_other")
	String licenseTypeOther;

	/** 免許種類名称 */
	@Column(name = "license_type_name")
	String licenseTypeName;

	/** 眼科受診 */
	@Column(name = "ophthalmology_visit")
	String ophthalmologyVisit;

	/** 眼科受診その他 */
	@Column(name = "ophthalmology_visit_other")
	String ophthalmologyVisitOther;

	/** 眼科受診名称 */
	@Column(name = "ophthalmology_visit_name")
	String ophthalmologyVisitName;

	/** 眼の疲れ */
	@Column(name = "eye_fatigue")
	String eyeFatigue;

	/** 眼の疲れ名称 */
	@Column(name = "eye_fatigue_name")
	String eyeFatigueName;

	/** 疲れを感じるとき */
	@Column(name = "fatigue_timing")
	String fatigueTiming;

	/** 目の症状 */
	@Column(name = "eye_symptoms")
	String eyeSymptoms;

	/** 目の症状その他 */
	@Column(name = "eye_symptoms_other")
	String eyeSymptomsOther;

	/** 目の症状名称 */
	@Column(name = "eye_symptoms_name")
	String eyeSymptomsName;

	/** 身体の症状 */
	@Column(name = "body_symptoms")
	String bodySymptoms;

	/** 身体の症状その他 */
	@Column(name = "body_symptoms_other")
	String bodySymptomsOther;

	/** 身体の症状名称 */
	@Column(name = "body_symptoms_name")
	String bodySymptomsName;

	/** 手術 */
	@Column(name = "surgery")
	String surgery;

	/** 手術その他 */
	@Column(name = "surgery_other")
	String surgeryOther;

	/** 手術名称 */
	@Column(name = "surgery_name")
	String surgeryName;

	/** 趣味 */
	@Column(name = "hobbies")
	String hobbies;

	/** コロナ開示 */
	@Column(name = "covid_disclosure")
	String covidDisclosure;

	/** コロナ開示その他 */
	@Column(name = "covid_disclosure_other")
	String covidDisclosureOther;

	/** 備考 */
	@Column(name = "remarks")
	String remarks;

	/** 作成メガネ使用状況 */
	@Column(name = "created_glasses_usage")
	String createdGlassesUsage;

	/** 作成メガネ使用状況その他 */
	@Column(name = "created_glasses_usage_other")
	String createdGlassesUsageOther;

	/** 作成メガネ使用状況名称 */
	@Column(name = "created_glasses_usage_name")
	String createdGlassesUsageName;

	/** 変化 */
	@Column(name = "changes")
	String changes;

	/** 変化名称 */
	@Column(name = "changes_name")
	String changesName;

	/** メガネ気になること */
	@Column(name = "glasses_concerns")
	String glassesConcerns;

	/** メガネ気になることその他 */
	@Column(name = "glasses_concerns_other")
	String glassesConcernsOther;

	/** メガネ気になること名称 */
	@Column(name = "glasses_concerns_name")
	String glassesConcernsName;

	/** 環境変化 */
	@Column(name = "environmental_changes")
	String environmentalChanges;

	/** 目の疲れ2回目 */
	@Column(name = "eye_fatigue_second")
	String eyeFatigueSecond;

	/** 目の疲れ2回目名称 */
	@Column(name = "eye_fatigue_second_name")
	String eyeFatigueSecondName;

	/** 度数 */
	@Column(name = "prescription_strength")
	String prescriptionStrength;

	/** 度数その他 */
	@Column(name = "prescription_strength_other")
	String prescriptionStrengthOther;

	/** 度数名称 */
	@Column(name = "prescription_strength_name")
	String prescriptionStrengthName;

	/** 削除フラグ */
	@Column(name = "del_flg")
	Boolean delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	LocalDateTime createDate;

	/** 登録者コード */
	@Column(name = "create_id")
	String createId;

	/** 更新日時 */
	@Column(name = "update_date")
	LocalDateTime updateDate;

	/** 更新者コード */
	@Column(name = "update_id")
	String updateId;
}
