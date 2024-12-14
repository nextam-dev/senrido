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

import jp.co.senrido.entity.TOccupation;

/**
 * @author takam
 *
 */
@Dao
@ConfigAutowireable
public interface TOccupationDao {
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TOccupation> selectById(Integer id);

	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	TOccupation selectByDto(Integer id, LocalDateTime visitDate);
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TOccupation> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(TOccupation entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(TOccupation entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(TOccupation entity);
}
