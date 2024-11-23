package jp.co.senrido.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Data;

@Entity(listener = TFullCorrectionListener.class)
@Table(name = "t_full_correction")
@Data
public class TFullCorrection {

    /** お客様ID */
    @Id
    @Column(name = "id")
    Integer id;

    /** 来店日 */
    @Column(name = "visit_date")
    LocalDateTime visitDate;

    /** V */
    @Column(name = "v")
    String v;

    /** R-V */
    @Column(name = "r_v")
    String rV;

    /** CV */
    @Column(name = "cv")
    String cv;

    /** R-CV */
    @Column(name = "r_cv")
    String rCv;

    /** R-S */
    @Column(name = "r_s")
    String rS;

    /** R-C */
    @Column(name = "r_c")
    String rC;

    /** R-AX */
    @Column(name = "r_ax")
    String rAx;

    /** R-P/BASE1-左 */
    @Column(name = "r_p_base1_left")
    String rPBase1Left;

    /** R-P/BASE1-右 */
    @Column(name = "r_p_base1_right")
    String rPBase1Right;

    /** R-P/BASE2-左 */
    @Column(name = "r_p_base2_left")
    String rPBase2Left;

    /** R-P/BASE2-右 */
    @Column(name = "r_p_base2_right")
    String rPBase2Right;

    /** ADD */
    @Column(name = "add")
    String add;

    /** L-V */
    @Column(name = "l_v")
    String lV;

    /** L-CV */
    @Column(name = "l_cv")
    String lCv;

    /** L-S */
    @Column(name = "l_s")
    String lS;

    /** L-C */
    @Column(name = "l_c")
    String lC;

    /** L-AX */
    @Column(name = "l_ax")
    String lAx;

    /** L-P/BASE1-左 */
    @Column(name = "l_p_base1_left")
    String lPBase1Left;

    /** L-P/BASE1-右 */
    @Column(name = "l_p_base1_right")
    String lPBase1Right;

    /** L-P/BASE2-左 */
    @Column(name = "l_p_base2_left")
    String lPBase2Left;

    /** L-P/BASE2-右 */
    @Column(name = "l_p_base2_right")
    String lPBase2Right;

    /** R-CL度数 */
    @Column(name = "r_cl_power")
    String rClPower;

    /** L-CL度数 */
    @Column(name = "l_cl_power")
    String lClPower;

    /** メモ */
    @Column(name = "memo")
    String memo;

    /** 削除フラグ */
    @Column(name = "del_flg")
    Boolean delFlg;

    /** 登録日時 */
    @Column(name = "create_date")
    LocalDateTime createDate;

    /** 登録者コード */
    @Column(name = "create_id")
    String createId;

    /** 更新日時 */
    @Column(name = "update_date")
    LocalDateTime updateDate;

    /** 更新者コード */
    @Column(name = "update_id")
    String updateId;
}
