package jp.co.senrido.dto;

import java.util.List;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TGlareDto {

	/** お客様ID */
    @MessageName("お客様ID")
    private Integer id;

    /** 来店日 */
    @MessageName("来店日")
    private String visitDate;
    private String visitDateStr;

    /** ῂ����������镨�� */
    @MessageName("ῂ����������镨��")
    private List<String> glareSources;

    /** ῂ����������镨�����̑� */
    @MessageName("ῂ����������镨�����̑�")
    private String glareSourcesOther;

    /** ῂ����������镨������ */
    @MessageName("ῂ����������镨������")
    private String glareSourcesName;

    /** ���������������Ƃ��ڂɒɂ� */
    @MessageName("���������������Ƃ��ڂɒɂ�")
    private String eyePainStrongLight;

}
