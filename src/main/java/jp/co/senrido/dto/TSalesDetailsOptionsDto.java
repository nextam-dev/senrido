package jp.co.senrido.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TSalesDetailsOptionsDto {

    /** お客様ID */
    private Integer id;

    /** 来店日 */
    private LocalDateTime visitDate;

    /** 連番 */
    private Integer seq;

    /** オプション連番 */
    private Integer optionSeq;

    /** オプション1 */
    private String option1;

    /** オプション名称1 */
    private String optionName1;

    /** オプション金額1 */
    private BigDecimal optionPrice1;

    /** オプション2 */
    private String option2;

    /** オプション名称2 */
    private String optionName2;

    /** オプション金額2 */
    private BigDecimal optionPrice2;

    /** オプション3 */
    private String option3;

    /** オプション名称3 */
    private String optionName3;

    /** オプション金額3 */
    private BigDecimal optionPrice3;

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
