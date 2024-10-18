/**
 *
 */
package com.makino_saiten.goitai.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.makino_saiten.goitai.annotation.DatePattern;

/**
 * Beansに関するUtilクラス.
 *
 * @author takamasa
 *
 */
public class BeanUtils {

	/**
	 * JavaBeansの値からマップを作成します。
	 *
	 * @param src
	 *            ソース
	 * @return JavaBeansの値を持つマップ
	 */
	public static Map<String, Object> createProperties(Object src)
			throws Throwable {
		Map<String, Object> map = new HashMap<String, Object>();
		if (src == null) {
			return map;
		}
		// プロパティフィールドを取得
		final Field[] fields = src.getClass().getDeclaredFields();

		for (Field field : fields) {
			try {
				// Field名からgetメソッドを作成する
				Method method = null;
				try {
					String fieldName = field.getName();
					// 先頭を大文字に変換する
					fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
					method = src.getClass().getMethod("get" + fieldName);
				} catch (Exception e) {
					method = null;
				}
				if (method != null) {
					Object obj = method.invoke(src);
					map.put(field.getName(), obj);
				}

			} catch (Exception e) {
				throw e;
			}
		}
		return map;
	}

	/**
	 * JavaBeansからJavaBeansの該当プロパティに値を設定します。
	 *
	 * @param src
	 *            コピー元JavaBeans
	 * @param dest
	 *            コピー先JavaBeans
	 * @throws Throwable
	 */
	public static void copy(Object src, Object dest) throws Throwable {

		if (src == null || dest == null) {
			return;
		}

		// 一度コピー元オブジェクトをマップに変換
		Map<String, Object> map = createProperties(src);

		copy(map, src, dest);
	}

	/**
	 * MapからJavaBeansの該当プロパティに値を設定します。
	 *
	 * @param map
	 *            コピー元Map
	 * @param dest
	 *            コピー先JavaBeans
	 * @throws Throwable
	 */
	public static void copy(Map<String, Object> map, Object src, Object dest)
			throws Throwable {

		if (map == null || dest == null) {
			return;
		}

		// コピー先のプロパティフィールドを取得
		final Field[] fields = dest.getClass().getDeclaredFields();
		final Method[] methods = dest.getClass().getMethods();

		Field srcField = null;

		// Key名取得
		for (Field field : fields) {
			// Field名からgetメソッドを作成する
			Method method = null;
			try {
				String fieldName = field.getName();
				// 先頭を大文字に変換する
				fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				for (Method mt : methods) {
					if (Objects.equals(mt.getName(), "set" + fieldName)) {
						method = mt;
						break;
					}
				}
			} catch (Exception e) {
				method = null;
			}
			if (method != null) {
				String pattern = null;
				try {
					srcField = src.getClass().getDeclaredField(field.getName());
				} catch (Exception e) {
					srcField = null;
				}
				if (srcField != null) {
					// コピー元側のフィールドを参照する
					if (srcField != null) {
						// 日付アノテーションが付与されている場合は、フォーマットを取得する
						if (srcField.isAnnotationPresent(DatePattern.class)) {
							DatePattern datePattern = srcField.getAnnotation(DatePattern.class);
							pattern = datePattern.pattern();
						}
					}
					method.invoke(dest, convObject(map.get(field.getName()), field
							.getType().getName(), pattern));
				}
			}
		}
	}

