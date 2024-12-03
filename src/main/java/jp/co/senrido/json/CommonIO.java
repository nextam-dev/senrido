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
//import com.makino_saiten.jomu.dto.CodeNameDto;
//import com.makino_saiten.jomu.dto.MVehicleDto;
//import com.makino_saiten.jomu.dto.RollCallRecordDetailDto;
//import com.makino_saiten.jomu.dto.RollCallRecordDto;
//import com.makino_saiten.jomu.entity.MEmployee;
//import com.makino_saiten.jomu.entity.MVehicle;

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
	

	
	// --------------------------------
	// 結果（一番最後、これより下に情報を入れない）
	// --------------------------------
	String resultCd;
	String message;
	public void setResultCd(String success) {
		// TODO Auto-generated method stub
	}
}
