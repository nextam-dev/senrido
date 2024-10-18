/**
 *
 */
package com.makino_saiten.goitai.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import org.springframework.util.ObjectUtils;

import com.makino_saiten.goitai.common.GoitaiConstant;
import com.makino_saiten.goitai.entity.MCode;

/**
 * <pre>
 * 日付に関するユーティリティークラス
 * </pre>
 *
 * @author T.Hirose
 * @version 1.0.0
 */
public class DateUtil {

	public final static String DATE_FORMAT_Y = "yyyy";
	public final static String DATE_FORMAT_M = "MM";
	public final static String DATE_FORMAT_D = "dd";
	public final static String DATE_FORMAT_YMD = "yyyyMMdd";
	public final static String DATE_FORMAT_YMD_SLASH = "yyyy/MM/dd";
	public final static String DATE_FORMAT_YMD_SLASH_OMIT = "yyyy/M/d";
	public final static String DATE_FORMAT_YMD_JP = "yyyy年MM月dd日";
	public final static String DATE_FORMAT_MD_JP = "MM月dd日";
	public final static String DATE_FORMAT_MD_JP_OMIT = "M月d日";
	public final static String DATE_FORMAT_MD_SLASH = "M/d";
	public final static String DATE_FORMAT_YMD_HYPHEN = "yyyy-MM-dd";
	public final static String DATE_FORMAT_YMDHHMM_SLASH = "yyyy/MM/dd HH:mm";
	public final static String DATE_FORMAT_YMDHHMM_HYPHEN = "yyyy-MM-dd HH:mm";
	public final static String DATE_FORMAT_TIMESTAMP = "yyyyMMddHHmmss";
	public final static String DATE_FORMAT_TIMESTAMP_SSS = "yyyyMMddHHmmssSSS";
	public final static String DATE_FORMAT_TIMESTAMP_SLASH = "yyyy/MM/dd HH:mm:ss";
	public final static String DATE_FORMAT_TIMESTAMP_HYPHEN = "yyyy-MM-dd HH:mm:ss";
	public final static String DATE_FORMAT_YMD_WAREKI = "Gyy年 MM月 dd日";
	public final static String DATE_FORMAT_GYYMD_WAREKI = "Gyy年M月d日";
	public final static String DATE_FORMAT_TIMESTAMP_WAREKI = "a hh時mm分";
	public final static String DATE_FORMAT_TIMESTAMP_WAREKI_NOTBLANK = "ahh時mm分";
	public final static String DATE_FORMAT_TIMESTAMP_WAREKI_OMIT = "a h時mm分";
	public final static String DATE_FORMAT_TIMESTAMP_WAREKI_OMIT_NOTBLANK = "ah時mm分";
	public final static String DATE_FORMAT_TIME_WAREKI = "HH時mm分";
	public final static String DATE_FORMAT_TIME_HH_MM = "HH:mm";
	public final static String DATE_FORMAT_TIME_HH_MM_OMIT = "H:mm";
	public final static String DATE_FORMAT_TIME_HH = "HH";

	// コードマスタ上での年号変換年月日の区切りコード
	private final static String SPLITTER = "/";
	private final static String YEAR = "年 ";
	private final static String MONTH = "月 ";
	private final static String DATE = "日";


	/**
	 * 現在年月日を指定のフォーマットで取得する
	 *
	 * @return 現在年月日
	 */
	public static String getSysdateFormat(String pattern) {

		SimpleDateFormat format = new SimpleDateFormat(pattern);

		return format.format(getCurrentDate());
	}

	/**
	 * 指定した年、月
	 * における月末日付を返します。
	 *
	 * @param year 対象の年
	 * @param month 対象の月
	 * @return 月末日付
	 */
	public static int getLastDay(String year, String month) {
	    int yyyy = Integer.parseInt(year);
	    int MM = Integer.parseInt(month);
	    int dd = 1;
	    Calendar cal = Calendar.getInstance();
	    cal.set(yyyy,MM-1,dd);
	    int last = cal.getActualMaximum(Calendar.DATE);
	    return last;
	}

	/**
	 * 指定した年月日の曜日を返します。
	 *
	 * @param dt
	 * @return
	 */
	public static String getWeek(Date dt) {
		if (dt == null) {
			return null;
		}

		String year = changeFormat(dt, DATE_FORMAT_Y);
		String month = changeFormat(dt, DATE_FORMAT_M);
		String day = changeFormat(dt, DATE_FORMAT_D);

		return getWeek(year, month, day);
	}

