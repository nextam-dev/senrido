package jp.co.senrido.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.senrido.entity.MPassword;

/**
 */
@Dao
@ConfigAutowireable
public interface MPasswordDao {
	/**
	 * @param userCd
	 * @return the MEmployee entity
	 */
	@Select
	MPassword selectById(String userCd);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(MPassword entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(MPassword entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(MPassword entity);
}