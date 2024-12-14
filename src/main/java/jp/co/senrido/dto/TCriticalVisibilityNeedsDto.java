package jp.co.senrido.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TCriticalVisibilityNeedsDto {

	/** お客様ID */
    @MessageName("お客様ID")
    private Integer id;

    /** 来店日 */
    @MessageName("来店日")
    private String visitDate;
    private String visitDateStr;

    /** 見えないと困るもの */
    @MessageName("見えないと困るもの")
    private String whatToSee;
}
