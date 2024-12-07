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

import jp.co.senrido.entity.TPrescribedLensStrength;

/**
 * @author takam
 *
 */
@Dao
@ConfigAutowireable
public interface TPrescribedLensStrengthDao {
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TPrescribedLensStrength> selectById(Integer id, LocalDateTime visitDate);

	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TPrescribedLensStrength> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(TPrescribedLensStrength entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(TPrescribedLensStrength entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(TPrescribedLensStrength entity);
}
