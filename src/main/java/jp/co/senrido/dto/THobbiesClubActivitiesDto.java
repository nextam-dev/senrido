package jp.co.senrido.dto;

import javax.validation.constraints.Size;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class THobbiesClubActivitiesDto {

	/** お客様ID */
    private Integer id;

    /** 来店日 */
    private String visitDate;
    private String visitDateStr;

    /** 趣味・部活 */
    @Size(max = 100)
    @MessageName("趣味・部活 ")
    private String hobbiesAndClub;

}
