/**
 * 
 */
package jp.co.senrido.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.senrido.entity.TCustomer;
import jp.co.senrido.entity.ext.TCustomerExt;

/**
 * @author takam
 *
 */
@Dao
@ConfigAutowireable
public interface TCustomerDao {
	
	/**
	 * @return the TCustomer entity List
	 */
	@Select
	TCustomer selectById(Integer id);

	/**
	 * @return the TCustomer entity List
	 */
	@Select
	List<TCustomer> selectAll();
	
	/**
	 * @return the TCustomer entity List
	 */
	@Select
	Integer selectMaxId();

	/**
	 * @return the TCustomer entity List
	 */
	@Select
	TCustomerExt selectByTCustomerInfo(Integer id);
	
	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(TCustomer entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(TCustomer entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(TCustomer entity);
}
