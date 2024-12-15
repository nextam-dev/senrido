package jp.co.senrido.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TFullCorrectionDto {

    /** ���q�lID */
    private Integer id;

    /** ���X�� */
    private LocalDateTime visitDate;

    /** V */
    @Size(max = 5)
    private String v;

    /** R-V */
    @Size(max = 5)
    private String rV;

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

    /** L-V */
    @Size(max = 5)
    private String lV;

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

    /** R-CL�x�� */
    @Size(max = 5)
    private String rClPower;

    /** L-CL�x�� */
    @Size(max = 5)
    private String lClPower;

    /** メモ */
    @Size(max = 400)
    private String memo;

    /** 削除フラグ */
    private Boolean delFlg;

    /** 登録日時 */
    private LocalDateTime createDate;

    /** 登録者コード */
    private String createId;

    /** 更新日時 */
    private LocalDateTime updateDate;

    /** 更新者コード */
    private String updateId;
}
