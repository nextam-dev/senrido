package jp.co.senrido.entity;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import jp.co.senrido.validation.constraints.BiteSize;
import lombok.Data;

/**
 *
 */
@Entity(listener = MCodeListener.class)
@Table(name = "m_code")
@Data
public class MCode {

    /**  */
    @Id
    @Column(name = "div_code")
    String divCode;

//    /**  */
//    @Column(name = "div_name")
//    String divName;

    /**  */
    @Id
    @Column(name = "code")
    @NotBlank
    @BiteSize(biteMax = 5,fullCharMax = 2)
    String code;

    /**  */
    @Column(name = "name")
    String name;
    
    /**  */
    @Column(name = "attribute1")
    String attribute1;

    /**  */
    @Column(name = "attribute2")
    String attribute2;

    /**  */
    @Column(name = "attribute3")
    String attribute3;

    /**  */
    @Column(name = "attribute4")
    String attribute4;

    /**  */
    @Column(name = "attribute5")
    String attribute5;

    /**  */
    @Column(name = "disp_order")
    Integer dispOrder;

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