	/**
	 * 指定した年月日の曜日を返します。
	 *
	 * @param ymd
	 * @return
	 */
	public static String getWeek(String ymd) {
		if (StringUtil.isBlank(ymd)) {
			return null;
		}

		String str = ymd.replaceAll("/", "").replaceAll("-", "");
		if (str.length() != 8) {
			return null;
		}

		String year = str.substring(0, 4);
		String month = str.substring(4, 6);
		String day = str.substring(6, 8);

		return getWeek(year, month, day);
	}

	/**
	 * 指定した年月日の曜日を返します。
	 *
	 * @param year 対象の年
	 * @param month 対象の月
	 * @param day 対象の日
	 * @return 月末日付
	 */
	public static String getWeek(String year, String month, String day) {
	    int yyyy = Integer.parseInt(year);
	    int MM = Integer.parseInt(month);
	    int dd = Integer.parseInt(day);
	    Calendar cal = Calendar.getInstance();
	    cal.set(yyyy,MM-1,dd);
	    String yobi = null;
	    switch (cal.get(Calendar.DAY_OF_WEEK)) {
	    case Calendar.SUNDAY:
		    	yobi = "日";
		    	break;
	    	case Calendar.MONDAY:
		    	yobi = "月";
		    	break;
	    	case Calendar.TUESDAY:
		    	yobi = "火";
		    	break;
	    	case Calendar.WEDNESDAY:
		    	yobi = "水";
		    	break;
	    	case Calendar.THURSDAY:
		    	yobi = "木";
		    	break;
	    	case Calendar.FRIDAY:
		    	yobi = "金";
		    	break;
	    	case Calendar.SATURDAY:
		    	yobi = "土";
		    	break;
	    }
	    return yobi;
	}

	/**
     * 指定した年月日より、
     * パラメータ渡した引数の日数分移動した日付を
     * 指定フォーマット形式で返す。
     *
     * @param dt
	 * @param count
	 * @param pattern
	 * @return
	 */
	public static String addDate(Date dt, int count, String pattern) {
		String ymd = changeFormat(dt, DATE_FORMAT_YMD_SLASH);
		return addDate(ymd, count, pattern);
	}

    /**
     * 指定した年月日（yyyy/MM/dd形式）より、
     * パラメータ渡した引数の日数分移動した日付を
     * yyyy/MM/dd形式で返す。
     *
     * @param ymd 対象の年月日（yyyy/MM/dd形式）
     * @param count 日数
     * @return 月末日付
     */
    public static String addDate(String ymd, int count, String pattern) {
        if (ymd == null || ymd.length() != 10) {
            return null;
        }
        int yyyy = Integer.parseInt(ymd.substring(0,4));
        int MM = Integer.parseInt(ymd.substring(5,7));
        int dd = Integer.parseInt(ymd.substring(8));
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy,MM-1,dd);

        cal.add(Calendar.DAY_OF_MONTH, count);

