/* =============================================================
5 * ご遺体管理システム
 * ファイル名：GoitaiConstant.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.common;

/**
 * 共通定数定義クラス
 *
 * @author kurokawa
 */
public class GoitaiConstant {

	/**
	 * 結果コード.
	 *
	 * @author y_kawatani
	 * @version 2018/06/11
	 */
	public class ResultCd {

		/** 成功 */
		public final static String SUCCESS = "001";

		/** 業務エラー */
		public final static String BUSSINESS_ERROR = "400";

		/** システムエラー */
		public final static String SYSTEM_ERROR = "999";
	}

	// JSON結果コード（成功）
	public static final String SUCCESS = "0";
	// JSON結果コード（エラー）
	public static final String ERROR = "1";

	// 削除
	/** 削除コード：有効状態 */
	public static final Boolean DELFLG_EFFECT = false;
	/** 削除コード：削除状態 */
	public static final Boolean DELFLG_DELETE = true;

	/**
	 * コードマスタ検索DIV_CODE
	 *
	 * @author hirokawa
	 * @version 2023/12/25
	 */
	public class DivCode {
		/** 和暦 */
		public static final String DEV_CODE_WAREKI = "wareki";
		/** 車種区分 */
		public final static String CAR_MAKE_DIV = "car_make_div";
		/** 完了ステータス区分 */
		public final static String COMPLETE_STATUS_DIV = "complete_status_div";
		/** 目的地区分 */
		public final static String DESTINATION_CLASS_DIV = "destination_class_div";
		public final static String DESTINATION_DIV = "destination_div";
		/** 検知器有無 */
		public final static String DETECTOR_EXISTENCE = "detector_existence";
		/** 運行区分 */
		public final static String OPERATION_DIV = "operation_div";
		/** 運行目的区分 */
		public final static String OPERATION_PURPOSE_DIV = "operation_purpose_div";
		/** 疫病疲労有無 */
		public final static String PLAGUE_FATIGUE_EXISTENCE = "plague_fatigue_existence";
		/** 点呼方法区分 */
		public final static String ROLL_CALL_METHOD_DIV = "roll_call_method_div";
		/** 酒氣有無 */
		public final static String SAKE_EXISTENCE = "sake_existence";

	}

	/**
	 * 完了ステータス
	 *
	 * @author hirokawa
	 * @version 2023/12/25
	 */
	public class CompleteStatus {
		/** 完了 */
		public final static String COMPLETE = "1";

		/** 未完了 */
		public final static String NOT_COMPLETE = "2";
	}

	/**
	 * 車種区分
	 *
	 * @author hirokawa
	 * @version 2023/12/25
	 */
	public class CarMake {
		/** 実車 */
		public final static String EXIST = "1";

		/** 空車 */
		public final static String BLANK = "2";
	}

	/**
	 * 点呼方法区分
	 *
	 * @author hirokawa
	 * @version 2023/12/25
	 */
	public class RollCallMethod {
		/** 対面 */
		public final static String FACE = "1";

		/** 電話 */
		public final static String CALL = "2";
	}

	/**
	 * 検知器有無
	 *
	 * @author hirokawa
	 * @version 2023/12/25
	 */
	public class Detector {
		/** 有 */
		public final static String EXIST = "1";

		/** 無 */
		public final static String NONE = "2";
	}

	/**
	 * 酒氣有無
	 *
	 * @author hirokawa
	 * @version 2023/12/25
	 */
	public class Sake {
		/** 有 */
		public final static String EXIST = "1";

		/** 無 */
		public final static String NONE = "2";
	}

	/**
	 * 疫病疲労有無
	 *
	 * @author hirokawa
	 * @version 2023/12/25
	 */
	public class PlagueFatigue {
		/** 有 */
		public final static String EXIST = "1";

		/** 無 */
		public final static String NONE = "2";
	}

	/** 半角カンマ */
	public final static String HALF_CAMMA = ",";

	/** 全角カンマ */
	public final static String ALL_CAMMA = "、";

	/** 半角スラッシュ */
	public final static String HALF_SLASH = "/";

	/** 全角スラッシュ */
	public final static String ALL_SLASH = "／";

	/** バックスラッシュ(正規表現) */
	public final static String BACK_SLASH = "\\\\";

	/** 半角スペース */
	public final static String HALF_SPACE = " ";

	/** 全角スペース */
	public final static String ALL_SPACE = "　";

	/** クォーテーション */
	public final static String QUOTATION = "'";

	/** 波線"～" */
	public final static String FROM_TO = "～";

	/** 括弧"(" */
	public final static String OPEN_BRACKETS = "(";

	/** 閉じ括弧")" */
	public final static String CLOSE_BRACKETS = ")";

	/** 括弧"【" */
	public final static String OPEN_SQUARE_BRACKETS = "【";

	/** 閉じ括弧"】" */
	public final static String CLOSE_SQUARE_BRACKETS = "】";

	/** 空文字 */
	public final static String BLANK = "";

	/** 改行コード(CR) */
	public final static String CR = "\r";

	/** 改行コード(LF) */
	public final static String LF = "\n";

	/** 改行コード(CRLF) */
	public final static String CRLF = "\r\n";

	public class JasperCd {
		/** Jasperファイル */
		public final static String JRXML_ROLLCALL_RECORD = "rollCallRecordBook";

		/** タイトル */
		public final static String TITLE_ROLLCALL_RECORD = "乗務記録兼点呼記録簿";

		/** 固定値 */
		// 基本料金
		public final static String BASIS = "12000";
		// 走行距離/1km
		public final static String MILEAGE_PER = "310";
		// 深夜料金/1作業
		public final static String LATE_NIGHT_PER = "1";
	}

	public class Application {
		/** プロパティファイル名 */
		public static final String PROPERTIES = "application";
		/** コンテキスト情報 */
		public static final String CONTEXT_PATH = "context.path";
		/** 環境情報 */
		public static final String KEY_PROFILES_ACTIVE = "spring.profiles.active";
	}

}
