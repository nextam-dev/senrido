package jp.co.senrido.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TOngoingDiseasesMedicationDto {

    /** ���q�lID */
    private Integer id;

    /** ���X�� */
    private LocalDateTime visitDate;

    /** ���Ò��̎��a */
    @Size(max = 2000)
    private String ongoingConditions;

    /** ���p�� */
    @Size(max = 2000)
    private String medications;

    /** �폜�t���O */
    private Boolean delFlg;

    /** �o�^���� */
    private LocalDateTime createDate;

    /** �o�^�҃R�[�h */
    private String createId;

    /** �X�V���� */
    private LocalDateTime updateDate;

    /** �X�V�҃R�[�h */
    private String updateId;
}
