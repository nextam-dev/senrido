package com.makino_saiten.goitai.common;

import java.util.ResourceBundle;

/**
 *
 * リソースファイル読み込みクラス.
 *
 * @author t_hirose
 * @version 2018/06/11
 */
public class GoitaiResources {

	/**
	 * 指定したキー情報の文字列を取得する処理.
	 *
	 * @param filename
	 * @param key
	 * @return String
	 */
	public static String getString(String filename, String key) {
		return ResourceBundle.getBundle(filename).getString(key);
	}
}
