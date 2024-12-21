package jp.co.senrido.dto;

import javax.validation.constraints.Size;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TFullCorrectionDto {

	/** お客様ID */
    private Integer id;

    /** 来店日 */
    private String visitDate;
    private String visitDateStr;

    /** V */
    private String v;

    /** R-V */
    private String rV;

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

    /** R-P/BASE2-右*/
    private String rPBase2Right;

    /** ADD */
    private String add;

    /** L-V */
    private String lV;

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

    /** R-CL度数 */
    private String rClPower;

    /** L-CL度数 */
    private String lClPower;

    /** メモ */
    @Size(max = 400)
    @MessageName("メモ")
    private String memo;

}