        return changeFormat(cal.getTime(), pattern);
    }


	/**
	 * 現在日を java.util.Date オブジェクトTypeで取得する。
	 *
	 * @return java.util.Dateタイプの現在日
	 */
	public static Date getCurrentDate() {
		java.util.Calendar xcal = java.util.Calendar.getInstance();
		java.util.Date xday = xcal.getTime();
		return xday;
	}

	/**
	 * 区分記号で日付をフォーマットする。
	 *
	 * @param String 年月日 'yyyyMMdd'
	 * @param String 区分記号 ?
	 * @return String 'yyyy?MM?dd'
	 */
	public static String createFormatDate(String ymd, String kigou) {
		if (ymd == null) {
			return null;
		}

		String strYear = null;
		String strMonth = null;
		String strDate = null;

		strYear = ymd.substring(0, 4);
		strMonth = ymd.substring(4, 6);
		strDate = ymd.substring(6);

		return strYear + kigou + strMonth + kigou + strDate;
	}

	/**
	 * 日付Format
	 *
	 * @param date
	 * @return　ymd
	 */
	public static String changeFormat(Date date, String pattern) {
		if (date == null) {
			return null;
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		String ymd = dateFormat.format(date);

		return ymd;
	}

	/**
	 * 日付Format
	 *
	 * @param localTime
	 * @return　ymd
	 */
	public static String changeFormatLocalTime(LocalTime localTime, String pattern) {
		if (localTime == null) {
			return null;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String formattedTime = localTime.format(formatter);

		return formattedTime;
	}

	/**
	 * 日付Format
	 *
	 * @param localDateTime
	 * @return　ymd
	 */
	public static String changeFormatLocalDateTime(LocalDateTime localDateTime, String pattern) {
		if (localDateTime == null) {
			return null;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String formattedTime = localDateTime.format(formatter);

		return formattedTime;
	}

	/**
	 * 日付Format LocalDateTime変換
	 *
	 * @param str
	 * @return pattern
	 * @exception ParseException
	 */
	public static LocalDateTime changeStrToLocalDateTime(String str) throws ParseException {
		if (StringUtil.isEmpty(str)) {
	        return null;
	    }
	    return LocalDateTime.parse(str, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

	/**
	 * 日付Format LocalTime変換
	 *
	 * @param str
	 * @return pattern
	 * @exception ParseException
	 */
	public static LocalTime changeStrToLocalTime(String str) throws ParseException {
		try {
	        if (StringUtil.isEmpty(str)) {
	            return null;
	        }
	        return LocalTime.parse(str, DateTimeFormatter.ofPattern(DATE_FORMAT_TIME_HH_MM));
	    } catch (DateTimeParseException e) {
	        System.out.println("Failed to parse LocalTime: " + e.getMessage());
	        return null;
	    }
	}



	/**
	 * 日付Format LocalDateTime変換
	 *
	 * @param str
	 * @return pattern
	 * @exception ParseException
	 */
	public static LocalDateTime changeFormatStrToLocalDateTime(String str, String pattern) throws ParseException {
		Date date = changeFormatStrToDate(str, pattern);
		if (date == null) {
			return null;
		}
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}
	/**
	 * 日付Format LocalDate変換
	 *
	 * @param str
	 * @return pattern
	 * @exception ParseException
	 */
	public static LocalDate changeFormatStrToLocalDate(String str) throws ParseException {
		if (StringUtil.isEmpty(str)) {
			return null;
		}
		return LocalDate.parse(str, DateTimeFormatter.ISO_LOCAL_DATE);
	}
	/**
	 * 日付Format Date変換
	 *
	 * @param str
	 * @return pattern
	 * @exception ParseException
	 */
	public static Date changeFormatStrToDate(String str, String pattern) throws ParseException {

		if (StringUtil.isEmpty(str)) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.parse(str);
	}

	/**
	 * 2つの日付の差を求めます。
	 * 日付文字列 strDate1 - strDate2 が何日かを返します。
	 *
	 * @param strDate1    日付文字列 yyyy/MM/dd
	 * @param strDate2    日付文字列 yyyy/MM/dd
	 * @return    2つの日付の差
	 * @throws Throwble 日付フォーマットが不正な場合
	 */
	public static int differenceDays(String strDate1,String strDate2)
	    throws Throwable {
	    Date date1 = DateFormat.getDateInstance().parse(strDate1);
	    Date date2 = DateFormat.getDateInstance().parse(strDate2);
	    return differenceDays(date1,date2);
	}

	/**
	 * 2つの日付の差を求めます。
	 * java.util.Date 型の日付 date1 - date2 が何日かを返します。
	 *
	 * 計算方法は以下となります。
	 * 1.最初に2つの日付を long 値に変換します。
	 * 　※この long 値は 1970 年 1 月 1 日 00:00:00 GMT からの
	 * 　経過ミリ秒数となります。
	 * 2.次にその差を求めます。
	 * 3.上記の計算で出た数量を 1 日の時間で割ることで
	 * 　日付の差を求めることができます。
	 * 　※1 日 ( 24 時間) は、86,400,000 ミリ秒です。
	 *
	 * @param date1    日付 java.util.Date
	 * @param date2    日付 java.util.Date
	 * @return    2つの日付の差
	 */
	public static int differenceDays(Date date1,Date date2) {
	    long datetime1 = date1.getTime();
	    long datetime2 = date2.getTime();
	    long one_date_time = 1000 * 60 * 60 * 24;
	    long diffDays = (datetime1 - datetime2) / one_date_time;
	    return (int)diffDays;
	}

	/**
	 * 指定日より指定日分の日付情報を含んだモデルリストを作成
	 *
	 * @param sYmd
	 * @param eYmd
	 * @param pattern
	 * @return
	 */
	public static List<String> getOneWeekModelList(Date dt, int cnt, String pattern) {
		return getOneWeekModelList(changeFormat(dt, DATE_FORMAT_YMD_SLASH), cnt, pattern);
	}

	/**
	 * 指定日より指定日分の日付情報を含んだモデルリストを作成
	 *
	 * @param sYmd
	 * @param eYmd
	 * @param pattern
	 * @return
	 */
	public static List<String> getOneWeekModelList(String sYmd, int cnt, String pattern) {

		List<String> list = new ArrayList<String>();

		for (int i = 0; i <= cnt; i++) {
			String ymd = addDate(sYmd, i, pattern);
			list.add(ymd);
		}

		return list;
	}

	/**
	 * LocalDateTimeから指定された形式の文字列に変換
	 * @param updateDate
	 * @param dateFormatTimestampSlash
	 * @return
	 */
	public static String changeFormat(LocalDateTime dateTime, String format) {
		if(dateTime == null) {
			return "";
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		return dateTime.format(dtf);
	}

	/**
	 * LocalDateTimeから指定された形式の文字列に変換（LocalDateTimeがnullの場合、nullを返す）
	 *
	 * @param dateTime
	 * @param format
	 * @return
	 */
	public static String changeFormatNullCheck(LocalDateTime dateTime, String format) {
		if (dateTime == null) {
			return null;
		}
		return changeFormat(dateTime, format);
	}

	/**
	 * LocalTimeから指定された形式の文字列に変換（LocalDateTimeがnullの場合、nullを返す）
	 *
	 * @param dateTime
	 * @param format
	 * @return
	 */
	public static String changeFormatNullCheck(LocalTime dateTime, String format) {
		if (dateTime == null) {
			return null;
		}
		return changeFormat(dateTime, format);
	}

	/**
	 * 現在日時を java.time.LocalDateTime オブジェクトTypeで取得する。
	 *
	 * @return java.time.LocalDateTimeタイプの現在日時
	 * @throws ParseException
	 */
	public static LocalDateTime getCurrentLocalDateTime() throws ParseException {
		// 秒未満は切り捨てる
		LocalDateTime localDateTime = LocalDateTime.now();
		String str = changeFormat(localDateTime, DATE_FORMAT_TIMESTAMP_HYPHEN);
		return changeFormatStrToLocalDateTime(str, DATE_FORMAT_TIMESTAMP_HYPHEN);
	}

	/**
	 * 現在日付を java.time.LocalDate オブジェクトTypeで取得する。
	 *
	 * @return java.time.LocalDateタイプの現在日時
	 * @throws ParseException
	 */
	public static LocalDate getCurrentLocalDate() throws ParseException {
		return LocalDate.now();
	}

	/**
	 * LocalDateTimeからLocalDateに変換
	 *
	 * @param date
	 * @param format
	 * @return
	 */
	public static LocalDate changeLocalDate(LocalDateTime datetime) {
		return LocalDate.of(datetime.getYear(), datetime.getMonth(), datetime.getDayOfMonth());
	}

	/**
	 * LocalDateから指定された形式の文字列に変換
	 * @param date
	 * @param format
	 * @return
	 */
	public static String changeFormat(LocalDate date, String format) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		return date.format(dtf);
	}

	/**
	 * LocalTimeから指定された形式の文字列に変換
	 * @param date
	 * @param format
	 * @return
	 */
	public static String changeFormat(LocalTime date, String format) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		return date.format(dtf);
	}

	/**
	 * LocalDateから指定された形式の文字列に変換（LocalDateがnullの場合、nullを返す）
	 *
	 * @param date
	 * @param format
	 * @return
	 */
	public static String changeFormatNullCheck(LocalDate date, String format) {
		if (date == null) {
			return null;
		}
		return changeFormat(date, format);
	}

	/**
	 * 当月の月の先頭の日付（00:00:00）を返します.
	 * @param ymd
	 * @return
	 */
	public static Timestamp getFirstDayTimestamp(Timestamp ymd) {
		if (ymd == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(ymd.getTime());
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Timestamp ts = new Timestamp(cal.getTimeInMillis());
		return ts;
	}

	/**
	 * 指定した年月日の月の最後の日付（23:59:59）を返します.
	 * @param ymd
	 * @return
	 */
	public static Timestamp getLastDayTimestamp(Timestamp ymd) {
		if (ymd == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(ymd.getTime());
		cal.set(Calendar.DATE, 1);
	    int last = cal.getActualMaximum(Calendar.DATE);
		cal.set(Calendar.DATE, last);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 900);

		Timestamp ts = new Timestamp(cal.getTimeInMillis());
		return ts;
	}

	/**
     * 指定した年月日より、
     * パラメータ渡した引数の日数分移動した日付を
     * 指定フォーマット形式で返す。
     *
     * @param dt
	 * @param count
	 * @param pattern
	 * @return
	 */
	public static String getLastTimestamp(Date dt, int count, String pattern) {
		String ymd = changeFormat(dt, DATE_FORMAT_YMD_SLASH);
		return addDate(ymd, count, pattern);
	}

    /**
     * 指定した年月日（yyyy/MM/dd形式）最終時刻を返す
     * yyyy/MM/dd形式で返す。
     *
     * @param ymd 対象の年月日（yyyy/MM/dd形式）
     * @return 月末日付
     */
    public static String getLastTimestamp(String ymd, String pattern) {
        if (ymd == null || ymd.length() != 10) {
            return null;
        }
        int yyyy = Integer.parseInt(ymd.substring(0,4));
        int MM = Integer.parseInt(ymd.substring(5,7));
        int dd = Integer.parseInt(ymd.substring(8));
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy,MM-1,dd);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 900);

        return changeFormat(cal.getTime(), pattern);
    }

    /**
     * 指定した年月日（yyyy/MM/dd形式）最初の時刻を返す
     * yyyy/MM/dd形式で返す。
     *
     * @param ymd 対象の年月日（yyyy/MM/dd形式）
     * @return 月末日付
     */
    public static String getFirstTimestamp(String ymd, String pattern) {
        if (ymd == null || ymd.length() != 10) {
            return null;
        }
        int yyyy = Integer.parseInt(ymd.substring(0,4));
        int MM = Integer.parseInt(ymd.substring(5,7));
        int dd = Integer.parseInt(ymd.substring(8));
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy,MM-1,dd);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

        return changeFormat(cal.getTime(), pattern);
    }

	/**
	 * 指定した年月日の◯ヶ月前の月の先頭の日付（00:00:00）を返します.
	 * @param ymd
	 * @return
	 */
	public static Timestamp getAddMonthAgoFirstDayTs(Timestamp ymd,int addMonth) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(ymd.getTime());
		cal.add(Calendar.MONTH, addMonth);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Timestamp ts = new Timestamp(cal.getTimeInMillis());
		return ts;
	}

	/**
	 * 指定した年月日の日付（00:00:00）を返します.
	 * @param date
	 * @param format
	 * @return
	 */
    public static LocalDateTime toLocalDateTime(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date formatDate = sdf.parse(date);
        return LocalDateTime.ofInstant(formatDate.toInstant(), ZoneId.systemDefault());
    }

	/**
	 * LocalDateTimeから指定された形式の文字列に変換（和暦）
	 * @param date
	 * @param format
	 * @return
	 */
	public static String changeFormatWreki(LocalDateTime dateTime, String format) {
		Locale locale = new Locale("ja", "JP", "JP"); // バリアントを"JP"に指定してロケールを生成
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format, locale);
		return dateTime.format(dtf);
	}

	/**
	 * Stringから指定された形式の文字列に変換（和暦）
	 * @param date
	 * @param format
	 * @return
	 */
	public static String changeFormatWrekiTimeString(String timeString, String format) {
		Locale locale = new Locale("ja", "JP", "JP"); // バリアントを"JP"に指定してロケールを生成
		LocalTime time = LocalTime.parse(timeString, DateTimeFormatter.ofPattern(DATE_FORMAT_TIME_HH_MM));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format, locale);
		return time.format(dtf);
	}

	/**
	 * 日付Format
	 *
	 * @param date
	 * @return ymd
	 */
	public static LocalDateTime changeFormatDateToLocalDateTime(Date date) {
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		return LocalDateTime.ofInstant(instant, zone);
	}

	public static LocalDateTime changeFormatDateToLocalDateTime(java.sql.Date date) {
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		return LocalDateTime.ofInstant(instant, zone);
	}

	/**
	 * LocalDateから和暦([和暦コード,和暦年月日 元号 gg年 mm月 dd日])への変換
	 * @param adDate
	 * @param mCodeList
	 * @return
	 */
	public static String adToJapaneseCalWareki(LocalDate date, List<MCode> mCodeList) {
		String adDate =  DateUtil.changeFormat(date, DateUtil.DATE_FORMAT_YMD_SLASH_OMIT);
		String[] yyyymmdd = adDate.split(SPLITTER);
		String JapaneseDate = null;
		try {
			for(MCode mCode : mCodeList) {
				if (adDate.compareTo(mCode.getName()) >= 0) {
					String[] ggmmddBase = mCode.getName().split(SPLITTER);
					String gg = StringConvertUtil.add(yyyymmdd[0], "-" + ggmmddBase[0], "1");
					if(Objects.equals(gg, "1")) {
						gg = "元";
					}
					JapaneseDate = mCode.getDivName() + " " + gg + YEAR + yyyymmdd[1] + MONTH + yyyymmdd[2] + DATE;
					return JapaneseDate;
				}
			}
		}
		catch (Exception e) {
			return null;
		}
		return JapaneseDate;
	}

	/**
	 * LocalDateTimeから和暦([和暦コード,和暦年月日 元号 gg年 mm月 dd日])への変換
	 * @param adDate
	 * @param mCodeList
	 * @return
	 */
	public static String adToJapaneseCalWareki(LocalDateTime dateTime, List<MCode> mCodeList) {
		LocalDate date = LocalDate.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth());
		String adDate =  DateUtil.changeFormat(date, DateUtil.DATE_FORMAT_YMD_SLASH_OMIT);
		String[] yyyymmdd = adDate.split(SPLITTER);
		String JapaneseDate = null;
		try {
			for(MCode mCode : mCodeList) {
				if (adDate.compareTo(mCode.getName()) >= 0) {
					String[] ggmmddBase = mCode.getName().split(SPLITTER);
					String gg = StringConvertUtil.add(yyyymmdd[0], "-" + ggmmddBase[0], "1");
					if(Objects.equals(gg, "1")) {
						gg = "元";
					}
					JapaneseDate = mCode.getDivName() + " " + gg + YEAR + yyyymmdd[1] + MONTH + yyyymmdd[2] + DATE;
					return JapaneseDate;
				}
			}
		}
		catch (Exception e) {
			return null;
		}
		return JapaneseDate;
	}
