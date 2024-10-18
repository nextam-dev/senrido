/**
 *
 */
package com.makino_saiten.goitai.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.ObjectUtils;

import com.ibm.icu.text.SimpleDateFormat;
import com.makino_saiten.goitai.common.GoitaiConstant;

/**
 * @author t_hirose
 *
 */
public class StringUtil {

	public static final char KATAKANA_SMALL_A=12449;
	public static final char KATAKANA_NN=12531;

	public static final char HIRAGANA_SMALL_A=12353;
	public static final char HIRAGANA_NN=12435;


	/**
	 * 空白チェック
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		}
		if (str.length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * spaceを排除した空白チェック
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		if (str == null) {
			return true;
		}
		if (str.replaceAll(" ", "").replaceAll("　", "").length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * [value]が有効な値かどうか検証します。
	 *
	 * @param value
	 *            評価対象文字列
	 * @return [true]:nullでなく""でない場合
	 */
	public static boolean isExist(String value) {
		if (value != null && value.length() != 0) {
			return true;
		}
		return false;
	}


	/**
	 * java.util.Dateクラスまたは、そのサブクラスを指定のフォーマットで 文字列に変換します。
	 *
	 * @param date
	 *            変換対象のjava.util.Dateクラス
	 * @param pattern
	 *            指定のフォーマット
	 * @return フォーマットされた日付文字列
	 */
	public static String toStringDate(Date date, String pattern) {
		SimpleDateFormat sdFormat = new SimpleDateFormat(pattern);
		return sdFormat.format(date);
	}

	public static java.sql.Date toSqlDate(String strDate) {
		Calendar cal = toCalendar(strDate);
		return toSqlDate(cal);
	}

	public static java.sql.Date toSqlDate(Calendar cal) {
		long l = cal.getTime().getTime();
		return new java.sql.Date(l);
	}

	/**
	 * 時間のロング値を指定のフォーマットで文字列に変換します。
	 *
	 * @param time
	 *            現在時刻のミリ秒を表すロング値
	 * @param pattern
	 *            指定のフォーマット
	 * @return フォーマットされた日付文字列
	 */
	public static String toStringDate(long time, String pattern) {
		return toStringDate(new Date(time), pattern);
	}

	/**
	 * String ⇒ java.sql.Date
	 *
	 * 以下の日付文字列をjava.sql.Dateに変換 yyyy/MM/dd HH:mm:ss.SSS yyyy-MM-dd HH:mm:ss.SSS
	 *
	 * "20030407" "2003/04/07" "2003-04-07" "2003/04/07 15:20:16" "2003-04-07
	 * 15:20:16"
	 *
	 * @param strDate
	 * @return
	 */
	public static Calendar toCalendar(String strDate) {
		strDate = format(strDate);
		Calendar cal = Calendar.getInstance();

		int yyyy = Integer.parseInt(strDate.substring(0, 4));
		int MM = Integer.parseInt(strDate.substring(5, 7));
		int dd = Integer.parseInt(strDate.substring(8, 10));
		int HH = cal.get(Calendar.HOUR_OF_DAY);
		int mm = cal.get(Calendar.MINUTE);
		int ss = cal.get(Calendar.SECOND);
		int SSS = cal.get(Calendar.MILLISECOND);

		cal.clear();
		cal.set(yyyy, MM - 1, dd);

		int len = strDate.length();
		switch (len) {
		case 10:
			break;
		case 16: // yyyy/MM/dd HH:mm
			HH = Integer.parseInt(strDate.substring(11, 13));
			mm = Integer.parseInt(strDate.substring(14, 16));
			cal.set(Calendar.HOUR_OF_DAY, HH);
			cal.set(Calendar.MINUTE, mm);
			break;
		case 19: // yyyy/MM/dd HH:mm:ss
			HH = Integer.parseInt(strDate.substring(11, 13));
			mm = Integer.parseInt(strDate.substring(14, 16));
			ss = Integer.parseInt(strDate.substring(17, 19));
			cal.set(Calendar.HOUR_OF_DAY, HH);
			cal.set(Calendar.MINUTE, mm);
			cal.set(Calendar.SECOND, ss);
			break;
		case 23: // yyyy/MM/dd HH:mm:ss.SSS
			HH = Integer.parseInt(strDate.substring(11, 13));
			mm = Integer.parseInt(strDate.substring(14, 16));
			ss = Integer.parseInt(strDate.substring(17, 19));
			SSS = Integer.parseInt(strDate.substring(20, 23));
			cal.set(Calendar.HOUR_OF_DAY, HH);
			cal.set(Calendar.MINUTE, mm);
			cal.set(Calendar.SECOND, ss);
			cal.set(Calendar.MILLISECOND, SSS);
			break;
		default:
			throw new IllegalStateException("このString文字列は日付文字列に変換できません : "
					+ strDate);
		}
		return cal;
	}

