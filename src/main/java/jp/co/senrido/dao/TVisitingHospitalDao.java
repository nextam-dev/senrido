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

import jp.co.senrido.entity.TVisitingHospital;

/**
 * @author takam
 *
 */
@Dao
@ConfigAutowireable
public interface TVisitingHospitalDao {
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TVisitingHospital> selectById(Integer id, LocalDateTime visitDate);

	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TVisitingHospital> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(TVisitingHospital entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(TVisitingHospital entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(TVisitingHospital entity);
}
