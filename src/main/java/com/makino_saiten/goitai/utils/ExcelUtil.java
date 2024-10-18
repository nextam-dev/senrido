/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：ExcelUtil.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.utils;

/**
 * Excel編集用Utilクラス
 * 
 * @author $Author: $
 * @version $Revision: $ $Date: $
 *
 */
public class ExcelUtil {

	/** 空文字 */
	private static final String EMPTY_STRING = "";

	/** アンダースコア */
	private static final String UNDERSCORE = "_";

	/** チルダ */
	private static final String TILDE = "～";

	/** エクセルxls拡張子 */
	private static final String FILENAME_EXT = ".xls";

	/** 半角スペース */
	private static final String ONEBYTE_SPACE = " ";

	/**
	 * ファイル名を取得する
	 *
	 * @param
	 * @return
	 */
	public static String getFileName(String BaseFileName, String documentDateFrom, String documentDateTo) {
		// 日付をyyyyMMddにフォーマット
		String dateFrom = getFileDate(documentDateFrom);
		String dateTo = getFileDate(documentDateTo);

		String fileName = null;

		if (StringUtil.isEmpty(dateFrom) && StringUtil.isEmpty(dateTo)) {
			fileName = BaseFileName + FILENAME_EXT;
		} else if (dateFrom.equals(dateTo)) {
			fileName = BaseFileName + UNDERSCORE + dateFrom + FILENAME_EXT;
		} else {
			fileName = BaseFileName + UNDERSCORE + dateFrom + TILDE + dateTo + FILENAME_EXT;
		}

		return fileName;
	}

	/**
	 * ファイル名の日付を取得する
	 *
	 * @param strDate
	 * @return "yyyyMMdd"
	 */
	public static String getFileDate(String strDate) {
		if (strDate == null || strDate.equals(EMPTY_STRING)) {
			return EMPTY_STRING;
		}

		String strYear = strDate.substring(0, 4);
		String strMonth = strDate.substring(5, 7);
		String strDay = strDate.substring(8, 10);

		return strYear + strMonth + strDay;
	}

	/**
	 * シート名をチェックする（nullの場合、半角スペースを返す）
	 *
	 * @param value
	 *            対象文字列
	 * @return
	 */
	public static String checkSheetName(String value) {
		if (value == null) {
			return ONEBYTE_SPACE;
		} else {
			return value;
		}
	}

}
