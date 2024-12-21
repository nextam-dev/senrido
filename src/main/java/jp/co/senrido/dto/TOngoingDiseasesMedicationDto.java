package jp.co.senrido.dto;

import javax.validation.constraints.Size;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TOngoingDiseasesMedicationDto {

	/** お客様ID */
    private Integer id;

    /** 来店日 */
    private String visitDate;
    private String visitDateStr;

    /** 治療中の疾病 */
    @Size(max = 2000)
    @MessageName("治療中の疾病")
    private String ongoingConditions;

    /** 服用薬 */
    @Size(max = 2000)
    @MessageName("服用薬")
    private String medications;
}
