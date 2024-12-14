package jp.co.senrido.dto;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TVisionLossDto {

    /** お客様ID */
    @MessageName("お客様ID")
    private Integer id;

    /** 来店日 */
    @MessageName("来店日")
    private String visitDate;
    private String visitDateStr;

    /** 視力の低下を感じたのは */
    @MessageName("視力の低下を感じたのは")
    private String decreaseEyesight;

}
