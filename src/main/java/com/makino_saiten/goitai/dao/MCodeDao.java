package com.makino_saiten.goitai.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.makino_saiten.goitai.entity.MCode;

/**
 */
@Dao
@ConfigAutowireable
public interface MCodeDao {

	/**
	 * 主キー検索
	 *
	 * @param divCode
	 * @param code
	 * @return the MCode entity
	 */
	@Select
	MCode selectById(String divCode, String code);

	/**
	 * 区分コード検索
	 *
	 * @param divCode
	 * @return the MCode entity
	 */
	@Select
	List<MCode> selectByDivCode(String divCode);

	/**
	 * 区分コード検索（降順）
	 *
	 * @param divCode
	 * @return the MCode entity
	 */
	@Select
	List<MCode> selectByDivCodeDesc(String divCode);

	/**
	 * コード名称曖昧検索
	 *
	 * @param divCode
	 * @param code
	 * @param name
	 * @return
	 */
	@Select
	List<MCode> selectByDivCodeName(String divCode, String code, String name);

	/**
	 * 区分コード検索
	 *
	 * @param divCode
	 * @param divName
	 * @return the MCode entity
	 */
	@Select
	List<MCode> selectByDivCodeAndDivName(String divCode, String divName);

	/**
	 * コード引当
	 *
	 * @param divCode
	 * @param code
	 * @return
	 */
	@Select
	MCode selectByDivCodeAllocation(String divCode, String code);

}