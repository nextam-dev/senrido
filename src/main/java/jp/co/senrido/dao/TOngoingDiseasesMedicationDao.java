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

import jp.co.senrido.entity.TOngoingDiseasesMedication;

/**
 * @author takam
 *
 */
@Dao
@ConfigAutowireable
public interface TOngoingDiseasesMedicationDao {
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TOngoingDiseasesMedication> selectById(Integer id);
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	TOngoingDiseasesMedication selectByDto(Integer id, LocalDateTime visitDate);

	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TOngoingDiseasesMedication> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(TOngoingDiseasesMedication entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(TOngoingDiseasesMedication entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(TOngoingDiseasesMedication entity);
}
