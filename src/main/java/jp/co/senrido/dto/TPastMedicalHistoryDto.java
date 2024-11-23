package jp.co.senrido.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TPastMedicalHistoryDto {

    /** ¨qlID */
    private Integer id;

    /** Xú */
    private LocalDateTime visitDate;

    /** ßað */
    @Size(max = 2000)
    private String pastMedicalHistory;

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
