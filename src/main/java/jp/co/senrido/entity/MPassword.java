/**
 * 
 */
package jp.co.senrido.entity;

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
@Entity(listener = MPasswordListener.class)
@Table(name = "m_password")
@Data
public class MPassword {

	/** ユーザーコード */
	@Id
	@Column(name = "user_cd")
	String userCd;

	/** パスワード */
	@Column(name = "password")
	String password;

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
