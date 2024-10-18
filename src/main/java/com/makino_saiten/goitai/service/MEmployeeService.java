/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：MEmployeeService.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makino_saiten.goitai.dao.MEmployeeDao;
import com.makino_saiten.goitai.entity.MEmployee;
import com.makino_saiten.goitai.entity.MEmployeeExt;
import com.makino_saiten.goitai.utils.DateUtil;

/**
 * 社員マスタサービス
 *
 * @author hosokawa
 *
 */
@Service
public class MEmployeeService {

	/** logger */
	private static final Log log = LogFactory.getLog(MEmployeeService.class);

	@Autowired
	MEmployeeDao mEmployeeDao;

	/**
	 * 社員全件取得
	 *
	 * @return
	 */
	public Map<String, String> selectAllEmployees() {
		Map<String, String> result = new LinkedHashMap<>();
		try {
			List<MEmployee> mEmployeeList = mEmployeeDao.selectAll();
			for (MEmployee mEmployee : mEmployeeList) {
				result.put(mEmployee.getEmployeeName(), mEmployee.getEmployeeCode());
			}
		} catch (Exception e) {
			log.error(e.toString());
			return null;
		}
		return result;
	}

	/**
	 * 社員マスタ取得
	 *
	 * @return
	 */
	public List<MEmployee> getMEmployee() {
		return mEmployeeDao.selectAll();
	}

	/**
	 * 退職者含む社員マスタ取得
	 *
	 * @return
	 */
	public List<MEmployee> getMEmployeeAll() {
		return mEmployeeDao.selectAll();
	}

	/**
	 * 社員マスタ（業務担当者）取得
	 *
	 * @return
	 */
	public List<MEmployee> getMEmployeeJob() {
		return mEmployeeDao.selectBySortOrder();
	}

	/**
	 * 社員マスタ（乗務利用社員）取得
	 *
	 * @return
	 */
	public List<MEmployee> getJomuUseEmployee() {
		return mEmployeeDao.selectByJomuUseEmployee();
	}

	/**
	 * 社員マスタ（略称が設定されているユーザの）取得
	 *
	 * @return
	 */
	public List<MEmployee> getMEmployeeAbbreviation(Integer orderNo, String wakeFuneralCategory) {
		return mEmployeeDao.selectByAbbreviation(orderNo,wakeFuneralCategory);
	}

	/**
	 * 社員マスタ（略称が設定されて、出勤予定のないいるユーザの）取得
	 *
	 * @return
	 */
	public List<MEmployee> getMEmployeeAbbreviationYmd(String ymd) throws ParseException {
		return mEmployeeDao.selectByAbbreviationYmd(DateUtil.toLocalDateTime(ymd, DateUtil.DATE_FORMAT_YMD_SLASH));
	}

	/**
	 * 従業員情報主キー検索（部門引当）
	 * @param employeeCode
	 * @return
	 */
	public MEmployeeExt getEmployeeExt(String employeeCode) {
		return mEmployeeDao.selectByIdExt(employeeCode);
	}

	/**
	 * 社員情報登録／更新
	 *
	 * @param mEmployee
	 * @param employeeName
	 * @throws ParseException
	 */
	public void sqlExecInsertEmployee(MEmployee mEmployee, String employeeName) throws ParseException {

		// 現在日時取得
		LocalDateTime localTimeNow = LocalDateTime.now();

		MEmployee tmpMEmployee = mEmployeeDao.selectById(mEmployee.getEmployeeCode());
		if (tmpMEmployee == null) {
			// 新規登録
			mEmployee.setCreateName(employeeName);
			mEmployee.setCreateDate(localTimeNow);
			mEmployee.setUpdateName(employeeName);
			mEmployee.setUpdateDate(localTimeNow);
			mEmployee.setDelFlg(false);
			mEmployeeDao.insert(mEmployee);

		} else {
			// 更新・削除
			mEmployee.setUpdateName(employeeName);
			mEmployee.setUpdateDate(localTimeNow);

			// 作成者・作成日を先祖返りさせる
			mEmployee.setCreateDate(tmpMEmployee.getCreateDate());
			mEmployee.setCreateName(tmpMEmployee.getCreateName());

			// del_flgがnullなら先祖返り
			if (mEmployee.getDelFlg() == null) {
				mEmployee.setDelFlg(tmpMEmployee.getDelFlg());
			}

			// パスワードが空なら先祖返り
			if (mEmployee.getPassword() == null || mEmployee.getPassword().isEmpty()) {
				mEmployee.setPassword(tmpMEmployee.getPassword());
			}

			mEmployeeDao.update(mEmployee);

		}

	}

}
