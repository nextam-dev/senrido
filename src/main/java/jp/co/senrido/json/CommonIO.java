/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：CommonIO.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package jp.co.senrido.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
//import com.makino_saiten.jomu.dto.MCode;
//import com.makino_saiten.jomu.dto.MVehicleDto;
//import com.makino_saiten.jomu.dto.RollCallRecordDetailDto;
//import com.makino_saiten.jomu.dto.RollCallRecordDto;
//import com.makino_saiten.jomu.entity.MEmployee;
//import com.makino_saiten.jomu.entity.MVehicle;

import jp.co.senrido.dto.TCriticalVisibilityNeedsDto;
import jp.co.senrido.dto.TCustomerDto;
import jp.co.senrido.dto.TCustomerSearchDto;
import jp.co.senrido.dto.TDiscomfortFatigueDto;
import jp.co.senrido.dto.TGlareDto;
import jp.co.senrido.dto.TGlassesUsageDto;
import jp.co.senrido.dto.THobbiesClubActivitiesDto;
import jp.co.senrido.dto.TOccupationDto;
import jp.co.senrido.dto.TOngoingDiseasesMedicationDto;
import jp.co.senrido.dto.TPastMedicalHistoryDto;
import jp.co.senrido.dto.TSurgeryDto;
import jp.co.senrido.dto.TSurveyDto;
import jp.co.senrido.dto.TSymptomsDto;
import jp.co.senrido.dto.TTroubleDto;
import jp.co.senrido.dto.TUsageStatusDto;
import jp.co.senrido.dto.TVisionLossDto;
import jp.co.senrido.dto.TVisitingHospitalDto;
import jp.co.senrido.entity.MCode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author t_hirose
 *
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonIO implements Serializable {

	private static final long serialVersionUID = 1L;

	// --------------------------------
	// 和暦西暦変換用
	// --------------------------------
	String Date;
	String code;

	// --------------------------------
	// ページャ用
	// --------------------------------
	// 検索時、最大件数を超えた(超えた:"1"、以外:null or "0")
	String maxCntflg;

	// --------------------------------
	// 契約登録他
	// --------------------------------
	// 1つURLで1つの結果(String)を返す場合情報
	// 検索エラーは、resultCdに設定
	String resultString;
	String resultEra; // 和暦用

	// --------------------------------
	// 共通
	// --------------------------------
	/** 消費税 */
	Integer tax;
	
	/** 性別 */
	List<MCode> sexList = new ArrayList<MCode>();
	/** メガネ使用状況 */
	List<MCode> usageStatusList = new ArrayList<MCode>();
	/** パソコン種類*/
	List<MCode> computerTypeList = new ArrayList<MCode>();
	/** パソコン使用時間 */
	List<MCode> computerUsageTimeList = new ArrayList<MCode>();
	/** スマートフォン使用時間 */
	List<MCode> smartphoneUsageTimeList = new ArrayList<MCode>();
	/** スマートフォン見るもの */
	List<MCode> smartphoneContentList = new ArrayList<MCode>();
	/** 読書 */
	List<MCode> readingList = new ArrayList<MCode>();
	/** ゲーム */
	List<MCode> gamingNameList = new ArrayList<MCode>();
	/** ゲーム時間 */
	List<MCode> gamingTimeList = new ArrayList<MCode>();
	/** 運転 */
	List<MCode> drivingList = new ArrayList<MCode>();
	/** 免許種類 */
	List<MCode> licenseTypeList = new ArrayList<MCode>();
	/** 眼科受診 */
	List<MCode> ophthalmologyVisitList = new ArrayList<MCode>();
	/** 眼の疲れ */
	List<MCode> eyeFatigueList = new ArrayList<MCode>();
	/** 目の症状 */
	List<MCode> eyeSymptomsList = new ArrayList<MCode>();
	/** 身体の症状 */
	List<MCode> bodySymptomsList = new ArrayList<MCode>();
	/** 手術 */
	List<MCode> surgeryList = new ArrayList<MCode>();
	/** コロナ開示 */
	List<MCode> covidDisclosureList = new ArrayList<MCode>();
	/** 作成メガネ使用状況 */
	List<MCode> createdGlassesUsageList = new ArrayList<MCode>();
	/** 変化 */
	List<MCode> changesList = new ArrayList<MCode>();
	/** メガネ気になること */
	List<MCode> glassesConcernsList = new ArrayList<MCode>();
	/** 目の疲れ2回目 */
	List<MCode> eyeFatigueSecondList = new ArrayList<MCode>();
	/** 度数 */
	List<MCode> prescriptionStrengthList = new ArrayList<MCode>();
	
	/** 症状 */
	List<MCode> visitingHospitalItems = new ArrayList<MCode>();
	/** 白内障 */
	List<MCode> surgeryTargetItems = new ArrayList<MCode>();
	/** 眼の症状 */
	List<MCode> eyeSymptomsItems = new ArrayList<MCode>();
	/** 身体の症状 */
	List<MCode> bodySymptomsItems = new ArrayList<MCode>();
	/** メガネトラブル */
	List<MCode> glassesIssuesItems = new ArrayList<MCode>();
	/** フレームトラブル */
	List<MCode> frameIssuesItems = new ArrayList<MCode>();
	/** 眩しさを感じる物事 */
	List<MCode> glareSourcesItems = new ArrayList<MCode>();
	/** メガネの装用現状 */
	List<MCode> useGlassesCurrentItems = new ArrayList<MCode>();
	/** メガネの装用CL併用 */
	List<MCode> useGlassesWithClItems = new ArrayList<MCode>();
	/** メガネの装用用途 */
	List<MCode> useGlassesPurposeItems = new ArrayList<MCode>();
	/** 読書の習慣 */
	List<MCode> readingHabitsItems = new ArrayList<MCode>();
	/** 運転の習慣 */
	List<MCode> drivingHabitsNameItems = new ArrayList<MCode>();
	/** 度数用途*/
	List<MCode> prescriptionStrengthNameItems = new ArrayList<MCode>();
	/** ピッチリスト（輻輳　開散　水平斜位量　上下寄せ　上下斜位量　P）*/
	List<MCode> pitchRangeRyePItems = new ArrayList<MCode>();
	/** ピッチリスト（NPC アイポイント） */
	List<MCode> pitchRangeNpcEyepointItems = new ArrayList<MCode>();
	/** ピッチリスト（V CV） */
	List<MCode> pitchRangeVCvItems = new ArrayList<MCode>();
	/** ピッチリスト（S C ADD） */
	List<MCode> pitchRangeSCAddItems = new ArrayList<MCode>();
	/** ピッチリスト（AX） */
	List<MCode> pitchRangeAxItems = new ArrayList<MCode>();
	/** ピッチリスト（BASE） */
	List<MCode> pitchRangeBaseItems = new ArrayList<MCode>();
	/** ピッチリスト（PD） */
	List<MCode> pitchRangePdItems = new ArrayList<MCode>();
	/** オプションリスト */
	List<MCode> optionItems = new ArrayList<MCode>();
	/** 決済方法リスト */
	List<MCode> depositKindCdItems = new ArrayList<MCode>();
	/** 完成連絡方法リスト */
	List<MCode> completionContactItems = new ArrayList<MCode>();
	/** 運転間隔リスト */
	List<MCode> drivingItems = new ArrayList<MCode>();
	/** 担当者 */
	List<MCode> personInChargeList = new ArrayList<MCode>();
	/** 店舗 */
	List<MCode> shopNameList = new ArrayList<MCode>();
	// --------------------------------
	// s005
	// --------------------------------
	/** 検索条件情報 */
	List<TCustomerSearchDto> tCustomer = new ArrayList<TCustomerSearchDto>();
	
	// --------------------------------
	// s007
	// --------------------------------
	/** お客様情報 */
	TCustomerDto customerInfo;
	/** アンケート情報 */
	TSurveyDto surveyInfo;
	/** 眼科への通院情報 */
	List<TVisitingHospitalDto> visitingHospitalInfoList;
	/** 眼の手術情報 */
	List<TSurgeryDto> surgeryInfoList;
	/** 視力低下情報 */
	List<TVisionLossDto> visionLossInfoList;
	/** メガネ装用情報 */
	List<TGlassesUsageDto> glassesUsageInfoList;
	/** 装用状況情報 */
	List<TUsageStatusDto> usageStatusInfoList;
	/** トラブル情報 */
	List<TTroubleDto> troubleInfoList;
	/** 症状情報 */
	List<TSymptomsDto> symptomsInfoList;
	/** 眩しさ情報 */
	List<TGlareDto> glareInfoList;
	/** 見づらさ疲れ情報 */
	List<TDiscomfortFatigueDto> discomfortFatigueInfoList;
	/** 見えないと困るもの情報 */
	List<TCriticalVisibilityNeedsDto> criticalVisibilityNeedsInfoList;
	/** 見づらさ疲れ情報 */
	List<TOccupationDto> occupationInfoList;
	/** 見えないと困るもの情報 */
	List<THobbiesClubActivitiesDto> hobbiesClubActivitiesInfoList;
	/** 過去の病歴情報 */
	List<TPastMedicalHistoryDto> pastMedicalHistoryInfoList;
	/** 治療中の疫病・服用薬情報 */
	List<TOngoingDiseasesMedicationDto> ongoingDiseasesMedicationInfoList;
	
	// --------------------------------
	// 結果（一番最後、これより下に情報を入れない）
	// --------------------------------
	String resultCd;
	String message;
	public void setResultCd(String success) {
		// TODO Auto-generated method stub
	}
}
