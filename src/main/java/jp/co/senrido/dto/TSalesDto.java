package jp.co.senrido.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TSalesDto {

    /** お客様ID */
    private Integer id;

    /** 来店日 */
    private LocalDateTime visitDate;

    /** 連番 */
    private Integer seq;

    /** 消費税 */
    private BigDecimal tax;

    /** 合計金額 */
    private BigDecimal totalPrice;

    /** 内金1 */
    private BigDecimal deposit1;

    /** 内金種別コード1 */
    private String depositKindCd1;

    /** 内金2 */
    private BigDecimal deposit2;

    /** 内金種別コード2 */
    private String depositKindCd2;

    /** 残金1 */
    private BigDecimal balance1;

    /** 残金種別コード1 */
    private String balanceKindCd1;

    /** 残金2 */
    private BigDecimal balance2;

    /** 残金種別コード2 */
    private String balanceKindCd2;

    /** フレームカーブ数 */
    private Integer frameCurveCount;

    /** レンズカーブ数 */
    private Integer lensCurveCount;

    /** サイズ */
    private Integer size;

    /** 溝深さ */
    private Integer grooveDepth;

    /** 溝幅 */
    private Integer grooveWidth;

    /** 加工 */
    private String processing;

    /** チェック */
    private String check;

    /** お渡し */
    private String delivery;

    /** フィッティング */
    private String fitting;

    /** 完成連絡 */
    private String completionContact;

    /** 完成連絡名称 */
    private String completionContactName;

    /** 完成予定日 */
    private LocalDate completionScheduledDate;

    /** レンズ発送日 */
    private LocalDate lensShippingDate;

    /** 連絡日 */
    private LocalDate contactDate;

    /** 削除フラグ */
    private Boolean delFlg;

    /** 登録日時 */
    private LocalDateTime createDate;

    /** 登録者コード */
    private String createId;

    /** 更新日時 */
    private LocalDateTime updateDate;

    /** 更新者コード */
    private String updateId;
}
