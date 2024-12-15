package jp.co.senrido.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TSalesDetailsDto {

    /** お客様ID */
    private Integer id;

    /** 来店日 */
    private LocalDateTime visitDate;

    /** 連番 */
    private Integer seq;

    /** フレーム */
    private String frame;

    /** アイポイント */
    private BigDecimal eyePoint;

    /** フレーム金額 */
    private BigDecimal framePrice;

    /** レンズ */
    private String lens;

    /** レンズ金額 */
    private BigDecimal lensPrice;

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
