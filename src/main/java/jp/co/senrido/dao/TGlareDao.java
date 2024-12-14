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

import jp.co.senrido.entity.TGlare;

/**
 * @author takam
 *
 */
@Dao
@ConfigAutowireable
public interface TGlareDao {
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TGlare> selectById(Integer id);
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	TGlare selectByDto(Integer id, LocalDateTime visitDate);

	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TGlare> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(TGlare entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(TGlare entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(TGlare entity);
}
