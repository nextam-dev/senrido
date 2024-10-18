package com.makino_saiten.goitai.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import com.makino_saiten.goitai.entity.MEmployee;
import com.makino_saiten.goitai.entity.MEmployeeExt;

/**
 */
@Dao
@ConfigAutowireable
public interface MEmployeeDao {

	/**
	 * @param employeeCode
	 * @return the MEmployee entity
	 */
	@Select
	MEmployee selectById(String employeeCode);

	/**
	 * @return the MEmployee entity List
	 */
	@Select
	List<MEmployee> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(MEmployee entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(MEmployee entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(MEmployee entity);

	/**
	 *
	 * @param seq
	 * @return
	 */
	@Select
	List<MEmployee> selectEmpBySection(int seq);

	/**
	 * 主キー検索（部門名付)
	 *
	 * @param employeeCode
	 * @return
	 */
	@Select
	MEmployeeExt selectByIdExt(String employeeCode);

	/**
	 * 部門コード検索
	 *
	 * @param secCode
	 * @return
	 */
	@Select
	List<MEmployee> selectBySecCode(String secCode);

	/**
	 * 従業員番号検索
	 *
	 * @param secCode
	 * @return
	 */
	@Select
	List<MEmployee> selectByEmployeeNo(String employeeNo);

	/**
	 * 従業員（業務担当）情報取得
	 *
	 * @param secCode
	 * @return
	 */
	@Select
	List<MEmployee> selectBySortOrder();

	/**
	 * 従業員（乗務利用社員）情報取得
	 *
	 * @param secCode
	 * @return
	 */
	@Select
	List<MEmployee> selectByJomuUseEmployee();

	/**
	 * 未割り当て従業員一覧取得
	 * @param orderNo
	 * @param wakeFuneralCategory
	 * @return
	 */
	@Select
	List<MEmployee> selectUnassignedEmp(String orderNo, String wakeFuneralCategory);

	/**
	 * 従業員（略称があるユーザの）情報取得
	 *
	 * @param
	 * @return List<MEmployee>
	 */
	@Select
	List<MEmployee> selectByAbbreviation(Integer orderNo, String wakeFuneralCategory);

	/**
	 * 従業員（略称があり、指定された日に出勤していないユーザの）情報取得
	 *
	 * @param
	 * @return List<MEmployee>
	 */
	@Select
	List<MEmployee> selectByAbbreviationYmd(LocalDateTime workingDay);

}