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

import jp.co.senrido.entity.TSymptoms;

/**
 * @author takam
 *
 */
@Dao
@ConfigAutowireable
public interface TSymptomsDao {
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TSymptoms> selectById(Integer id);
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	TSymptoms selectByDto(Integer id, LocalDateTime visitDate);

	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TSymptoms> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(TSymptoms entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(TSymptoms entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(TSymptoms entity);
}
