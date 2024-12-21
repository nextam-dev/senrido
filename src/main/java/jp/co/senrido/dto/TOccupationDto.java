package jp.co.senrido.dto;

import javax.validation.constraints.Size;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TOccupationDto {

	/** お客様ID */
    private Integer id;

    /** 来店日 */
    private String visitDate;
    private String visitDateStr;

    /** 職業・職種 */
    @Size(max = 200)
    @MessageName("職業・職種")
    private String occupationType;

    /** 仕事内容 */
    @Size(max = 2000)
    @MessageName("仕事内容")
    private String jobDetails;

}
