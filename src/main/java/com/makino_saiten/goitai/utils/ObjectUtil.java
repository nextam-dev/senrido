/* =============================================================
 * システム名：武蔵野マイページシステム
 * ファイル名：ObjectUtils.java
 * --------------------------------------------------------------
 */
package com.makino_saiten.goitai.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;

import com.makino_saiten.goitai.common.GoitaiConstant;
import com.makino_saiten.goitai.excption.SystemException;

/**
 * オブジェクト操作に関するユーティリティークラス.
 *
 * @author t_hirose
 * @version 2018/05/23
 *
 *
 */
public class ObjectUtil {

	/**
	 * 引数の文字列に該当する要素の値を取得します。
	 *
	 * <pre>
	 * org.apache.commons.beanutils.PropertyUtils#getPropertyメソッドのラッパーです。
	 * </pre>
	 *
	 * @param bean オブジェクト
	 * @param name 要素名
	 * @return 取得した値
	 */
	public static Object getProperty(Object bean, String name) {
		try {
			return PropertyUtils.getProperty(bean, name);
		} catch (Exception e) {
			throw new SystemException("エラーが発生しました。", e);
		}
	}

	/**
	 * 全ての要素をコピーします。
	 *
	 * <pre>
	 * org.apache.commons.beanutils.PropertyUtils#copyPropertiesメソッドのラッパーです。
	 * １階層目のStringやプリミティブは値コピーですが、クラスはアドレスコピーです。
	 * 利用時はご注意ください。
	 * </pre>
	 *
	 * @param dest コピー先オブジェクト
	 * @param orig コピー元オブジェクト
	 */
	public static void copyPropertis(Object dest, Object orig) {
		try {
			PropertyUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new SystemException("エラーが発生しました。", e);
		}
	}

	/**
	 * リストの詰め替え処理.
	 *
	 * @param in
	 * @param type
	 * @return
	 */
	public static <T, U> List<U> copyList(List<T> dest, Class<U> orig) {
		List<U> out = new ArrayList<U>();
		try {
			for (T t : dest) {
				U u = orig.newInstance();
				BeanUtils.copyProperties(t, u);
				out.add(u);
			}
		} catch (InstantiationException e) {
			throw new IllegalArgumentException(e);
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException(e);
		}

		return out;
	}

	/**
	 * リストの詰め替え処理.
	 *
	 * @param in
	 * @param type
	 * @return
	 */
	public static <T, U> List<U> copyListFormToDto(List<T> dest, Class<U> orig) {
		List<U> out = new ArrayList<U>();
		try {
			for (T t : dest) {
				U u = orig.newInstance();
				com.makino_saiten.goitai.utils.BeanUtils.copy(t, u);
				out.add(u);
			}
		} catch (InstantiationException e) {
			throw new IllegalArgumentException(e);
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException(e);
		} catch (Throwable e) {
			throw new IllegalArgumentException(e);
		}

		return out;
	}

	/**
	 * リストの詰め替え処理.
	 *
	 * @param String型リスト
	 * @return Integer型リスト
	 */
	public static List<Integer> copyListAsIntegerList(List<String> stringList) {
		List<Integer> list = new ArrayList<Integer>();
		for (String str : stringList) {
			list.add(Integer.valueOf(str));
		}
		return list;
	}

	/**
	 * セットをリストに詰め替え処理.
	 *
	 * @param String型セット
	 * @return String型リスト
	 */
	public static List<String> copyStringSetAsStringList(Set<String> stringSet) {
		List<String> list = new ArrayList<String>();
		String[] ss = stringSet.toArray(new String[] {});
		for (String str : ss) {
			list.add(str);
		}
		return list;
	}

	/**
	 * ２つのリストをマージして、重複した値を削除したリストを返却する.
	 *
	 * @param list
	 * @param margeList
	 * @return List<String>
	 */
	public static <T> List<T> margeStringList(List<T> list, List<T> margeList) {
		if (list == null && margeList == null) {
			return new ArrayList<T>();
		}
		if (list == null) {
			list = margeList;
		}
		if (margeList != null) {
			for (T str : margeList) {
				list.add(str);
			}
		}

		// 重複を削除
		return list.stream().distinct().collect(Collectors.toList());
	}

	/**
	 * 文字列リストをカンマ区切りの文字列に変換する.
	 *
	 * @param list
	 * @return String
	 */
	public static String editStringListToKanmaString(List<String> list) {
		if (list == null) {
			return null;
		}
		return String.join(GoitaiConstant.HALF_CAMMA, list);
	}

	/**
	 * 文字列配列をカンマ区切りの文字列に変換する.
	 *
	 * @param list
	 * @return String
	 */
	public static String editStringListToKanmaString(String[] list) {
		if (list == null) {
			return null;
		}
		return String.join(GoitaiConstant.HALF_CAMMA, Arrays.asList(list));
	}

	/**
	 * 文字列リストをカンマ区切りの文字列に変換する.
	 *
	 * @param list
	 * @return String
	 */
	public static String editStringListToAllKanmaString(List<String> list) {
		if (list == null) {
			return null;
		}
		return String.join(GoitaiConstant.ALL_CAMMA, list);
	}

	/**
	 * 文字列配列をカンマ区切りの文字列に変換する.
	 *
	 * @param list
	 * @return String
	 */
	public static String editStringListToAllKanmaString(String[] list) {
		if (list == null) {
			return null;
		}
		return String.join(GoitaiConstant.ALL_CAMMA, Arrays.asList(list));
	}
}