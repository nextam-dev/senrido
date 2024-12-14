package jp.co.senrido.dto;

import java.util.List;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TSymptomsDto {

	 /** お客様ID */
    @MessageName("お客様ID")
    private Integer id;

    /** 来店日 */
    @MessageName("来店日")
    private String visitDate;
    private String visitDateStr;

    /** ��̏Ǐ� */
    @MessageName("��̏Ǐ�")
    private List<String> eyeSymptoms;

    /** ��̏Ǐ󂻂̑� */
    @MessageName("��̏Ǐ󂻂̑�")
    private String eyeSymptomsOther;

    /** ��̏Ǐ󖼏� */
    @MessageName("��̏Ǐ󖼏�")
    private String eyeSymptomsName;

    /** �g�̂̏Ǐ� */
    @MessageName("�g�̂̏Ǐ�")
    private List<String> bodySymptoms;

    /** �g�̂̏Ǐ󂻂̑� */
    @MessageName("�g�̂̏Ǐ󂻂̑�")
    private String bodySymptomsOther;

    /** �g�̂̏Ǐ󖼏� */
    @MessageName("�g�̂̏Ǐ󖼏�")
    private String bodySymptomsName;

}
