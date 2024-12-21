/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：MCodeMasterService.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package jp.co.senrido.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import jp.co.senrido.common.SenridoConstant;
import jp.co.senrido.dao.MCodeDao;
import jp.co.senrido.dao.TCustomerDao;
import jp.co.senrido.dto.TCustomerSearchDto;
import jp.co.senrido.entity.MCode;
import jp.co.senrido.entity.ext.TCustomerExt;
import jp.co.senrido.utils.DateUtil;
import jp.co.senrido.utils.ObjectUtil;

/**
 * お客様情報検索サービスクラス.
 *
 * @author hirokawa
 *
 */
@Service
public class S005CustomerInformationSearchService extends BaseTransactionalService {

	@Autowired
	private TCustomerDao tCustomerDao;

	@Autowired
	private MCodeDao mCodeDao;


	/**
	 * 検索処理
	 *
	 * @return
	 */
	public List<TCustomerSearchDto> searchCustomerInfo(TCustomerSearchDto dto) throws Throwable {
		List<TCustomerSearchDto> tCustomerList = new ArrayList<>();

		// 検索されたお客様情報を取得
		List<TCustomerExt> entityList = tCustomerDao.selectCustomerById(dto);
		if (!ObjectUtils.isEmpty(entityList)) {
			tCustomerList = ObjectUtil.copyList(entityList, TCustomerSearchDto.class);
		}

		// データ整形
		for (TCustomerSearchDto customer : tCustomerList) {
		    // 前回来店日
		    if (!ObjectUtils.isEmpty(customer.getPreviousVisitDate())) {
		        // 和暦変換
		        customer.setPreviousVisitDateStr(
		            DateUtil.changeFormat(customer.getPreviousVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
		    }
		    // 次回来店日
		    if (!ObjectUtils.isEmpty(customer.getNextVisitDate())) {
		        // 和暦変換
		        customer.setNextVisitDateStr(
		            DateUtil.changeFormat(customer.getNextVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
		    }
//		    // 生年月日
//		    if (!ObjectUtils.isEmpty(customer.getBirthday())) {
//		        // 和暦変換
//		        customer.setBirthdayStr(
//		            DateUtil.changeFormat(customer.getBirthday(), DateUtil.DATE_FORMAT_YMD_JP));
//		    }
		    if (!ObjectUtils.isEmpty(customer.getBirthday())) {
		        // LocalDateとして誕生日を取得
		        LocalDateTime birthday = customer.getBirthday();

		        // 和暦変換を行う
		        List<MCode> mCodeList = mCodeDao.selectByDivCodeDesc(SenridoConstant.DivCode.DEV_CODE_WAREKI);
		        String birthdayStr = DateUtil.adToJapaneseCalWareki(birthday, mCodeList);

		        // 和暦変換後の日付をセット
		        customer.setBirthdayStr(birthdayStr);
		    }

		}
		return tCustomerList;
	}

	/**
	 * ソート処理
	 *
	 * @return
	 */
	public List<TCustomerSearchDto> sortCustomerInfo(TCustomerSearchDto dto, String conditions) throws Throwable {
		List<TCustomerSearchDto> tCustomerList = new ArrayList<>();

		// ソートされたお客様情報を取得
		List<TCustomerExt> entityList = tCustomerDao.selectSortById(dto);
		if (!ObjectUtils.isEmpty(entityList)) {
			tCustomerList = ObjectUtil.copyList(entityList, TCustomerSearchDto.class);
		}

		// データ整形
		for (TCustomerSearchDto customer : tCustomerList) {
		    // 前回来店日
		    if (!ObjectUtils.isEmpty(customer.getPreviousVisitDate())) {
		        // 和暦変換
		        customer.setPreviousVisitDateStr(
		            DateUtil.changeFormat(customer.getPreviousVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
		    }
		    // 次回来店日
		    if (!ObjectUtils.isEmpty(customer.getNextVisitDate())) {
		        // 和暦変換
		        customer.setNextVisitDateStr(
		            DateUtil.changeFormat(customer.getNextVisitDate(), DateUtil.DATE_FORMAT_YMD_SLASH));
		    }
		    // 生年月日
		    if (!ObjectUtils.isEmpty(customer.getBirthday())) {
		        // 和暦変換
		        customer.setBirthdayStr(
		            DateUtil.changeFormat(customer.getBirthday(), DateUtil.DATE_FORMAT_YMD_JP));
		    }
//		    if (!ObjectUtils.isEmpty(customer.getBirthday())) {
//		        // LocalDateとして誕生日を取得
//		        LocalDateTime birthday = customer.getBirthday();
//
//		        // 和暦変換を行う
//		        List<MCode> mCodeList = mCodeDao.selectByDivCodeDesc(SenridoConstant.DivCode.DEV_CODE_WAREKI);
//		        String birthdayStr = DateUtil.adToJapaneseCalWareki(birthday, mCodeList);
//
//		        // 和暦変換後の日付をセット
//		        customer.setBirthdayStr(birthdayStr);
//		    }

		}
		return tCustomerList;
	}
}
