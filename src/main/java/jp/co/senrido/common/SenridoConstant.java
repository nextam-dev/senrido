/* =============================================================
5 * ご遺体管理システム
 * ファイル名：GoitaiConstant.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package jp.co.senrido.common;

/**
 * 共通定数定義クラス
 *
 * @author kurokawa
 */
public class SenridoConstant {

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

	public class Application {
		/** プロパティファイル名 */
		public static final String PROPERTIES = "application";
		/** コンテキスト情報 */
		public static final String CONTEXT_PATH = "context.path";
		/** 環境情報 */
		public static final String KEY_PROFILES_ACTIVE = "spring.profiles.active";
		/** URL */
		public static final String KEY_URL = "system.url";
		/** メール送信元 */
		public static final String KEY_MAIL_FROM = "mail.from";
	}

}
