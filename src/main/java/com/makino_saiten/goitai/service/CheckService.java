/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：CheckService.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.service;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.makino_saiten.goitai.excption.BusinessException;
import com.makino_saiten.goitai.utils.DateUtil;


@Service
public class CheckService {

	@Autowired
	MessageSource msg;

	/**
	 * LocalDate期間チェック（From>Toとなった場合、BusinessException）
	 * @param from
	 * @param to
	 * @param name
	 * @throws Throwable
	 */
	public Boolean checkLocalDateFromTo(LocalDate from, LocalDate to, Object[] name) {
		if (from != null && to != null) {
			if (from.equals(to)) {
				return true;
			}
			if (from.isAfter(to)) {
				BusinessException e = new BusinessException();
				e.addErrorMessage(msg.getMessage("validator.constraints.Period.message", name, Locale.JAPANESE));
				throw e;
			}
		}
		return true;
		
	}

	/**
	 * LocalDate期間チェック（From>Toとなった場合、BusinessException）
	 * @param strFrom
	 * @param strTo
	 * @param nameFrom
	 * @param nameTo
	 * @param name
	 * @throws Throwable
	 */
	public Boolean checkLocalDateFromTo(String strfrom, String strTo, Object[] nameFrom, Object[] nameTo , Object[] name) {
		LocalDate from = null;
		LocalDate to = null;
		try {
			from = DateUtil.changeFormatStrToLocalDate(strfrom);
			
		} catch (Exception e) {
			BusinessException ex = new BusinessException();
			ex.addErrorMessage(msg.getMessage("typeMismatch.java.util.Date.Hyphen", nameFrom, Locale.JAPANESE));
			throw ex;
		}
		try {
			to = DateUtil.changeFormatStrToLocalDate(strTo);
			
		} catch (Exception e) {
			BusinessException ex = new BusinessException();
			ex.addErrorMessage(msg.getMessage("typeMismatch.java.util.Date.Hyphen", nameTo, Locale.JAPANESE));
			throw ex;
		}
		
		if (from != null && to != null) {
			if (from.equals(to)) {
				return true;
			}
			if (from.isAfter(to)) {
				BusinessException e = new BusinessException();
				e.addErrorMessage(msg.getMessage("validator.constraints.Period.message", name, Locale.JAPANESE));
				throw e;
			}
		}
		return true;
		
	}
}
