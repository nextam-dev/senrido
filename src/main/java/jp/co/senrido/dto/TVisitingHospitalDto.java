package jp.co.senrido.dto;

import java.util.List;

import javax.validation.constraints.Size;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TVisitingHospitalDto {

    /** お客様ID */
    private Integer id;

    /** 来店日 */
    private String visitDate;
    private String visitDateStr;

    /** 受診日 */
    private String consultationDate;
    private String consultationDateStr;
    
    /** 眼科名 */
    @Size(max = 100)
    @MessageName("眼科名")
    private String ophthalmologyName;

    /** 眼科への通院 */
    private String visitEyeDoctor;

    /** 病歴 */
    private List<String> medicalHistory;

    /** 病歴その他 */
    private String medicalHistoryOther;

    /** 病歴名称 */
    private String medicalHistoryName;

    /** メガネ作製の指示 */
    private String glassesMaking;

    /** 処方箋 */
    private String prescription;

    /** 眼科医の指示・意見 */
    @Size(max = 2000)
    @MessageName("眼科医の指示・意見")
    private String ophthalmologistInstructions;
    
}
