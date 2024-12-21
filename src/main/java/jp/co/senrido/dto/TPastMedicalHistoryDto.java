package jp.co.senrido.dto;

import javax.validation.constraints.Size;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TPastMedicalHistoryDto {

	/** お客様ID */
    private Integer id;

    /** 来店日 */
    private String visitDate;
    private String visitDateStr;

    /** 過去病歴 */
    @Size(max = 2000)
    @MessageName("過去病歴")
    private String pastMedicalHistory;

}
