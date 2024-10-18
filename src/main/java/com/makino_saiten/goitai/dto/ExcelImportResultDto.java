package com.makino_saiten.goitai.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 
 * Excelインポート用DTO
 * @author s_uryu
 *
 */
@Data
@NoArgsConstructor
public class ExcelImportResultDto {

	/** 結果コード */
	private String resultCd;

	/** メッセージ */
	private List<String> message;
}
