/**
 * 
 */
package jp.co.senrido.dto;

import java.util.List;

import javax.validation.constraints.Pattern;

import jp.co.senrido.annotation.MessageName;
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
	@MessageName("お名前")
	private String name;

	/** お客様名カナ */
	@MessageName("お名前（カタカナ）")
	private String nameKana;

	/** 生年月日 */
	@MessageName("生年月日")
	private String birthday;
	
	/** メールアドレス */
	@MessageName("メールアドレス")
	private String mail;

	/** 性別 */
	@MessageName("性別")
	private String sex;

	/** 性別その他 */
	@MessageName("性別（その他）")
	private String sexOther;

	/** 性別名称 */
	private String sexName;

	/** 郵便番号 */
	@MessageName("郵便番号")
	@Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
	private String zipcode;

	/** 住所 */
	@MessageName("住所")
	private String address;

	/** 電話番号 */
	@MessageName("電話番号")
	private String telephone;

	/** 紹介者 */
	@MessageName("紹介者")
	private String referrer;
	
	/** 職業・職種 */
	@MessageName("職業または職種")
	private String occupationType;

	/** お仕事の内容 */
	@MessageName("お仕事の内容")
	private String jobDescription;

	/** 使用状況 */
	@MessageName("現在、メガネやコンタクトの使用状況をお聞かせください")
	private List<String> usageStatus;

	/** 使用状況その他 */
	@MessageName("現在、メガネやコンタクトの使用状況をお聞かせください（その他）")
	private String usageStatusOther;

	/** 使用状況名称 */
	private String usageStatusName;

	/** 使用開始年齢 */
	@MessageName("はじめてメガネまたはコンタクトを使用したのは何歳ですか？")
	private String usageStartAge;

	/** パソコン種類 */
	@MessageName("パソコンは何を使用していますか？")
	private List<String> computerType;

	/** パソコン種類その他 */
	@MessageName("パソコンは何を使用していますか？（その他）")
	private String computerTypeOther;

	/** パソコン種類名称 */
	private String computerTypeName;

	/** パソコン使用時間 */
	@MessageName("パソコンは１日に何時間使用しますか？")
	private String computerUsageTime;

	/** パソコン使用時間その他 */
	@MessageName("パソコンは１日に何時間使用しますか？（その他）")
	private String computerUsageTimeOther;

	/** パソコン使用時間名称 */
	private String computerUsageTimeName;

	/** 距離 */
	@MessageName("パソコン画面と眼の距離は何ｃｍ離れていますか？")
	private String distance;

	/** スマートフォン使用時間 */
	@MessageName("スマートフォンまたは携帯電話は１日に何時間使用しますか？")
	private String smartphoneUsageTime;

	/** スマートフォン使用時間その他 */
	@MessageName("スマートフォンまたは携帯電話は１日に何時間使用しますか？（その他）")
	private String smartphoneUsageTimeOther;

	/** スマートフォン使用時間名称 */
	private String smartphoneUsageTimeName;

	/** スマートフォン見るもの */
	@MessageName("スマートフォンでは何をよく見ますか？")
	private List<String> smartphoneContent;

	/** スマートフォン見るものその他 */
	@MessageName("スマートフォンでは何をよく見ますか？（その他）")
	private String smartphoneContentOther;

	/** スマートフォン見るもの名称 */
	private String smartphoneContentName;

	/** 読書 */
	@MessageName("読書はしますか？")
	private String reading;

	/** 読書その他 */
	@MessageName("読書はしますか？（その他）")
	private String readingOther;

	/** 読書名称 */
	private String readingName;

	/** ゲーム */
	@MessageName("ゲームはしますか？")
	private List<String> gaming;

	/** ゲームその他 */
	@MessageName("ゲームはしますか？（その他）")
	private String gamingOther;

	/** ゲーム名称 */
	private String gamingName;

	/** ゲーム時間 */
	@MessageName("ゲームは１日に何時間使用しますか？")
	private String gamingTime;

	/** ゲーム時間その他 */
	@MessageName("ゲームは１日に何時間使用しますか？（その他）")
	private String gamingTimeOther;

	/** ゲーム時間名称 */
	private String gamingTimeName;

	/** 運転 */
	@MessageName("自動車の運転はしますか？")
	private String driving;

	/** 運転その他 */
	@MessageName("自動車の運転はしますか？（その他）")
	private String drivingOther;

	/** 運転名称 */
	private String drivingName;

	/** 免許種類 */
	@MessageName("運転免許の種類を教えてください。")
	private List<String> licenseType;

	/** 免許種類その他 */
	@MessageName("運転免許の種類を教えてください。（その他）")
	private String licenseTypeOther;

	/** 免許種類名称 */
	private String licenseTypeName;

	/** 眼科受診 */
	@MessageName("眼科さんへ受診はしていますか？")
	private List<String> ophthalmologyVisit;

	/** 眼科受診その他 */
	@MessageName("眼科さんへ受診はしていますか？（その他）")
	private String ophthalmologyVisitOther;

	/** 眼科受診名称 */
	private String ophthalmologyVisitName;

	/** 眼の疲れ */
	@MessageName("目の疲れは感じていますか？")
	private String eyeFatigue;

	/** 眼の疲れ名称 */
	private String eyeFatigueName;

	/** 疲れを感じるとき */
	@MessageName("どのような時に疲れを感じますか？")
	private String fatigueTiming;

	/** 目の症状 */
	@MessageName("現在、目に下記のような症状はありますか？")
	private List<String> eyeSymptoms;

	/** 目の症状その他 */
	@MessageName("現在、目に下記のような症状はありますか？（その他）")
	private String eyeSymptomsOther;

	/** 目の症状名称 */
	private String eyeSymptomsName;

	/** 身体の症状 */
	@MessageName("お身体に下記のような症状・疾患はありますか？")
	private List<String> bodySymptoms;

	/** 身体の症状その他 */
	@MessageName("お身体に下記のような症状・疾患はありますか？（その他）")
	private String bodySymptomsOther;

	/** 身体の症状名称 */
	private String bodySymptomsName;

	/** 手術 */
	@MessageName("眼の手術は受けたことありますか？")
	private List<String> surgery;

	/** 手術その他 */
	@MessageName("眼の手術は受けたことありますか？（その他）")
	private String surgeryOther;

	/** 手術名称 */
	private String surgeryName;

	/** 趣味 */
	@MessageName("趣味はなんですか？")
	private String hobbies;

	/** コロナ開示 */
	@MessageName("必ずご確認ください。")
	private String covidDisclosure;

	/** コロナ開示その他 */
	@MessageName("必ずご確認ください。（その他）")
	private String covidDisclosureOther;
	
	/** コロナ開示 名称*/
	private String covidDisclosureName;

	/** 備考 */
	@MessageName("気になることや確認したいこと、補足等、ありましたらこちらにご記入ください。")
	private String remarks;
	
	/** 作成メガネ使用状況 */
	@MessageName("作製したメガネの一日当たりの使用状況はどのくらいですか？")
	private String createdGlassesUsage;
	
	/** 作成メガネ使用状況その他 */
	@MessageName("作製したメガネの一日当たりの使用状況はどのくらいですか？（その他）")
	private String createdGlassesUsageOther;
	
	/** 作成メガネ使用状況名称 */
	private String createdGlassesUsageName;
	
	/** 変化 */
	@MessageName("メガネを掛けて変化は感じますか？")
	private List<String> changes;
	
	/** 変化名称 */
	private String changesName;
	
	/** メガネ気になること */
	@MessageName("メガネを掛けていてきになることはありますか？")
	private List<String> glassesConcerns;
	
	/** メガネ気になることその他 */
	@MessageName("メガネを掛けていてきになることはありますか？（その他）")
	private String glassesConcernsOther;
	
	/** メガネ気になること名称 */
	private String glassesConcernsName;
	
	/** 環境変化 */
	@MessageName("お仕事の内容や環境に変化はありましたか？")
	private String environmentalChanges;
	
	/** 目の疲れ2回目 */
	@MessageName("現在、目の疲れは感じていますか？")
	private String eyeFatigueSecond;
	
	/** 目の疲れ名称 */
	private String eyeFatigueSecondName;
	
	/** 度数 */
	@MessageName("前回の測定からコンタクトの度数は変わりましたか？")
	private String prescriptionStrength;
	
	/** 度数その他 */
	@MessageName("前回の測定からコンタクトの度数は変わりましたか？（その他）")
	private String prescriptionStrengthOther;
	
	/** 度数名称 */
	private String prescriptionStrengthName;
}
