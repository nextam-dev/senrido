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

import jp.co.senrido.entity.TGlassesUsage;

/**
 * @author takam
 *
 */
@Dao
@ConfigAutowireable
public interface TGlassesUsageDao {
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TGlassesUsage> selectById(Integer id);
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	TGlassesUsage selectByDto(Integer id, LocalDateTime visitDate);

	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TGlassesUsage> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(TGlassesUsage entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(TGlassesUsage entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(TGlassesUsage entity);
}
