/**
 * 
 */
package jp.co.senrido.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Data;

/**
 * @author takam
 *
 */
@Entity(listener = MUserListener.class)
@Table(name = "m_user")
@Data
public class MUser {

	/** ユーザーコード */
	@Id
	@Column(name = "user_cd")
	String userCd;

	/** 氏名 */
	@Column(name = "name")
	String name;

	/** 氏名カナ */
	@Column(name = "kana")
	String kana;

	/** 性別 */
	@Column(name = "sex")
	String sex;

	/** 電話番号 */
	@Column(name = "telephone")
	String telephone;

	/** 店舗コード */
	@Column(name = "shop_cd")
	String shopCd;

	/** 表示順 */
	@Column(name = "disp_order")
	Integer dispOrder;

	/** 削除フラグ */
	@Column(name = "del_flg")
	Boolean delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	String createDate;

	/** 登録者コード */
	@Column(name = "create_id")
	String createId;

	/** 更新日時 */
	@Column(name = "update_date")
	String updateDate;

	/** 更新者コード */
	@Column(name = "update_id")
	String updateId;
}
