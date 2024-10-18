/**
 * 
 */
package com.makino_saiten.goitai.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * 文字列チェックのユーティリティークラス
 * </pre>
 *
 * @author T.Hirose
 * @version 1.0.0
 */
public class StringConvertUtil {

	/**
	 * NVL編集。
	 *
	 * @param value 対象文字列
	 * @return String
	 */
	public static String editNVL(String value) {
		if (value == null) {
			return "";
		} else {
			return value;
		}
	}

	/**
	 * DB登録用編集関数 値がある場合は'をつけて返す。
	 *
	 * @param value 対象文字列
	 * @return String
	 */
	public static String dbinsEdit(String value) {
		if (value == null) {
			return "NULL";
		} else {
			return "'" + value + "'";
		}
	}

	/**
	 * 数字を二桁数字に変換する。 01、02、03 …
	 *
	 * @param i
	 * @return 二桁数字の文字列
	 */
	static public String stringValue(int i) {
		String str = "0";
		if (i < 10)
			str += String.valueOf(i);
		else
			str = String.valueOf(i);
		return str;
	}

	/**
	 * 数値加算処理
	 *
	 * @param counts
	 * @return
	 */
	public static String add(Object... counts) {
		long allCount = 0L;

		for (Object count : counts) {
			if (count == null) {
				continue;
			}

			// 数値でない場合は読み飛ばす
			if ("".equals(editNVL(count.toString())) || "-".equals(editNVL(count.toString()))) {
				continue;
			}

			allCount += Long.parseLong(count.toString());
		}

		return String.valueOf(allCount);
	}

	/**
	 * 文字列変換処理.
	 *
	 * @param o the object
	 * @return string
	 */
	public static String toString(Object o) {
		return o == null ? null : o.toString();
	}

	/**
	 * Integer変換処理.
	 *
	 * @param o
	 * @return int
	 */
	public static Integer parseIntForNull(Object o) {
		if (o == null) {
			return null;
		}
		if (StringUtil.isEmpty(o.toString())) {
			return null;
		}
		return (int) Integer.parseInt(o.toString());
	}

	/**
	 * Integer変換処理.
	 *
	 * @param o
	 * @return int
	 */
	public static int parseInt(Object o) {
		if (o == null) {
			return 0;
		}
		if (StringUtil.isEmpty(o.toString())) {
			return 0;
		}
		return (int) Integer.parseInt(o.toString());
	}

	/**
	 * Long値変換処理.
	 *
	 * @param o
	 * @return int
	 */
	public static long parseLong(Object o) {
		if (o == null) {
			return 0;
		}
		if (StringUtil.isEmpty(o.toString())) {
			return 0;
		}
		return (long) Long.parseLong(o.toString());
	}

	/**
	 * Float変換処理.
	 *
	 * @param o
	 * @return int
	 */
	public static float parseFloat(Object o) {
		if (o == null) {
			return 0;
		}
		if (StringUtil.isEmpty(o.toString())) {
			return 0;
		}
		return Float.parseFloat(o.toString());
	}

	/**
	 * Double変換処理.
	 *
	 * @param o
	 * @return int
	 */
	public static double parseDouble(Object o) {
		if (o == null) {
			return 0;
		}
		if (StringUtil.isEmpty(o.toString())) {
			return 0;
		}
		return Double.parseDouble(o.toString());
	}

	/**
	 * Boolean変換処理.
	 *
	 * @param o
	 * @return boolean
	 */
	public static boolean parseBoolean(Object o) {
		if (o == null) {
			return false;
		}
		if (StringUtil.isEmpty(o.toString())) {
			return false;
		}
		return Boolean.parseBoolean(o.toString());
	}
	/**
	 * BigDecimal値変換処理.
	 *
	 * @param o
	 * @return BigDecimal
	 */
	public static BigDecimal parseBigDecimal(Object o) {
		if (o == null) {
			return new BigDecimal("0");
		}
		if (StringUtil.isBlank(o.toString())) {
			return new BigDecimal("0");
		}
		return new BigDecimal(o.toString());
	}

	/**
	 * Date型→String型yyyy/mm/dd hh:mm:ss 変換処理.
	 *
	 * @param date
	 * @return String
	 */
	public static String date2string(Date date) {
		String strDate = "";
		if (date != null) {
			strDate = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(date);
		}
		return strDate;
	}

	/**
	 * 指定文字数になるまでchr文字を左側に埋める
	 * 
	 * @param src
	 * @param chr
	 * @param len
	 * @return
	 */
	public static String lpad(String src, String chr, Integer len) {
		for (int i = src.length(); i < len; i += chr.length()) {
			src = chr + src;
		}
		return src;
	}

	/**
	 * 指定文字数になるまでchr文字を右側に埋める
	 * 
	 * @param src
	 * @param chr
	 * @param len
	 * @return
	 */
	public static String rpad(String src, String chr, Integer len) {
		for (int i = src.length(); i < len; i += chr.length()) {
			src += chr;
		}
		return src;
	}
}
