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

import jp.co.senrido.entity.TEyeUsageStatus;

/**
 * @author takam
 *
 */
@Dao
@ConfigAutowireable
public interface TEyeUsageStatusDao {
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TEyeUsageStatus> selectById(Integer id);
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	TEyeUsageStatus selectByDto(Integer id, LocalDateTime visitDate);

	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TEyeUsageStatus> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(TEyeUsageStatus entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(TEyeUsageStatus entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(TEyeUsageStatus entity);
}
