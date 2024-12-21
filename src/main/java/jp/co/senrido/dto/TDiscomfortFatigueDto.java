package jp.co.senrido.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TDiscomfortFatigueDto {

	/** お客様ID */
    private Integer id;

    /** 来店日 */
    private String visitDate;
    private String visitDateStr;

    /** 見づらさや疲れを感じるとき */
    private String feelTired;

}
