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

import jp.co.senrido.entity.TPastMedicalHistory;

/**
 * @author takam
 *
 */
@Dao
@ConfigAutowireable
public interface TPastMedicalHistoryDao {
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TPastMedicalHistory> selectById(Integer id);
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	TPastMedicalHistory selectByDto(Integer id, LocalDateTime visitDate);

	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TPastMedicalHistory> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(TPastMedicalHistory entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(TPastMedicalHistory entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(TPastMedicalHistory entity);
}
