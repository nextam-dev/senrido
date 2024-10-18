package jp.nextam.senrido.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.nextam.senrido.entity.MEmployee;
import jp.nextam.senrido.entity.MEmployeeExt;

/**
 */
@Dao
@ConfigAutowireable
public interface MEmployeeDao {

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

}