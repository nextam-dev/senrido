package jp.co.senrido.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.senrido.entity.MUser;

/**
 */
@Dao
@ConfigAutowireable
public interface MUserDao {
	/**
	 * @param userCd
	 * @return the MUser entity
	 */
	@Select
	MUser selectById(String userCd);
	
	/**
	 * @param email
	 * @return the MUser entity
	 */
	@Select
	MUser selectByEmail(String email);

	/**
	 * @return the MUser entity List
	 */
	@Select
	List<MUser> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(MUser entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(MUser entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(MUser entity);
}