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

import jp.co.senrido.entity.TEyePosition;

/**
 * @author takam
 *
 */
@Dao
@ConfigAutowireable
public interface TEyePositionDao {
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TEyePosition> selectById(Integer id);

	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	TEyePosition selectByDto(Integer id, LocalDateTime visitDate);
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TEyePosition> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(TEyePosition entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(TEyePosition entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(TEyePosition entity);
}
