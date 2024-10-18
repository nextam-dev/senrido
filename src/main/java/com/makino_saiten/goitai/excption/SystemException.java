/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：SystemException.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.excption;

/**
 * 
 * システム例外
 *
 */
public class SystemException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * デフォルトコンストラクタ
	 *
	 * @param t 例外情報
	 */
	public SystemException() {
		super();
	}

	/**
	 * コンストラクタ
	 *
	 * @param message メッセージ
	 */
	public SystemException(String message) {
		super(message);
	}

	/**
	 * コンストラクタ
	 *
	 * @param message メッセージ
	 * @param t 例外情報
	 */
	public SystemException(String message, Throwable t) {
		super(message, t);
	}
}
