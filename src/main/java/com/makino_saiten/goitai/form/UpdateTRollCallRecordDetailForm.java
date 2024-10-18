/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：U002MenuForm.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.form;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.makino_saiten.goitai.annotation.MessageName;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 点呼記録簿画面 更新用Formクラス
 * @author hirokawa
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class UpdateTRollCallRecordDetailForm extends BaseSearchForm {

	private static final long serialVersionUID = 1L;

	/** 点呼記録番号 */
    private String rollCallRecordNo;

    /** 連番 */
    private String seq;

    /** 回数 */
    private String numberTimes;

    /** 車種区分 */
    private String carMakeDiv;

    /** 出発時間 */
    @MessageName("出発時間")
    @DateTimeFormat(pattern = "HH:mm")
    private String departureTime;

    /** 到着時間 */
    @MessageName("到着時間")
    @DateTimeFormat(pattern = "HH:mm")
    private String arrivalTime;

    /** 出発距離 */
    @MessageName("出発距離")
    @Size(max = 9, message = "{javax.validation.constraints.MaxSize.message}")
    private String departureDistance;

    /** 到着距離 */
    @MessageName("到着距離")
    @Size(max = 9, message = "{javax.validation.constraints.MaxSize.message}")
    private String arrivalDistance;

    /** 目的地区分 */
    private String purposeAreaDiv;

    /** 目的地名 */
    @MessageName("目的地")
    @Size(max = 25, message = "{javax.validation.constraints.MaxSize.message}")
    private String purposeAreaName;

    /** 運行目的区分 */
    private String operationPurposeDiv;

    /** 運行目的 */
    @MessageName("運行目的")
    @Size(max = 25, message = "{javax.validation.constraints.MaxSize.message}")
    private String operationPurposeName;

    /** 運転者コード */
    private String driverCode;

    /** 運転者名 */
    @MessageName("運転者")
    @Size(max = 25, message = "{javax.validation.constraints.MaxSize.message}")
    private String driverName;

    /** 記載者コード */
    private String authorCode;

    /** 記載者名 */
    @MessageName("記載者")
    @Size(max = 25, message = "{javax.validation.constraints.MaxSize.message}")
    private String authorName;

}
