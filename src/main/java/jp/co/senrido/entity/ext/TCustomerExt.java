/**
 * 
 */
package jp.co.senrido.entity.ext;

import java.time.LocalDateTime;

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
	/** 店舗 */
	@Column(name = "shop_name")
	String shopName;

	/** 来店日（開始） */
	@Column(name = "visit_date_start")
	LocalDateTime visitDateStart;

	/** 来店日（終了） */
	@Column(name = "visit_date_end")
	LocalDateTime visitDateEnd;

	/** 担当者名 */
	@Column(name = "person_name")
	String personName;

	/** 時間枠 */
	@Column(name = "time_slot")
	String timeSlot;

	/** 性別 */
	@Column(name = "sex_name")
	String sexName;
}
