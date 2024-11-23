package jp.co.senrido.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TOngoingDiseasesMedicationDto {

    /** ¨qlID */
    private Integer id;

    /** Xú */
    private LocalDateTime visitDate;

    /** ¡ÃÌ¾a */
    @Size(max = 2000)
    private String ongoingConditions;

    /** pò */
    @Size(max = 2000)
    private String medications;

    /** ítO */
    private Boolean delFlg;

    /** o^ú */
    private LocalDateTime createDate;

    /** o^ÒR[h */
    private String createId;

    /** XVú */
    private LocalDateTime updateDate;

    /** XVÒR[h */
    private String updateId;
}
