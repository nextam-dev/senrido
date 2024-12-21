package jp.co.senrido.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TSymptomsDto {

	 /** お客様ID */
    private Integer id;

    /** 来店日 */
    private String visitDate;
    private String visitDateStr;

    /** 眼の症状 */
    private List<String> eyeSymptoms;

    /** 眼の症状その他 */
    private String eyeSymptomsOther;

    /** 眼の症状名称 */
    private String eyeSymptomsName;

    /** 身体の症状 */
    private List<String> bodySymptoms;

    /** 身体の症状その他 */
    private String bodySymptomsOther;

    /**　身体の症状名称*/
    private String bodySymptomsName;

}
