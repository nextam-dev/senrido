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

import jp.co.senrido.entity.TSurgery;
import jp.co.senrido.entity.TTrouble;

/**
 * @author takam
 *
 */
@Dao
@ConfigAutowireable
public interface TTroubleDao {
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TTrouble> selectById(Integer id);
	
	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	TTrouble selectByDto(Integer id, LocalDateTime visitDate);

	/**
	 * @return the TVisitingHospital entity List
	 */
	@Select
	List<TTrouble> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(TTrouble entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(TTrouble entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(TTrouble entity);
}
