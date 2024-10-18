/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：MCodeMasterService.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makino_saiten.goitai.dao.MCodeDao;
import com.makino_saiten.goitai.entity.MCode;

/**
 * コードマスタ取得サービス
 *
 * @author hirokawa
 *
 */
@Service
public class MCodeMasterService {

	@Autowired
	private MCodeDao mCodeDao;

	/**
	 * コードマスタ取得
	 *
	 * @param divCode
	 * @return
	 */
	public List<MCode> getMCode(String divCode) {
		return mCodeDao.selectByDivCode(divCode);
	}

	/**
	 * コードマスタ取得
	 *
	 * @param divCode
	 * @return
	 */
	public List<MCode> getMCodeDesc(String divCode) {
		return mCodeDao.selectByDivCodeDesc(divCode);
	}

	/**
	 * コードマスタ引当
	 *
	 * @param divCode
	 * @return
	 */
	public MCode getMCodeAllocation(String divCode, String code) {
		return mCodeDao.selectByDivCodeAllocation(divCode, code);
	}

	/**
	 * コードマスタ取得
	 *
	 * @param divCode
	 * @return
	 */
	public List<MCode> getMCodeDivName(String divCode, String divName) {
		return mCodeDao.selectByDivCodeAndDivName(divCode, divName);
	}

	/**
	 * コードマスタから指定コード、名称で曖昧検索
	 *
	 * @param devSubInroduce
	 * @param code
	 * @param name
	 * @return
	 */
	public List<MCode> getMCodeSearchSubInroduce(String divCode, String code, String name) {
		return mCodeDao.selectByDivCodeName(divCode, code, name);
	}
}
