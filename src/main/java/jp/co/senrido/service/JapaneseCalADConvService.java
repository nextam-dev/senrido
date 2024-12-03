/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：JapaneseCalADConvService.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package jp.co.senrido.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import jp.co.senrido.common.SenridoConstant;
import jp.co.senrido.dao.MCodeDao;
import jp.co.senrido.entity.MCode;
import jp.co.senrido.excption.BusinessException;
import jp.co.senrido.utils.DateUtil;
import jp.co.senrido.utils.StringConvertUtil;

/**
 * 和暦→西暦、西暦→和暦変換サービス
 * （Javaでの実装もあるが、来年に元号が変わるのを考慮し自作）
 *
 * @author tsuruda
 *
 */
@Service
public class JapaneseCalADConvService {

	/** logger */
	private static final Log log = LogFactory.getLog(JapaneseCalADConvService.class);

	@Autowired
    private MCodeDao mCodeDao;

	/** */
	@Autowired
	private MessageSource msg;

	// コードマスタ上での年号変換年月日の区切りコード
	private final String SPLITTER = "/";

	private final String YEAR = "年 ";
	private final String MONTH = "月 ";
	private final String DATE = "日";

	/**
	 * 和暦(gg/mm/dd)から西暦(yyyy/mm/dd)への変換
	 * @param JapaneseCalDate
	 * @param WarekiCode
	 * @return
	 */
	public String japaneseCalToAd(String japaneseCalDate, String warekiCode) {

		if(japaneseCalDate == null || "".equals(japaneseCalDate)
				|| warekiCode == null || "".equals(warekiCode)) {
			return null;
		}
		// 主キー検索
		MCode mCode = mCodeDao.selectById(SenridoConstant.DivCode.DEV_CODE_WAREKI, warekiCode);
		String[] yyyymmdd = mCode.getName().split(SPLITTER);
		String[] ggmmdd = japaneseCalDate.split(SPLITTER);

		String adDate = null;
		try {
			String yyyy = StringConvertUtil.add(yyyymmdd[0], ggmmdd[0], "-1");
			adDate = yyyy + SPLITTER + ggmmdd[1] + SPLITTER + ggmmdd[2];
		}
		catch (Exception e) {
			log.error(e.getMessage());
			BusinessException be = new BusinessException();
			be.addErrorMessage(msg.getMessage("com.makinosaiten.hanako.businessError.EraAd", null, Locale.JAPAN));
			throw be;
		}
		return adDate;
	}

	/**
	 * 西暦(yyyy/mm/dd)から和暦([和暦コード,和暦年月日gg/mm/dd])への変換
	 * @param adDate
	 * @return
	 */
	public String[] adToJapaneseCal(String adDate) {
		List<MCode> mCodeList = mCodeDao.selectByDivCodeDesc(SenridoConstant.DivCode.DEV_CODE_WAREKI);
		String[] yyyymmdd = adDate.split(SPLITTER);
		String[] JapaneseDate = {"", ""};
		try {
			for(MCode mCode : mCodeList) {
				if (adDate.compareTo(mCode.getName()) >= 0) {
					String[] ggmmddBase = mCode.getName().split(SPLITTER);
					String gg = StringConvertUtil.add(yyyymmdd[0], "-" + ggmmddBase[0], "1");
					if (gg.length() == 1) {
						gg = "0" + gg;
					}
					JapaneseDate[0] = gg + SPLITTER + yyyymmdd[1] + SPLITTER + yyyymmdd[2];
					JapaneseDate[1] = mCode.getCode();
					return JapaneseDate;
				}
			}
		}
		catch (Exception e) {
			log.error(e.getMessage());
			BusinessException be = new BusinessException();
			be.addErrorMessage(msg.getMessage("com.makinosaiten.hanako.businessError.AdEra", null, Locale.JAPAN));
			throw be;
		}
		return JapaneseDate;
	}

	/**
	 * LocalDateから和暦([和暦コード,和暦年月日 元号 gg年 mm月 dd日])への変換
	 * @param adDate
	 * @return
	 */
	public String adToJapaneseCalWareki(LocalDate date) {
		List<MCode> mCodeList = mCodeDao.selectByDivCodeDesc(SenridoConstant.DivCode.DEV_CODE_WAREKI);
		String adDate =  DateUtil.changeFormat(date, DateUtil.DATE_FORMAT_YMD_SLASH);
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
					JapaneseDate = mCode.getGlassesFlame() + " " + gg + YEAR + yyyymmdd[1] + MONTH + yyyymmdd[2] + DATE;
					return JapaneseDate;
				}
			}
		}
		catch (Exception e) {
			log.error(e.getMessage());
			BusinessException be = new BusinessException();
			be.addErrorMessage(msg.getMessage("com.makinosaiten.hanako.businessError.AdEra", null, Locale.JAPAN));
			throw be;
		}
		return JapaneseDate;
	}

	/**
	 * LocalDateTimeから和暦([和暦コード,和暦年月日 元号 gg年 mm月 dd日])への変換
	 * @param adDate
	 * @return
	 */
	public String adToJapaneseCalWareki(LocalDateTime dateTime) {
		LocalDate date = LocalDate.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth());
		List<MCode> mCodeList = mCodeDao.selectByDivCodeDesc(SenridoConstant.DivCode.DEV_CODE_WAREKI);
		String adDate =  DateUtil.changeFormat(date, DateUtil.DATE_FORMAT_YMD_SLASH);
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
					JapaneseDate = mCode.getGlassesFlame() + " " + gg + YEAR + yyyymmdd[1] + MONTH + yyyymmdd[2] + DATE;
					return JapaneseDate;
				}
			}
		}
		catch (Exception e) {
			log.error(e.getMessage());
			BusinessException be = new BusinessException();
			be.addErrorMessage(msg.getMessage("com.makinosaiten.hanako.businessError.AdEra", null, Locale.JAPAN));
			throw be;
		}
		return JapaneseDate;
	}
}


