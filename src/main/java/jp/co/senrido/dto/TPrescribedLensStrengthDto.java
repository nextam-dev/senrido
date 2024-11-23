package jp.co.senrido.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TPrescribedLensStrengthDto {

    /** お客様ID */
    private Integer id;

    /** 来店日 */
    private LocalDateTime visitDate;

    /** 連番 */
    private Integer seq;

    /** 度数 */
    @Size(max = 5)
    private String prescriptionStrength;

    /** 度数その他 */
    @Size(max = 1000)
    private String prescriptionStrengthOther;

    /** 度数名称 */
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

    /** R-P/BASE1-左 */
    @Size(max = 5)
    private String rPBase1Left;

    /** R-P/BASE1-右 */
    @Size(max = 5)
    private String rPBase1Right;

    /** R-P/BASE2-左 */
    @Size(max = 5)
    private String rPBase2Left;

    /** R-P/BASE2-右 */
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

    /** L-P/BASE1-左 */
    @Size(max = 5)
    private String lPBase1Left;

    /** L-P/BASE1-右 */
    @Size(max = 5)
    private String lPBase1Right;

    /** L-P/BASE2-左 */
    @Size(max = 5)
    private String lPBase2Left;

    /** L-P/BASE2-右 */
    @Size(max = 5)
    private String lPBase2Right;

    /** L-PD */
    @Size(max = 5)
    private String lPd;

    /** 近用作業距離 */
    private BigDecimal nearWorkingDistance;

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