	/**
	 * あらゆる日付文字列を"yyyy/MM/dd" or "yyyy/MM/dd HH:mm:ss"の フォーマットに変換することを試みます。
	 * 例：03/1/3 ⇒ 2003/01/03
	 *
	 * @param strDate
	 * @return
	 */
	public static String format(String strDate) {
		strDate = strDate.trim();
		String yyyy = null;
		String MM = null;
		String dd = null;
		String HH = null;
		String mm = null;
		String ss = null;
		String SSS = null;

		// "-" or "/" が無い場合
		if (strDate.indexOf("/") == -1 && strDate.indexOf("-") == -1) {
			if (strDate.length() == 8) {
				yyyy = strDate.substring(0, 4);
				MM = strDate.substring(4, 6);
				dd = strDate.substring(6, 8);
				return yyyy + "/" + MM + "/" + dd;
			} else {
				yyyy = strDate.substring(0, 4);
				MM = strDate.substring(4, 6);
				dd = strDate.substring(6, 8);
				HH = strDate.substring(9, 11);
				mm = strDate.substring(12, 14);
				ss = strDate.substring(15, 17);
				return yyyy + "/" + MM + "/" + dd + " " + HH + ":" + mm + ":"
						+ ss;
			}
		}
		StringTokenizer token = new StringTokenizer(strDate, "_/-:. ");
		StringBuffer result = new StringBuffer();
		for (int i = 0; token.hasMoreTokens(); i++) {
			String temp = token.nextToken();
			switch (i) {
			case 0:// 年の部分
				yyyy = fillString(strDate, temp, "f", "20", 4);
				result.append(yyyy);
				break;
			case 1:// 月の部分
				MM = fillString(strDate, temp, "f", "0", 2);
				result.append("/" + MM);
				break;
			case 2:// 日の部分
				dd = fillString(strDate, temp, "f", "0", 2);
				result.append("/" + dd);
				break;
			case 3:// 時間の部分
				HH = fillString(strDate, temp, "f", "0", 2);
				result.append(" " + HH);
				break;
			case 4:// 分の部分
				mm = fillString(strDate, temp, "f", "0", 2);
				result.append(":" + mm);
				break;
			case 5:// 秒の部分
				ss = fillString(strDate, temp, "f", "0", 2);
				result.append(":" + ss);
				break;
			case 6:// ミリ秒の部分
				SSS = fillString(strDate, temp, "b", "0", 3);
				result.append("." + SSS);
				break;
			}
		}
		return result.toString();
	}

	public static String fillString(String strDate, String str,
			String position, String addStr, int len) {

		if (str.length() > len) {
			String mes = strDate + "このString文字列は日付文字列に変換できません";
			throw new IllegalStateException(mes);
		}
		return fillString(str, position, addStr, len);
	}

	/**
	 * 文字列[str]に対して補充する文字列[addStr]を[position]の位置に[len]に 満たすまで挿入します。
	 * <p>
	 * 例： String ss = StringUtil.fillString("aaa","b","0",7); ss ⇒ "aaa0000"
	 *
	 * ※fillString()はlenに満たすまで挿入しますが、addString()はlen分挿入します。
	 *
	 * @param str
	 *            対象文字列
	 * @param position
	 *            前に挿入 ⇒ F/f 後に挿入 ⇒ B/b
	 * @param addStr
	 *            挿入する文字列
	 * @param len
	 *            補充するまでの桁数
	 * @return 変換後の文字列。 [str]がnullや空リテラルも[addStr]を[len]に 満たすまで 挿入した結果を返します。
	 */
	public static String fillString(String str, String position,
			String addStr, int len) {
		StringBuffer tempBuffer = null;
		if (!isExist(str)) {
			tempBuffer = new StringBuffer();
			for (int i = 0; i < len; i++) {
				tempBuffer.append(addStr);
			}
			return tempBuffer.toString();
		} else if (str.length() != len) {
			tempBuffer = new StringBuffer(str);
			while (len > tempBuffer.length()) {
				if (position.equalsIgnoreCase("f")) {
					tempBuffer.insert(0, addStr);
				} else {
					tempBuffer.append(addStr);
				}
			}
			return tempBuffer.toString();
		}
		return str;
	}

	/**
	 * あいまい検索用ワイルドカード埋め込み
	 */
	public static String attachWildCard(String str) {
		return "%" + str + "%";
	}

//	/**
//	 * 郵便番号フォーマット変換
//	 */
//	public static String createZipCd(String str) {
//		String result = GoitaiConstant.BLANK;
//		if(!ObjectUtils.isEmpty(str)) {
//			StringBuilder sb = new StringBuilder(str);
//			sb.insert(3,GoitaiConstant.HALF_HYPHEN);
//			result = sb.toString();
//		}
//		return result;
//	}

	/**
	 * 前0の削除
	 */
	public static String deleateBeforeZero(String str) {
		String result = str;
		Pattern p = Pattern.compile("^0+([0-9]+.*)");
        Matcher m = p.matcher(str);
        if (m.matches()) {
        	result = m.group(1);
        }
        return result;
	}

	/**
	 * ひらがな→カタカナ変換
	 *
	 * @param sb
	 * @return
	 */
	public static String ganaToKana(String s) {
		StringBuffer sb = new StringBuffer(s);
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c >= HIRAGANA_SMALL_A && c <= HIRAGANA_NN) {
				sb.setCharAt(i, (char) (c - HIRAGANA_SMALL_A + KATAKANA_SMALL_A));
			}
		}
		return sb.toString();
	}
}
