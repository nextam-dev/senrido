/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：U002MenuForm.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.form;

import javax.validation.constraints.Size;

import com.makino_saiten.goitai.annotation.MessageName;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 車輌マスタ画面 更新用Formクラス
 * @author seki
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class UpdateMVehicleForm extends BaseSearchForm {

	private static final long serialVersionUID = 1L;

	/** 車両番号*/
	@MessageName("車輌番号")
    @Size(max = 4, message = "{javax.validation.constraints.MaxSize.message}")
	private String vehicleNo;

	/** ナンバー*/
	@MessageName("ナンバー")
    @Size(max = 20, message = "{javax.validation.constraints.MaxSize.message}")
	private String number;

	/** 乗車可否フラグ*/
	private boolean vehicleProprietyFlg;

}
