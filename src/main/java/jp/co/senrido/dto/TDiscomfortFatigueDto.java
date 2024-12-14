package jp.co.senrido.dto;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TDiscomfortFatigueDto {

	/** お客様ID */
    @MessageName("お客様ID")
    private Integer id;

    /** 来店日 */
    @MessageName("来店日")
    private String visitDate;
    private String visitDateStr;

    /** 見づらさや疲れを感じるとき */
    @MessageName("見づらさや疲れを感じるとき")
    private String feelTired;

}
