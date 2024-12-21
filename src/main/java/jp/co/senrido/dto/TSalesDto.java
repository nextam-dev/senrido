package jp.co.senrido.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TSalesDto {

	/** お客様ID */
    private Integer id;

    /** 来店日 */
    private String visitDate;
    private String visitDateStr;

    /** 連番 */
    private Integer seq;
    
    /** 小計 */
    @MessageName("小計")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private BigDecimal subtotalPrice;

    /** 消費税 */
    @MessageName("消費税")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private BigDecimal tax;

    /** 合計金額 */
    private BigDecimal totalPrice;

    /** 内金1 */
    @MessageName("内金")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private BigDecimal deposit1;

    /** 内金1種別コード */
    private String depositKindCd1;

    /** 内金2 */
    @MessageName("内金")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private BigDecimal deposit2;

    /** 内金2種別コード */
    private String depositKindCd2;

    /** 残金1 */
    @MessageName("残金")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private BigDecimal balance1;

    /** 残金種別コード1 */
    private String balanceKindCd1;

    /** 残金2 */
    @MessageName("残金")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private BigDecimal balance2;

    /** 残金種別コード2 */
    private String balanceKindCd2;
    
    /** メモ */
    @Size(max = 400)
    @MessageName("メモ")
    private String memo;

    /** フレームカーブ数 */
    private Integer frameCurveCount;

    /** レンズカーブ数 */
    private Integer lensCurveCount;

    /** サイズ */
    private Integer size;

    /**　溝深さ */
    private Integer grooveDepth;

    /** 溝幅 */
    private Integer grooveWidth;

    /** 加工 */
    private String processing;

    /** チェック */
    private String glassesCheck;

    /** お渡し */
    private String delivery;

    /** フィッティング*/
    private String fitting;

    /** 完成連絡 */
    private String completionContact;

    /** 完成連絡名称*/
    private String completionContactName;

    /** 完成予定日 */
    private LocalDate completionScheduledDate;

    /** レンズ発送日 */
    private LocalDate lensShippingDate;

    /** 連絡日 */
    private LocalDate contactDate;
}
