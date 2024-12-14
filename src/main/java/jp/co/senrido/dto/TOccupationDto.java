package jp.co.senrido.dto;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TOccupationDto {

	 /** お客様ID */
    @MessageName("お客様ID")
    private Integer id;

    /** 来店日 */
    @MessageName("来店日")
    private String visitDate;
    private String visitDateStr;

    /** �E�ƁE�E�� */
    @MessageName("�E�ƁE�E��")
    private String occupationType;

    /** �d�����e */
    @MessageName("�d�����e")
    private String jobDetails;

}
