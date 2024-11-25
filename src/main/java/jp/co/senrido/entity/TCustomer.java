/**
 * 
 */
package jp.co.senrido.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.SequenceGenerator;
import org.seasar.doma.Table;

import lombok.Data;

/**
 * @author takam
 *
 */
@Entity(listener = TCustomerListener.class)
@Table(name = "t_customer")
@Data
public class TCustomer {

	/** お客様ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequence = "t_customer_id_seq")
	@Column(name = "id")
	Integer id;

	/** 顧客番号 */
	@Column(name = "customer_cd")
	String customerCd;

	/** お客様名 */
	@Column(name = "customer_name")
	String customerName;

	/** お客様名カナ */
	@Column(name = "customer_kana")
	String customerKana;

	/** 生年月日和暦年号 */
	@Column(name = "birthday_nengo")
	String birthdayNengo;

	/** 生年月日 */
	@Column(name = "birthday")
	LocalDateTime birthday;

	/** 性別 */
	@Column(name = "sex")
	String sex;

	/** 性別その他 */
	@Column(name = "sex_other")
	String sexOther;

	/** 郵便番号 */
	@Column(name = "zipcode")
	String zipcode;

	/** 都道府県 */
	@Column(name = "prefecture_cd")
	String prefectureCd;

	/** 住所 */
	@Column(name = "address")
	String address;

	/** 主連絡先区分 */
	@Column(name = "main_contact_type")
	String mainContactType;

	/** 電話番号 */
	@Column(name = "telephone")
	String telephone;

	/** 携帯電話番号 */
	@Column(name = "mobile_phone")
	String mobilePhone;

	/** 勤務先電話番号 */
	@Column(name = "work_phone")
	String workPhone;

	/** 担当者コード */
	@Column(name = "person_in_charge_cd")
	String personInChargeCd;

	/** 紹介者 */
	@Column(name = "referrer")
	String referrer;

	/** 職業 */
	@Column(name = "occupation")
	String occupation;

	/** メールアドレス */
	@Column(name = "mail")
	String mail;

	/** 次回来店日 */
	@Column(name = "next_visit_date")
	LocalDateTime nextVisitDate;

	/** 前回来店日 */
	@Column(name = "previous_visit_date")
	LocalDateTime previousVisitDate;

	/** 削除フラグ */
	@Column(name = "del_flg")
	Boolean delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	LocalDateTime createDate;

	/** 登録者コード */
	@Column(name = "create_id")
	String createId;

	/** 更新日時 */
	@Column(name = "update_date")
	LocalDateTime updateDate;

	/** 更新者コード */
	@Column(name = "update_id")
	String updateId;
}