	/**
	 * 変換対象のオブジェクト object を convClassName の型へ変換します。
	 *
	 * @param object
	 *            変換対象のオブジェクト
	 * @param convClassName
	 *            変換する型のクラス文字列
	 * @param pattern
	 *            日付パターン
	 * @return 変換されたオブジェクト
	 */
	private static Object convObject(Object object, String convClassName, String pattern) throws Throwable {
		if (object == null) {
			// プリミティブな型への変換はnullで返すとエラーになる。
			// 0のラッパーにする。
			if (convClassName.equals("int")) {
				return new Integer(0);
			} else if (convClassName.equals("long")) {
				return new Long(0);
			} else {
				return null;
			}
		}
		if (object.getClass().getName().equals(convClassName)) {
			return object;
		}

		// ----------------------------------------『 object instanceof String 』
		if (object instanceof String) {
			if (convClassName.equals("java.lang.String")) {
				return object;
			} else if (convClassName.equals("java.lang.Long")
					|| convClassName.equals("long")) {
				String str = (String) object;
				if (StringUtil.isExist(str)) {
					// 一度BigDecimalに変換しないと具合が悪い
					// 1000.00000
					BigDecimal big = new BigDecimal(str);
					return new Long(big.longValue());
				} else {
					// str が殻リテラルの場合は初期値の"0"を
					return new Long(0);
				}
			} else if (convClassName.equals("java.sql.Date")) {
				return StringUtil.toSqlDate((String) object);
			} else if (convClassName.equals("java.sql.Timestamp")) {
				java.sql.Date date = StringUtil.toSqlDate((String) object);
				return new Timestamp(date.getTime());
			} else if (convClassName.equals("java.time.LocalDateTime")) {
				return DateUtil.changeStrToLocalDateTime((String) object);
			} else if (convClassName.equals("java.time.LocalDate")) {
				return DateUtil.changeFormatStrToLocalDate((String) object);
			} else if (convClassName.equals("java.time.LocalTime")) {
//				return DateUtil.changeStrToLocalTime((String) object);
				return (String) object != null && !((String) object).isEmpty() ? LocalTime.parse((String) object) : null;
			} else if (convClassName.equals("java.lang.Integer")
					|| convClassName.equals("int")) {
				// str が殻リテラルの場合は初期値の"0"を
				String str = (String) object;
				if (StringUtil.isExist(str)) {
					BigDecimal big = new BigDecimal(str);
					return new Integer(big.intValue());
				} else {
					return new Integer(0);
				}
			} else if (convClassName.equals("java.lang.Boolean")) {
				return Boolean.valueOf(object.toString());
			} else if (convClassName.equals("java.math.BigDecimal")) {
				String temp = ((String) object).trim();
				// temp.length() == 0の場合0ではなくnullにするのが無難。
				if (temp.length() == 0) {
					return null;
				} else {
					return new BigDecimal(temp);
				}
			}
			throwNoSupprt(object, convClassName);
		}

		// ---------------------------------『 object instanceof java.sql.Date 』
		else if (object instanceof java.sql.Date) {

			if (convClassName.equals("java.lang.String")) {
				return StringUtil.toStringDate((java.sql.Date) object,
						"yyyy/MM/dd");
			} else if (convClassName.equals("java.sql.Date")) {
				return object;
			} else if (convClassName.equals("java.sql.Timestamp")) {
				return new Timestamp(((Date) object).getTime());
			} else if (convClassName.equals("java.time.LocalDateTime")) {
				String strDate = DateUtil.changeFormat((Date) object, pattern);
				return DateUtil.changeFormatStrToLocalDateTime(strDate, pattern);
			}
			throwNoSupprt(object, convClassName);
		}

		// -------------------------------------『 object instanceof Timestamp 』
		else if (object instanceof Timestamp) {
			long time = ((Timestamp) object).getTime();
			if (convClassName.equals("java.lang.String")) {
				return StringUtil.toStringDate(time, "yyyy/MM/dd HH:mm:ss");
			} else if (convClassName.equals("java.sql.Date")) {
				return new java.sql.Date(time);
			} else if (convClassName.equals("java.sql.Timestamp")) {
				return object;
			} else if (convClassName.equals("java.time.LocalDateTime")) {
				String strDate =  StringUtil.toStringDate(time, "yyyy/MM/dd HH:mm:ss");
				return DateUtil.changeFormatStrToLocalDateTime(strDate, "yyyy/MM/dd HH:mm:ss");
			}
			throwNoSupprt(object, convClassName);
		}

		// -------------------------------------『 object instanceof Timestamp 』
		else if (object instanceof LocalDateTime) {
			LocalDateTime time = ((LocalDateTime) object);
			if (convClassName.equals("java.lang.String")) {
				return DateUtil.changeFormat(time, "yyyy/MM/dd HH:mm:ss");
			} else if (convClassName.equals("java.sql.Date")) {
				String str = DateUtil.changeFormat(time, "yyyy/MM/dd HH:mm:ss");
				return StringUtil.toSqlDate(str);
			} else if (convClassName.equals("java.sql.Timestamp")) {
				String str = DateUtil.changeFormat(time, "yyyy/MM/dd HH:mm:ss");
				Date date = StringUtil.toSqlDate(str);
				return new Timestamp(date.getTime());
			} else if (convClassName.equals("java.time.LocalDateTime")) {
				return time;
			}
			throwNoSupprt(object, convClassName);
		}

		// ----------------------------------------『 object instanceof Integer 』
		else if (object instanceof Integer) {
			if (convClassName.equals("java.lang.Integer")
					|| convClassName.equals("int")) {
				return object;
			} else if (convClassName.equals("java.lang.String")) {
				return object.toString();
			} else if (convClassName.equals("java.lang.Long")
					|| convClassName.equals("long")) {
				return new Long(((Integer) object).longValue());
			} else if (convClassName.equals("java.math.BigDecimal")) {
				return new BigDecimal(((Integer) object).intValue());
			}
			throwNoSupprt(object, convClassName);
		}

		// ------------------------------------------『 object instanceof Long 』
		else if (object instanceof Long) {
			if (convClassName.equals("java.lang.Long")
					|| convClassName.equals("long")) {
				return object;
			} else if (convClassName.equals("java.lang.String")) {
				return object.toString();
			} else if (convClassName.equals("java.lang.Integer")
					|| convClassName.equals("int")) {
				return new Integer(((Long) object).intValue());
			} else if (convClassName.equals("java.math.BigDecimal")) {
				return new BigDecimal(((Long) object).longValue());
			}
			throwNoSupprt(object, convClassName);
		}

		// ----------------------------------------『 object instanceof Double 』
		else if (object instanceof Double) {
			if (convClassName.equals("java.lang.String")) {
				// COLUMN NUMBER(8,0)
				// windows oracle > BigDecimal
				// UNIX oracle > Double
				BigDecimal big = new BigDecimal(((Double) object).doubleValue());
				int scale = big.scale();
				if (scale == 0) {
					return big.toString();
				} else {
					// 丸めが必要な場合はサポートしない。
					throwNoSupprt(object, convClassName);
				}
			}
			if (convClassName.equals("java.lang.Integer")
					|| convClassName.equals("int")) {
				return new Integer(((Double) object).intValue());
			} else if (convClassName.equals("java.lang.Long")
					|| convClassName.equals("long")) {
				return new Long(((Double) object).longValue());
			} else if (convClassName.equals("java.math.BigDecimal")) {
				return new BigDecimal(((Double) object).doubleValue());
			}
			throwNoSupprt(object, convClassName);
		}

		// ------------------------------------『 object instanceof BigDecimal 』
		else if (object instanceof BigDecimal) {
			if (convClassName.equals("java.lang.String")) {
				return object.toString();
			} else if (convClassName.equals("java.lang.Long")
					|| convClassName.equals("long")) {
				return new Long(((BigDecimal) object).longValue());
			} else if (convClassName.equals("java.lang.Integer")
					|| convClassName.equals("int")) {
				return new Integer(((BigDecimal) object).intValue());
			}
			throwNoSupprt(object, convClassName);
		}

		// ----------------------------------------『 object instanceof byte[] 』
		else if (object instanceof byte[]) {
			if (convClassName.equals("java.sql.Blob")) {
				return object;
			}
			throwNoSupprt(object, convClassName);
		}

		// ------------------------------------------------『 object が Boolean 』
		else if (object instanceof Boolean) {
			if (convClassName.equals("boolean")) {
				return object;
			}
			throwNoSupprt(object, convClassName);
		}

		// ----------------------------------------------『 object が boolean[] 』
		else if (object instanceof boolean[]) {
			if (convClassName.equals("java.lang.String")) {
				boolean[] bs = (boolean[]) object;
				StringBuffer buff = new StringBuffer("[");
				for (int i = 0; i < bs.length; i++) {
					buff.append(bs[i] + ",");
				}
				buff.deleteCharAt(buff.length() - 1);
				buff.append("]");
				return buff.toString();
			}
			throwNoSupprt(object, convClassName);
		}
		throwNoSupprt(object, convClassName);
		return null;

	}

	/**
	 * 変換がサポートされていない場合にスローします。
	 *
	 * @param object
	 *            変換対象のオブジェクト
	 * @param convClassName
	 *            変換する型
	 */
	private static void throwNoSupprt(Object object, String convClassName) {
		String className = (object != null) ? object.getClass().getName()
				: "null";
		String errorMess = "\nこのObjectの型変換処理はまだサポートされていません。\n"
				+ " [ Object ] = " + object + ",[ Objectの型 ] = " + className
				+ ",[ convertClass ] = " + convClassName + "";
		throw new UnsupportedOperationException(errorMess);
	}
}
