package jp.nextam.senrido.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.nextam.senrido.entity.MHaichiEmployee;

/**
 */
@Dao
@ConfigAutowireable
public interface MHaichiEmployeeDao {

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(MHaichiEmployee entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(MHaichiEmployee entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(MHaichiEmployee entity);

}