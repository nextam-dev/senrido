package jp.co.senrido.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Data;

@Entity(listener = TEyePositionListener.class)
@Table(name = "t_eye_position")
@Data
public class TEyePosition {

    /** お客様ID */
    @Id
    @Column(name = "id")
    Integer id;

    /** 来店日 */
    @Column(name = "visit_date")
    LocalDateTime visitDate;

    /** 連番 */
    @Column(name = "seq")
    Integer seq;

    /** 遠他覚コード */
    @Column(name = "f_other_awareness")
    String fOtherAwareness;

    /** 遠自覚コード */
    @Column(name = "f_self_awareness")
    String fSelfAwareness;

    /** 遠水平斜位量 */
    @Column(name = "f_horizontal_angle")
    String fHorizontalAngle;

    /** 遠開散力(IN)分離 */
    @Column(name = "f_in_dispersal_separation")
    String fInDispersalSeparation;

    /** 遠開散力(IN)回復 */
    @Column(name = "f_in_dispersal_recovery")
    String fInDispersalRecovery;

    /** 遠輻輳力(OUT)ぼやけ */
    @Column(name = "f_out_dispersal_blurry")
    String fOutDispersalBlurry;

    /** 遠輻輳力(OUT)分離 */
    @Column(name = "f_out_dispersal_separation")
    String fOutDispersalSeparation;

    /** 遠輻輳力(OUT)回復 */
    @Column(name = "f_out_dispersal_recovery")
    String fOutDispersalRecovery;

    /** 遠上下寄せUP分離 */
    @Column(name = "f_alignment_up_separation")
    String fAlignmentUpSeparation;

    /** 遠上下寄せUP回復 */
    @Column(name = "f_alignment_up_recovery")
    String fAlignmentUpRecovery;

    /** 遠上下寄せDOWN分離 */
    @Column(name = "f_alignment_downm_separation")
    String fAlignmentDownmSeparation;

    /** 遠上下寄せDOWN回復 */
    @Column(name = "f_alignment_down_recovery")
    String fAlignmentDownRecovery;

    /** 遠上下斜位量 */
    @Column(name = "f_vertical_angle")
    String fVerticalAngle;

    /** 遠R UP・DOWNコード */
    @Column(name = "f_updown_cd")
    String fUpdownCd;

    /** 遠利目 */
    @Column(name = "f_dominant_eye")
    String fDominantEye;

    /** 遠NPCぼやけ */
    @Column(name = "f_npc_blurry")
    String fNpcBlurry;

    /** 遠NPC分離 */
    @Column(name = "f_npc_separation")
    String fNpcSeparation;

    /** 遠NPC回復 */
    @Column(name = "f_npc_recovery")
    String fNpcRecovery;

    /** 遠メモ */
    @Column(name = "far_notes")
    String farNotes;

    /** 近他覚コード */
    @Column(name = "n_other_awareness")
    String nOtherAwareness;

    /** 近自覚コード */
    @Column(name = "n_self_awareness")
    String nSelfAwareness;

    /** 近水平斜位量 */
    @Column(name = "n_horizontal_angle")
    String nHorizontalAngle;

    /** 近開散力(IN)分離 */
    @Column(name = "n_in_dispersal_separation")
    String nInDispersalSeparation;

    /** 近開散力(IN)回復 */
    @Column(name = "n_in_dispersal_recovery")
    String nInDispersalRecovery;

    /** 近開散力(OUT)ぼやけ */
    @Column(name = "n_out_dispersal_blurry")
    String nOutDispersalBlurry;

    /** 近開散力(OUT)分離 */
    @Column(name = "n_out_dispersal_separation")
    String nOutDispersalSeparation;

    /** 近開散力(OUT)回復 */
    @Column(name = "n_out_dispersal_recovery")
    String nOutDispersalRecovery;

    /** 近上下寄せUP分離 */
    @Column(name = "n_alignment_up_separation")
    String nAlignmentUpSeparation;

    /** 近上下寄せUP回復 */
    @Column(name = "n_alignment_up_recovery")
    String nAlignmentUpRecovery;

    /** 近上下寄せDOWN分離 */
    @Column(name = "n_alignment_downm_separation")
    String nAlignmentDownmSeparation;

    /** 近上下寄せDOWN回復 */
    @Column(name = "n_alignment_down_recovery")
    String nAlignmentDownRecovery;

    /** 近上下斜位量 */
    @Column(name = "n_vertical_angle")
    String nVerticalAngle;

    /** 近R UP・DOWNコード */
    @Column(name = "n_updown_cd")
    String nUpdownCd;

    /** 近利目 */
    @Column(name = "n_dominant_eye")
    String nDominantEye;

    /** 近NPCぼやけ */
    @Column(name = "near_npc_blur")
    String nearNpcBlur;

    /** 近NPC分離 */
    @Column(name = "near_npc_separation")
    String nearNpcSeparation;

    /** 近NPC回復 */
    @Column(name = "near_npc_recovery")
    String nearNpcRecovery;

    /** 近メモ */
    @Column(name = "near_notes")
    String nearNotes;

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
