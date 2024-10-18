/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：CommonIO.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.json;

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

//	// --------------------------------
//	// メニュー(j002)
//	// --------------------------------
//	/** 前回点呼記録 */
//	RollCallRecordDto rollCallRecordLastInfo;
//
//	// --------------------------------
//	// メニュー(j003)
//	// --------------------------------
//	/** 点呼記録一覧情報 */
//	List<RollCallRecordDto> rollCallRecordList;
//
//	// --------------------------------
//	// 点呼記録簿(j004)
//	// --------------------------------
//	/** 点呼記録 */
//	RollCallRecordDto rollCallRecordInfo;
//	/** 点呼記録詳細 */
//	List<RollCallRecordDetailDto> rollCallRecordDetailList;
//
//	// --------------------------------
//	// コードマスタ関連
//	// --------------------------------
//	/** 運行区分 */
//	List<CodeNameDto> operationDivCodeList = new ArrayList<CodeNameDto>();
//	/** 出庫点呼方法区分 */
//	List<CodeNameDto> shippRollCallMethodDivList = new ArrayList<CodeNameDto>();
//	/** 出庫検知器有無 */
//	List<CodeNameDto> shippDetectorExistenceCodeList = new ArrayList<CodeNameDto>();
//	/** 出庫酒氣有無 */
//	List<CodeNameDto> shippSakeExistenceCodeList = new ArrayList<CodeNameDto>();
//	/** 出庫疫病疲労有無 */
//	List<CodeNameDto> shippPlagueFatigueExistenceCodeList = new ArrayList<CodeNameDto>();
//	/** 帰庫点呼方法区分 */
//	List<CodeNameDto> returnRollCallMethodDivList = new ArrayList<CodeNameDto>();
//	/** 帰庫検知器有無 */
//	List<CodeNameDto> returnDetectorExistenceCodeList = new ArrayList<CodeNameDto>();
//	/** 帰庫酒氣有無 */
//	List<CodeNameDto> returnSakeExistenceCodeList = new ArrayList<CodeNameDto>();
//	/** 帰庫疫病疲労有無 */
//	List<CodeNameDto> returnPlagueFatigueExistenceCodeList = new ArrayList<CodeNameDto>();
//	/** 完了ステータス */
//	List<CodeNameDto> completeStatusList = new ArrayList<CodeNameDto>();
//	/** 車種区分 */
//	List<CodeNameDto> carMakeDivList = new ArrayList<CodeNameDto>();
//	/** 目的地区分 */
//	List<CodeNameDto> purposeAreaDivList = new ArrayList<CodeNameDto>();
//	/** 運行目的区分 */
//	List<CodeNameDto> operationPurposeDivList = new ArrayList<CodeNameDto>();
//
//	// --------------------------------
//	// 社員マスタ関連
//	// --------------------------------
//	/** 起票者 */
//	List<MEmployee> voterList = new ArrayList<MEmployee>();
//	/** 出庫点呼執行者 */
//	List<MEmployee> shippRollCallEnforcerList = new ArrayList<MEmployee>();
//	/** 出庫記載者 */
//	List<MEmployee> shippAuthorList = new ArrayList<MEmployee>();
//	/** 帰庫点呼執行者 */
//	List<MEmployee> returnRollCallEnforcerList = new ArrayList<MEmployee>();
//	/** 帰庫記載者 */
//	List<MEmployee> returnAuthorList = new ArrayList<MEmployee>();
//	/** 記載者 */
//	List<MEmployee> authorList = new ArrayList<MEmployee>();
//	/** 運転者 */
//	List<MEmployee> driverList = new ArrayList<MEmployee>();
//
//	// --------------------------------
//	// 車両マスタ
//	// --------------------------------
//	List<MVehicle> vehicleList = new ArrayList<MVehicle>();
	
	// --------------------------------
	// 結果（一番最後、これより下に情報を入れない）
	// --------------------------------
	String resultCd;
	String message;
}
