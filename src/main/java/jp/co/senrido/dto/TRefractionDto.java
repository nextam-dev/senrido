package jp.co.senrido.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TRefractionDto {

    /** ���q�lID */
    private Integer id;

    /** ���X�� */
    private LocalDateTime visitDate;

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
