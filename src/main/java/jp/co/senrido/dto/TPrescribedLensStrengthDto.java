package jp.co.senrido.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TPrescribedLensStrengthDto {

    /** ���q�lID */
    private Integer id;

    /** ���X�� */
    private LocalDateTime visitDate;

    /** �A�� */
    private Integer seq;

    /** �x�� */
    @Size(max = 5)
    private String prescriptionStrength;

    /** �x�����̑� */
    @Size(max = 1000)
    private String prescriptionStrengthOther;

    /** �x������ */
    @Size(max = 200)
    private String prescriptionStrengthName;

    /** CV */
    @Size(max = 5)
    private String cv;

    /** R-CV */
    @Size(max = 5)
    private String rCv;

    /** R-S */
    @Size(max = 5)
    private String rS;

    /** R-C */
    @Size(max = 5)
    private String rC;

    /** R-AX */
    @Size(max = 5)
    private String rAx;

    /** R-P/BASE1-�� */
    @Size(max = 5)
    private String rPBase1Left;

    /** R-P/BASE1-�E */
    @Size(max = 5)
    private String rPBase1Right;

    /** R-P/BASE2-�� */
    @Size(max = 5)
    private String rPBase2Left;

    /** R-P/BASE2-�E */
    @Size(max = 5)
    private String rPBase2Right;

    /** ADD */
    @Size(max = 5)
    private String add;

    /** R-PD */
    @Size(max = 5)
    private String rPd;

    /** L-CV */
    @Size(max = 5)
    private String lCv;

    /** L-S */
    @Size(max = 5)
    private String lS;

    /** L-C */
    @Size(max = 5)
    private String lC;

    /** L-AX */
    @Size(max = 5)
    private String lAx;

    /** L-P/BASE1-�� */
    @Size(max = 5)
    private String lPBase1Left;

    /** L-P/BASE1-�E */
    @Size(max = 5)
    private String lPBase1Right;

    /** L-P/BASE2-�� */
    @Size(max = 5)
    private String lPBase2Left;

    /** L-P/BASE2-�E */
    @Size(max = 5)
    private String lPBase2Right;

    /** L-PD */
    @Size(max = 5)
    private String lPd;

    /** �ߗp��Ƌ��� */
    private BigDecimal nearWorkingDistance;

    /** ���� */
    @Size(max = 400)
    private String memo;

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
