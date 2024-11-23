package jp.co.senrido.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Data;

@Entity(listener = TSalesListener.class)
@Table(name = "t_sales")
@Data
public class TSales {

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

    /** 消費税 */
    @Column(name = "tax")
    BigDecimal tax;

    /** 合計金額 */
    @Column(name = "total_price")
    BigDecimal totalPrice;

    /** 内金1 */
    @Column(name = "deposit1")
    BigDecimal deposit1;

    /** 内金種別コード1 */
    @Column(name = "deposit_kind_cd1")
    String depositKindCd1;

    /** 内金2 */
    @Column(name = "deposit2")
    BigDecimal deposit2;

    /** 内金種別コード2 */
    @Column(name = "deposit_kind_cd2")
    String depositKindCd2;

    /** 残金1 */
    @Column(name = "balance1")
    BigDecimal balance1;

    /** 残金種別コード1 */
    @Column(name = "balance_kind_cd1")
    String balanceKindCd1;

    /** 残金2 */
    @Column(name = "balance2")
    BigDecimal balance2;

    /** 残金種別コード2 */
    @Column(name = "balance_kind_cd2")
    String balanceKindCd2;

    /** フレームカーブ数 */
    @Column(name = "frame_curve_count")
    Integer frameCurveCount;

    /** レンズカーブ数 */
    @Column(name = "lens_curve_count")
    Integer lensCurveCount;

    /** サイズ */
    @Column(name = "size")
    Integer size;

    /** 溝深さ */
    @Column(name = "groove_depth")
    Integer grooveDepth;

    /** 溝幅 */
    @Column(name = "groove_width")
    Integer grooveWidth;

    /** 加工 */
    @Column(name = "processing")
    String processing;

    /** チェック */
    @Column(name = "check")
    String check;

    /** お渡し */
    @Column(name = "delivery")
    String delivery;

    /** フィッティング */
    @Column(name = "fitting")
    String fitting;

    /** 完成連絡 */
    @Column(name = "completion_contact")
    String completionContact;

    /** 完成連絡名称 */
    @Column(name = "completion_contact_name")
    String completionContactName;

    /** 完成予定日 */
    @Column(name = "completion_scheduled_date")
    LocalDate completionScheduledDate;

    /** レンズ発送日 */
    @Column(name = "lens_shipping_date")
    LocalDate lensShippingDate;

    /** 連絡日 */
    @Column(name = "contact_date")
    LocalDate contactDate;

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
