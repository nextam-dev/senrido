package jp.co.senrido.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TSalesDetailsOptionsDto {

	/** お客様ID */
    private Integer id;

    /** 来店日 */
    private String visitDate;
    private String visitDateStr;

    /** 連番 */
    private Integer seq;

    /** オプション連番 */
    private Integer optionSeq;

    /** オプション1 */
    private String option1;

    /** オプション名称1 */
    private String optionName1;

    /** オプション金額1 */
    @MessageName("オプションの金額")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private BigDecimal optionPrice1;

    /** オプション2 */
    private String option2;

    /** オプション名称2 */
    private String optionName2;

    /** オプション金額2 */
    @MessageName("オプションの金額")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private BigDecimal optionPrice2;

    /** オプション3 */
    private String option3;

    /** オプション名称3 */
    private String optionName3;

    /** オプション金額3 */
    @MessageName("オプションの金額")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private BigDecimal optionPrice3;

}
