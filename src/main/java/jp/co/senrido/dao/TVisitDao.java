/**
 * 
 */
package jp.co.senrido.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.senrido.entity.TVisit;

/**
 * @author takam
 *
 */
@Dao
@ConfigAutowireable
public interface TVisitDao {

	/**
	 * @return the TVisit entity List
	 */
	@Select
	List<TVisit> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(TVisit entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(TVisit entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(TVisit entity);
}
