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

import jp.co.senrido.entity.TUsageStatus;

/**
 * @author takam
 *
 */
@Dao
@ConfigAutowireable
public interface TUsageStatusDao {
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TUsageStatus> selectById(Integer id);
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	TUsageStatus selectByDto(Integer id, LocalDateTime visitDate);

	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TUsageStatus> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(TUsageStatus entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(TUsageStatus entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(TUsageStatus entity);
}
