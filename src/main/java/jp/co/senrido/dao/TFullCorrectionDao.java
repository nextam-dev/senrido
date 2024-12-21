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

import jp.co.senrido.entity.TFullCorrection;

/**
 * @author takam
 *
 */
@Dao
@ConfigAutowireable
public interface TFullCorrectionDao {
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TFullCorrection> selectById(Integer id);

	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	TFullCorrection selectByDto(Integer id, LocalDateTime visitDate);
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TFullCorrection> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(TFullCorrection entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(TFullCorrection entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(TFullCorrection entity);
}
