package jp.co.senrido.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Data;

@Entity(listener = TSalesDetailsOptionsListener.class)
@Table(name = "t_sales_details_options")
@Data
public class TSalesDetailsOptions {

    /** お客様ID */
    @Id
    @Column(name = "id")
    Integer id;

    /** 来店日 */
    @Column(name = "visit_date")
    LocalDateTime visitDate;

    /** 連番 */
    @Column(name = "seq")
    Integer seq;

    /** オプション連番 */
    @Column(name = "option_seq")
    Integer optionSeq;

    /** オプション1 */
    @Column(name = "option1")
    String option1;

    /** オプション名称1 */
    @Column(name = "option_name1")
    String optionName1;

    /** オプション金額1 */
    @Column(name = "option_price1")
    BigDecimal optionPrice1;

    /** オプション2 */
    @Column(name = "option2")
    String option2;

    /** オプション名称2 */
    @Column(name = "option_name2")
    String optionName2;

    /** オプション金額2 */
    @Column(name = "option_price2")
    BigDecimal optionPrice2;

    /** オプション3 */
    @Column(name = "option3")
    String option3;

    /** オプション名称3 */
    @Column(name = "option_name3")
    String optionName3;

    /** オプション金額3 */
    @Column(name = "option_price3")
    BigDecimal optionPrice3;

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
