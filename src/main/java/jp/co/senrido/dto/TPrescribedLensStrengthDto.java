package jp.co.senrido.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TPrescribedLensStrengthDto {

	 /** お客様ID */
    private Integer id;

    /** 来店日 */
    private String visitDate;
    private String visitDateStr;

    /** 連番 */
    private Integer seq;

    /** 度数 */
    private String prescriptionStrength;

    /** 度数その他 */
    private String prescriptionStrengthOther;

    /** 度数名称 */
    private String prescriptionStrengthName;

    /** CV */
    private String cv;

    /** R-CV */
    private String rCv;

    /** R-S */
    private String rS;

    /** R-C */
    private String rC;

    /** R-AX */
    private String rAx;

    /** R-P/BASE1-左 */
    private String rPBase1Left;

    /** R-P/BASE1-右 */
    private String rPBase1Right;

    /** R-P/BASE2-左 */
    private String rPBase2Left;

    /** R-P/BASE2-右 */
    private String rPBase2Right;

    /** ADD */
    private String add;

    /** R-PD */
    private String rPd;
    
    /** L-CV */
    private String lCv;

    /** L-S */
    private String lS;

    /** L-C */
    private String lC;

    /** L-AX */
    private String lAx;

    /** L-P/BASE1-左 */
    private String lPBase1Left;

    /** L-P/BASE1-右 */
    private String lPBase1Right;

    /** L-P/BASE2-左 */
    private String lPBase2Left;

    /** L-P/BASE2-右 */
    private String lPBase2Right;

    /** L-PD */
    private String lPd;

    /** 近用作業距離 */
    private BigDecimal nearWorkingDistance;

    /** メモ */
    @Size(max = 400)
    @MessageName("メモ")
    private String memo;

}
