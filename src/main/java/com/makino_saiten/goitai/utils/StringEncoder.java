/* ======================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：StringEncoder.java
 * ------------------------------------------------------
 * 作成日・変更履歴
 *
 * Date       Name         Reason for change
 * ---------- -----------  --------------------------------
 * 2005/03/18 T.HIROSE	   新規作成
 *
 *                              変換文字一覧
 *                              ~  0x007E       0x007E[TILDE]
 *                              \  0x005C       0x005C[REVERSE SOLIDUS]
 *                              ＼ 0x815F       0xFF3C[FULLWIDTH REVERSE SOLIDUS]
 *                              ～ 0x8160       0x301C[WAVE DASH]
 *                              ∥ 0x8161       0x2016[DOUBLE VERTICAL LINE]
 *                              － 0x817C       0x2212[MINUS SIGN]
 *                              ￠ 0x8191       0x00A2[CENT SIGN]
 *                              ￡ 0x8192       0x00A3[POUND SIGN]
 *                              ￢ 0x81CA       0x00AC[NOT SIGN]
 * 								Ⅰ 0x8754		0x2160	#ROMAN NUMERAL ONE
 *								Ⅱ 0x8755		0x2161	#ROMAN NUMERAL TWO
 *								Ⅲ 0x8756		0x2162	#ROMAN NUMERAL THREE
 *								Ⅳ 0x8757		0x2163	#ROMAN NUMERAL FOUR
 *								Ⅴ 0x8758		0x2164	#ROMAN NUMERAL FIVE
 *								Ⅵ 0x8759		0x2165	#ROMAN NUMERAL SIX
 *								Ⅶ 0x875A		0x2166	#ROMAN NUMERAL SEVEN
 *								Ⅷ 0x875B		0x2167	#ROMAN NUMERAL EIGHT
 *								Ⅸ 0x875C		0x2168	#ROMAN NUMERAL NINE
 *								Ⅹ 0x875D		0x2169	#ROMAN NUMERAL TEN
 *								ⅰ 0xEEEF		0x2170	#SMALL ROMAN NUMERAL ONE
 *								ⅱ 0xEEF0		0x2171	#SMALL ROMAN NUMERAL TWO
 *								ⅲ 0xEEF1		0x2172	#SMALL ROMAN NUMERAL THREE
 *								ⅳ 0xEEF2		0x2173	#SMALL ROMAN NUMERAL FOUR
 *								ⅴ 0xEEF3		0x2174	#SMALL ROMAN NUMERAL FIVE
 *								ⅵ 0xEEF4		0x2175	#SMALL ROMAN NUMERAL SIX
 *								ⅶ 0xEEF5		0x2176	#SMALL ROMAN NUMERAL SEVEN
 *								ⅷ 0xEEF6		0x2177	#SMALL ROMAN NUMERAL EIGHT
 *								ⅸ 0xEEF7		0x2178	#SMALL ROMAN NUMERAL NINE
 *								ⅹ 0xEEF8		0x2179	#SMALL ROMAN NUMERAL TEN
 *								   0xFA40		0x2170	#SMALL ROMAN NUMERAL ONE
 *								   0xFA41		0x2171	#SMALL ROMAN NUMERAL TWO
 *								   0xFA42		0x2172	#SMALL ROMAN NUMERAL THREE
 *								   0xFA43		0x2173	#SMALL ROMAN NUMERAL FOUR
 *								   0xFA44		0x2174	#SMALL ROMAN NUMERAL FIVE
 *								   0xFA45		0x2175	#SMALL ROMAN NUMERAL SIX
 *								   0xFA46		0x2176	#SMALL ROMAN NUMERAL SEVEN
 *								   0xFA47		0x2177	#SMALL ROMAN NUMERAL EIGHT
 *								   0xFA48		0x2178	#SMALL ROMAN NUMERAL NINE
 *								   0xFA49		0x2179	#SMALL ROMAN NUMERAL TEN
 *								   0xFA4A		0x2160	#ROMAN NUMERAL ONE
 *								   0xFA4B		0x2161	#ROMAN NUMERAL TWO
 *								   0xFA4C		0x2162	#ROMAN NUMERAL THREE
 *								   0xFA4D		0x2163	#ROMAN NUMERAL FOUR
 *								   0xFA4E		0x2164	#ROMAN NUMERAL FIVE
 *								   0xFA4F		0x2165	#ROMAN NUMERAL SIX
 *								   0xFA50		0x2166	#ROMAN NUMERAL SEVEN
 *								   0xFA51		0x2167	#ROMAN NUMERAL EIGHT
 *								   0xFA52		0x2168	#ROMAN NUMERAL NINE
 *								   0xFA53		0x2169	#ROMAN NUMERAL TEN
 *
 * 2018/05/03 A.TSURUDA	 UTF-8 to iso8859-1 変換追加
 * -------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.utils;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 文字列エンコーディング用ユーティリティークラス
 */
public class StringEncoder {

	private static final Log log = LogFactory.getLog(StringEncoder.class);

	private final static String ENCODING_CHAR_SET = "windows-31j";

	/**
	 * This method convert Shift_JIS to Cp932(Windows-31J).
	 *
	 * @param s 変換前の文字列
	 * @return 変換後の文字列
	 */
	public static String toCp932(String s) {
		if (s == null) {
			return "";
		}

		StringBuffer sb = new StringBuffer();

		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);

			switch (c) {
			case 0x301c: // FULLWIDTH TILDE ->
				c = 0xff5e; // WAVE DASH
				break;
			case 0x2016: // PARALLEL TO ->
				c = 0x2225; // DOUBLE VERTICAL LINE
				break;
			case 0x2212: // FULLWIDTH HYPHEN-MINUS ->
				c = 0xff0d; // MINUS SIGN
				break;
			case 0x00a2: // FULLWIDTH CENT SIGN ->
				c = 0xffe0; // CENT SIGN
				break;
			case 0x00a3: // FULLWIDTH POUND SIGN ->
				c = 0xffe1; // POUND SIGN
				break;
			case 0x00ac: // FULLWIDTH NOT SIGN ->
				c = 0xffe2; // NOT SIGN
				break;
			}

			sb.append(c);
		}

		return new String(sb);
	}

	/**
	 * UTF-8 to iso8859-1 変換
	 * Convert UTF-8 to iso8859-1
	 * 
	 * @param s 変換前の文字列
	 * @return 変換後の文字列
	 */
	public static String toISO8859(String s) {
		String result = null;
		try {
	        result = new String(s.getBytes("UTF-8"),"iso-8859-1");
	    }
	    catch(Exception e) {
			System.out.println(e);
			log.error(e.getMessage()); 
			// ダミーでファイル名を作成
			String[] arrayStr = s.split(".");
			// 拡張子があればつける
			result = "filename";
			if(arrayStr.length > 1) {
				result += "." + arrayStr[arrayStr.length - 1];
			}
	    }
		return result;
	}


	/**
	 * エンコード処理
	 *
	 * @param 	str   エンコード前の文字列
	 * @return temp  エンコードされた文字列
	 */
	public static String encodeString(String str) throws Exception{
		String temp = new String();
		try {
			if (str != null && !"".equals(str)){
				temp =  URLEncoder.encode(str,ENCODING_CHAR_SET);
			}
		} catch (UnsupportedEncodingException e) {
			throw e;
		}
		return temp;
	}

}
