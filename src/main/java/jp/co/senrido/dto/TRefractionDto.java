package jp.co.senrido.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TRefractionDto {

    /** お客様ID */
    private Integer id;

    /** 来店日 */
    private LocalDateTime visitDate;

}
