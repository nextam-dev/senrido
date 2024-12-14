/**
 * 
 */
package jp.co.senrido.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.senrido.entity.TCriticalVisibilityNeeds;

/**
 * @author takam
 *
 */
@Dao
@ConfigAutowireable
public interface TCriticalVisibilityNeedsDao {
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TCriticalVisibilityNeeds> selectById(Integer id);
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	TCriticalVisibilityNeeds selectByDto(Integer id, LocalDateTime visitDate);

	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TCriticalVisibilityNeeds> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(TCriticalVisibilityNeeds entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(TCriticalVisibilityNeeds entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(TCriticalVisibilityNeeds entity);
}
