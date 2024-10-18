/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：U002MenuForm.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.form;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.makino_saiten.goitai.annotation.DatePattern;
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
public class UpdateTRollCallRecordForm extends BaseSearchForm {

	private static final long serialVersionUID = 1L;

	/** 点呼記録番号 */
    private String rollCallRecordNo;

    /** 車両番号 */
    private String vehicleNo;

    /** 登録日 */
    @DatePattern(pattern="yyyy-MM-dd")
    private String registDate;

    /** 運行区分コード */
    private String operationDivCode;

    /** 起票者コード */
    private String voterCode;

    /** 起票者名 */
    @MessageName("起票者")
    @Size(max = 25, message = "{javax.validation.constraints.MaxSize.message}")
    private String voterName;

    /** 葬家名1 */
    @MessageName("葬家名1")
    @Size(max = 25, message = "{javax.validation.constraints.MaxSize.message}")
    private String undertakerName1;

    /** 葬家名2 */
    @MessageName("葬家名2")
    @Size(max = 25, message = "{javax.validation.constraints.MaxSize.message}")
    private String undertakerName2;

    /** 葬家名3 */
    @MessageName("葬家名3")
    @Size(max = 25, message = "{javax.validation.constraints.MaxSize.message}")
    private String undertakerName3;

    /** 出庫時日付 */
    @MessageName("出庫時日付")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @DatePattern(pattern="yyyy-MM-dd")
    private String shippDate;

    /** 出庫時間 */
    @MessageName("出庫時間")
    @DateTimeFormat(pattern="HH:mm")
    @DatePattern(pattern="HH:mm")
    private String shippTime;

    /** 出庫点呼方法区分 */
    private String shippRollCallMethodDiv;

    /** 出庫検知器有無 */
    private String shippDetectorExistenceCode;

    /** 出庫酒気有無 */
    private String shippSakeExistenceCode;

    /** 出庫疫病疲労有無 */
    private String shippPlagueFatigueExistenceCode;

    /** 出庫点呼執行者コード */
    private String shippRollCallEnforcerCode;

    /** 出庫点呼執行者名 */
    @MessageName("出庫点呼執行者")
    @Size(max = 25, message = "{javax.validation.constraints.MaxSize.message}")
    private String shippRollCallEnforcerName;

    /** 出庫記載者コード */
    private String shippAuthorCode;

    /** 出庫記載者名 */
    @MessageName(" 出庫記載者")
    @Size(max = 25, message = "{javax.validation.constraints.MaxSize.message}")
    private String shippAuthorName;

    /** 帰庫時日付 */
    @MessageName("帰庫時日付")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @DatePattern(pattern="yyyy-MM-dd")
    private String returnDate;

    /** 帰庫時間 */
    @MessageName("帰庫時間")
    @DateTimeFormat(pattern="HH:mm")
    @DatePattern(pattern="HH:mm")
    private String returnTime;

    /** 帰庫点呼方法区分 */
    private String returnRollCallMethodDiv;

    /** 帰庫検知器有無 */
    private String returnDetectorExistenceCode;

    /** 帰庫酒気有無 */
    private String returnSakeExistenceCode;

    /** 帰庫疫病疲労有無 */
    private String returnPlagueFatigueExistenceCode;

    /** 帰庫点呼執行者コード */
    private String returnRollCallEnforcerCode;

    /** 帰庫点呼執行者名 */
    @MessageName("帰庫点呼執行者")
    @Size(max = 25, message = "{javax.validation.constraints.MaxSize.message}")
    private String returnRollCallEnforcerName;

    /** 帰庫記載者コード */
    private String returnAuthorCode;

    /** 帰庫記載者名 */
    @MessageName("帰庫記載者")
    @Size(max = 25, message = "{javax.validation.constraints.MaxSize.message}")
    private String returnAuthorName;

    /** 完了ステータス */
    private String completeStatus;

    /** 修正金額 */
    @MessageName("修正金額")
    @Size(max = 8, message = "{javax.validation.constraints.MaxSize.message}")
    private String adjustmentAmount;

    /** 留置1時間 */
    @MessageName("留置1時間")
    @Size(max = 2, message = "{javax.validation.constraints.MaxSize.message}")
    private String detention1Hour;

    /** 留置1分 */
    @MessageName("留置1分")
    @Size(max = 2, message = "{javax.validation.constraints.MaxSize.message}")
    private String detention1Minute;

    /** 留置2時間 */
    @MessageName("留置2時間")
    @Size(max = 2, message = "{javax.validation.constraints.MaxSize.message}")
    private String detention2Hour;

    /** 留置2分 */
    @MessageName("留置2分")
    @Size(max = 2, message = "{javax.validation.constraints.MaxSize.message}")
    private String detention2Minute;

    /** 留置3時間 */
    @MessageName("留置3時間")
    @Size(max = 2, message = "{javax.validation.constraints.MaxSize.message}")
    private String detention3Hour;

    /** 留置3分 */
    @MessageName("留置3分")
    @Size(max = 2, message = "{javax.validation.constraints.MaxSize.message}")
    private String detention3Minute;

    /** 早朝深夜作業時間 */
    @MessageName("早朝深夜作業時間")
    @Size(max = 2, message = "{javax.validation.constraints.MaxSize.message}")
    private String morningNightWorkHour;

    /** 早朝深夜作業分 */
    @MessageName("早朝深夜作業分")
    @Size(max = 2, message = "{javax.validation.constraints.MaxSize.message}")
    private String morningNightWorkMinute;

    /** 運管 */
    @MessageName("留置時間単価")
    @Size(max = 50, message = "{javax.validation.constraints.MaxSize.message}")
    private String operationManager;

    /** 留置時間単価 */
    @MessageName("留置時間単価")
    @Size(max = 8, message = "{javax.validation.constraints.MaxSize.message}")
    private String detentionTimeUnit;

    /** 留置時間コマ */
    @MessageName("留置時間コマ")
    @Size(max = 9, message = "{javax.validation.constraints.MaxSize.message}")
    private String detentionTimeKoma;

    /** 深夜料金単価 */
    @MessageName("深夜料金単価")
    @Size(max = 8, message = "{javax.validation.constraints.MaxSize.message}")
    private String nightChargeUnit;

    /** 備考 */
    @MessageName("備考")
    @Size(max = 200, message = "{javax.validation.constraints.MaxSize.message}")
    private String note;

}
