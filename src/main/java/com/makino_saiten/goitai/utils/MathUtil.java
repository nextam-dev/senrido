/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：MathUtil.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.utils;

import java.math.BigDecimal;

public class MathUtil {

	/**
	 * 消費税計算(四捨五入)
	 *
	 * @param orderCost
	 * @param amount
	 * @param tax
	 * @param taxFreeFlg
	 * @return
	 */
	public static BigDecimal calcSalesTax(BigDecimal cost, BigDecimal amount, BigDecimal tax, Boolean taxFreeFlg) {
		BigDecimal salesTax = new BigDecimal(0);
		BigDecimal dev = new BigDecimal(100);
		if (taxFreeFlg == false) {
			salesTax = (cost.multiply(tax)).divide(dev);
		}
		//2020.0203 切り捨てに変更 from 佐久間様
		//return salesTax.setScale(0, BigDecimal.ROUND_HALF_UP);
		//2022.0914 ４捨５入に変更 from 建石様
		//return salesTax.setScale(0, BigDecimal.ROUND_DOWN);
		return salesTax.setScale(0, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 消費税計算(切捨)
	 *
	 * @param orderCost
	 * @param amount
	 * @param tax
	 * @param taxFreeFlg
	 * @return
	 */
	public static BigDecimal calcSalesTaxRoundDown(BigDecimal cost, BigDecimal amount, BigDecimal tax, Boolean taxFreeFlg) {
		BigDecimal salesTax = new BigDecimal(0);
		BigDecimal dev = new BigDecimal(100);
		if (taxFreeFlg == false) {
			salesTax = (cost.multiply(tax)).divide(dev);
		}
		return salesTax.setScale(0, BigDecimal.ROUND_DOWN);
	}

	/**
	 * 文字列→BigDecimal変換
	 *
	 * @param str
	 * @return
	 */
	public static BigDecimal parseBigDecimal(String str) {
		if (StringUtil.isEmpty(str)) {
			return null;
		}
		return new BigDecimal(str);
	}

	/**
	 * BigDecimal→文字列変換
	 *
	 * @param str
	 * @return
	 */
	public static String stringifyBigDecimal(BigDecimal num) {
		if (num == null) {
			return null;
		}
		return num.toPlainString();
	}

	/**
	 * NULL→BigDecimal 0変換
	 *
	 * @param val
	 * @return
	 */
	public static BigDecimal nvl(BigDecimal val) {
		if (val == null) {
			return new BigDecimal(0);
		}
		return val;
	}
}
