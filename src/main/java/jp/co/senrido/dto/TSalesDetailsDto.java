package jp.co.senrido.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TSalesDetailsDto {

    /** ���q�lID */
    private Integer id;

    /** ���X�� */
    private LocalDateTime visitDate;

    /** �A�� */
    private Integer seq;

    /** �t���[�� */
    private String frame;

    /** �A�C�|�C���g */
    private BigDecimal eyePoint;

    /** �t���[�����z */
    private BigDecimal framePrice;

    /** �����Y */
    private String lens;

    /** �����Y���z */
    private BigDecimal lensPrice;

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
