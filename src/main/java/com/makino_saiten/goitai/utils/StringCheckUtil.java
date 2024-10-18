package com.makino_saiten.goitai.utils;

import java.io.UnsupportedEncodingException;

/**
 * <pre>
 * 文字列チェックのユーティリティークラス
 * </pre>
 *
 * @author W.Tsukamoto
 * @version 1.0.0
 */
public class StringCheckUtil {



	/**
	 * 正の整数かどうかチェック。 Integer型にパースできる文字列かどうかで判断しています。
	 *
	 * @param 文字列
	 * @return 数字のみの文字列の場合true
	 */
	public static boolean isInteger(String s) {
		boolean flg = true;
		int redbl = 0;

		if (StringUtil.isEmpty(s)) {
			return false;
		} else if (s.trim().equals("")) {
			return false;
		}

		try {
			redbl = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			flg = false;
		}
		if (redbl <= 0) {
			return false;
		}
		return flg;
	}

	/**
	 * 数字かどうかチェック。 Double型にパースできる文字列かどうかで判断しています。 したがって、小数点を一つだけ含む文字列や先頭に負記号を含む文字列なども 有効となります。
	 *
	 * @param 文字列
	 * @return 数字のみの文字列の場合true
	 */
	@SuppressWarnings("unused")
	public static boolean isDouble(String s) {
		boolean flg = true;

		if (StringUtil.isEmpty(s)) {
			return false;
		} else if (s.trim().equals("")) {
			return false;
		}

		try {
			double redbl = Double.parseDouble(s);
		} catch (NumberFormatException e) {
			flg = false;
		}
		return flg;
	}

	/**
	 * 半角文字列かどうかチェック。
	 *
	 * @param 文字列
	 * @return 半角文字列、及びnullの場合true
	 */
	public static boolean isHankaku(String s) {

		if (StringUtil.isEmpty(s)) {
			return true;
		}

		for (int i = 0; i < s.length(); i++) {
			char chr = s.charAt(i);
			int chrCode = (int) chr;
			if ((chrCode < 33) || (255 < chrCode) || (chrCode == 13)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * スペースを取り除いて半角文字列かどうかチェック。
	 *
	 * @param 文字列
	 * @return 半角文字列の場合true
	 */
	public static boolean isHankakuToRemoveSpace(String s) {
		if (StringUtil.isEmpty(s)) {
			return true;
		}

		String ss = new String(s.replaceAll(" ",""));

		for (int i = 0; i < ss.length(); i++) {
			char chr = ss.charAt(i);
			int chrCode = (int) chr;
			if ((chrCode < 33) || (255 < chrCode) || (chrCode == 13)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 英数文字列かどうかチェック。
	 *
	 * @param 文字列
	 * @return 英数文字列の場合true
	 */
	public static boolean isAlfOrNumber(String s) {
		if (StringUtil.isEmpty(s)) {
			return true;
		}

		for (int i = 0; i < s.length(); i++) {
			String str = s.substring(i, i + 1);
			if (!isAlphabet(str) && !isInteger(str)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 対象文字列が正規表現と一致するかどうかチェック。
	 *
	 * @param s 対象文字列
	 * @param regEx 正規表現
	 * @return 正規表現と一致する場合true
	 */
	public static boolean isMask(String s, String regEx) {
		if (StringUtil.isEmpty(s)) {
			return true;
		}

		boolean flg = false;

		if (s != null) {
			if (s.matches(regEx))
				flg = true;
		}

		return flg;
	}

	/**
	 * 対象文字列が英字かどうかチェック
	 *
	 * @param value
	 * @return 英字の場合true
	 */
	public static boolean isAlphabet(String s) {
		// 英字判定
		if (isMask(s, "^[A-Za-z]+$")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 数値桁チェック（整数）
	 *
	 * @param  String
	 * @param  int
	 * @return boolean
	 * @throws UnsupportedEncodingException
	 */
	public static boolean seisuketacheck(String value, int cnt) throws Exception{
		boolean ret = false;

		//空の場合は正常で返す
		if (value == null || "".equals(value)) {
			ret = true;
			return ret;
		}

		//カンマは除く
		String str = value.replaceAll(",","");

		//小数点前までの値を取得
		int i = str.indexOf(".");
		if (i != -1) {
			str = str.substring(0,i);
		}

		//桁チェック
		if (str != null) {
			if (cnt >= str.length()) {
				ret = true;
			}
		} else {
			ret = true;
		}

		return ret;
	}

	/**
	 * 数値桁チェック（小数）
	 *
	 * @param  String
	 * @param  int
	 * @return boolean
	 * @throws UnsupportedEncodingException
	 */
	public static boolean shosuketacheck(String value, int cnt) throws Exception{
		boolean ret = false;

		//空の場合は正常で返す
		if (value == null || "".equals(value)) {
			ret = true;
			return ret;
		}

		//カンマは除く
		String str = value.replaceAll(",","");

		//小数点前までの値を取得
		int i = str.indexOf(".");
		if (i == -1) {
			ret = true;
			return ret;
		}
		str = str.substring(i+1);

		//桁チェック
		if (str != null) {
			if (cnt >= str.length()) {
				ret = true;
			}
		} else {
			ret = true;
		}

		return ret;
	}

	/**
	 * 特殊文字ありのバイトチェック用エンコード処理.
	 *
	 * @param value
	 * @return
	 */
	public static int checkNVLByte(String value) {
		if (value == null) {
			return 0;
		}

		int length = 0;
		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			if (c >= 0x20 && c <= 0x7E) {
				// JISローマ字(ASCII)
				length++;
			} else if (c >= 0xFF61 && c <= 0xFF9F) {
				// JISカナ(半角カナ)
				length++;
			} else {
				// その他(全角)
				length += 2;
			}
		}
		return length;
	}

}
