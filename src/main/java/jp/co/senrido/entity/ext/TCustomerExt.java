/**
 * 
 */
package jp.co.senrido.entity.ext;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

import jp.co.senrido.entity.TCustomer;
import lombok.Data;

/**
 * @author takam
 *
 */
@Entity(listener = TCustomerExtListener.class)
@Table(name = "t_customer_ext")
@Data
public class TCustomerExt  extends TCustomer {

	/** 性別 */
	@Column(name = "sex_name")
	String sexName;
}
