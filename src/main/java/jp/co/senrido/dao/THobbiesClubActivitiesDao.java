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

import jp.co.senrido.entity.THobbiesClubActivities;

/**
 * @author takam
 *
 */
@Dao
@ConfigAutowireable
public interface THobbiesClubActivitiesDao {
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<THobbiesClubActivities> selectById(Integer id);
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	THobbiesClubActivities selectByDto(Integer id, LocalDateTime visitDate);

	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<THobbiesClubActivities> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(THobbiesClubActivities entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(THobbiesClubActivities entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(THobbiesClubActivities entity);
}