//
//	/**
//	 * LocalDateから和暦([和暦コード,和暦年月日 元号 gg年])への変換
//	 * @param adDate
//	 * @param mCodeList
//	 * @return
//	 */
//	public static String adToJapaneseCalWarekiYear(LocalDate date, List<MCode> mCodeList) {
//		if(ObjectUtils.isEmpty(date)) {
//			return MitsumoriConstant.BLANK;
//		}
//		String adDate =  DateUtil.changeFormat(date, DateUtil.DATE_FORMAT_YMD_SLASH);
//		String[] yyyymmdd = adDate.split(SPLITTER);
//		String JapaneseDate = null;
//		try {
//			for(MCode mCode : mCodeList) {
//				if (adDate.compareTo(mCode.getName()) >= 0) {
//					String[] ggmmddBase = mCode.getName().split(SPLITTER);
//					String gg = StringConvertUtil.add(yyyymmdd[0], "-" + ggmmddBase[0], "1");
//					JapaneseDate = mCode.getDivName() + gg + YEAR;
//					return JapaneseDate;
//				}
//			}
//		}
//		catch (Exception e) {
//			return null;
//		}
//		return JapaneseDate;
//	}
//
//	/**
//	 * LocalDateTimeから和暦([和暦コード,和暦年月日 元号 gg年])への変換
//	 * @param adDate
//	 * @param mCodeList
//	 * @return
//	 */
//	public static String adToJapaneseCalWarekiYear(LocalDateTime dateTime, List<MCode> mCodeList) {
//		if(ObjectUtils.isEmpty(dateTime)) {
//			return MitsumoriConstant.BLANK;
//		}
//		LocalDate date = LocalDate.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth());
//		String adDate =  DateUtil.changeFormat(date, DateUtil.DATE_FORMAT_YMD_SLASH);
//		String[] yyyymmdd = adDate.split(SPLITTER);
//		String JapaneseDate = null;
//		try {
//			for(MCode mCode : mCodeList) {
//				if (adDate.compareTo(mCode.getName()) >= 0) {
//					String[] ggmmddBase = mCode.getName().split(SPLITTER);
//					String gg = StringConvertUtil.add(yyyymmdd[0], "-" + ggmmddBase[0], "1");
//					JapaneseDate = mCode.getDivName() + gg + YEAR;
//					return JapaneseDate;
//				}
//			}
//		}
//		catch (Exception e) {
//			return null;
//		}
//		return JapaneseDate;
//	}
//
//	/**
//	 * LocalDateTimeから元号への変換
//	 * @param adDate
//	 * @param mCodeList
//	 * @return
//	 */
//	public static String adToJapaneseCalGengo(LocalDateTime dateTime, List<MCode> mCodeList) {
//		if(ObjectUtils.isEmpty(dateTime)) {
//			return MitsumoriConstant.BLANK;
//		}
//		String JapaneseDate = null;
//		try {
//			for(MCode mCode : mCodeList) {
//				JapaneseDate = mCode.getDivName();
//				return JapaneseDate;
//			}
//		}
//		catch (Exception e) {
//			return null;
//		}
//		return JapaneseDate;
//	}
//
//	/**
//	 * LocalDateTimeから和暦([和暦コード,和暦年  gg年])への変換
//	 * @param adDate
//	 * @param mCodeList
//	 * @return
//	 */
//	public static String adToJapaneseCalYear(LocalDateTime dateTime, List<MCode> mCodeList) {
//		if(ObjectUtils.isEmpty(dateTime)) {
//			return MitsumoriConstant.BLANK;
//		}
//		LocalDate date = LocalDate.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth());
//		String adDate =  DateUtil.changeFormat(date, DateUtil.DATE_FORMAT_YMD_SLASH);
//		String[] yyyymmdd = adDate.split(SPLITTER);
//		String JapaneseDate = null;
//		try {
//			for(MCode mCode : mCodeList) {
//				if (adDate.compareTo(mCode.getName()) >= 0) {
//					String[] ggmmddBase = mCode.getName().split(SPLITTER);
//					String gg = StringConvertUtil.add(yyyymmdd[0], "-" + ggmmddBase[0], "1");
//					JapaneseDate = gg + YEAR;
//					return JapaneseDate;
//				}
//			}
//		}
//		catch (Exception e) {
//			return null;
//		}
//		return JapaneseDate;
//	}
//
//	/**
//	 * LocalDateTimeから和暦([和暦コード,和暦年  gg])への変換
//	 * @param adDate
//	 * @param mCodeList
//	 * @return
//	 */
//	public static String adToJapaneseCalY(LocalDateTime dateTime, List<MCode> mCodeList) {
//		if(ObjectUtils.isEmpty(dateTime)) {
//			return MitsumoriConstant.BLANK;
//		}
//		LocalDate date = LocalDate.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth());
//		String adDate =  DateUtil.changeFormat(date, DateUtil.DATE_FORMAT_YMD_SLASH);
//		String[] yyyymmdd = adDate.split(SPLITTER);
//		String JapaneseDate = null;
//		try {
//			for(MCode mCode : mCodeList) {
//				if (adDate.compareTo(mCode.getName()) >= 0) {
//					String[] ggmmddBase = mCode.getName().split(SPLITTER);
//					String gg = StringConvertUtil.add(yyyymmdd[0], "-" + ggmmddBase[0], "1");
//					JapaneseDate = gg;
//					return JapaneseDate;
//				}
//			}
//		}
//		catch (Exception e) {
//			return null;
//		}
//		return JapaneseDate;
//	}
//
//	/**
//	 * 受注No生成用
//	 *
//	 * @param orderDate
//	 * @return
//	 */
//	public static String searchYearMonthStr(LocalDate orderDate) {
//        // 現在の年を取得
//        int year = orderDate.getYear();
//
//        // 下2桁に変換
//        int lastTwoDigitsOfYear = year % 100;
//
//        // 現在の月を取得
//        int month = orderDate.getMonthValue();
//        int day = orderDate.getDayOfMonth();
//        // 8月以外は21日からが翌月扱い
//        if(!Objects.equals(month, 8) && day > 20) {
//        	month++;
//        }
//
//        // 結合して文字列を作成
//        return String.format("%02d%02d", lastTwoDigitsOfYear, month);
//    }

}
