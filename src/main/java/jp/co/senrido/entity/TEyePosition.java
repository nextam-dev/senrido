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

    /** ���q�lID */
    @Id
    @Column(name = "id")
    Integer id;

    /** ���X�� */
    @Column(name = "visit_date")
    LocalDateTime visitDate;

    /** �A�� */
    @Column(name = "seq")
    Integer seq;

    /** �����o�R�[�h */
    @Column(name = "f_other_awareness")
    String fOtherAwareness;

    /** �����o�R�[�h */
    @Column(name = "f_self_awareness")
    String fSelfAwareness;

    /** �������Έʗ� */
    @Column(name = "f_horizontal_angle")
    String fHorizontalAngle;

    /** ���J�U��(IN)���� */
    @Column(name = "f_in_dispersal_separation")
    String fInDispersalSeparation;

    /** ���J�U��(IN)�� */
    @Column(name = "f_in_dispersal_recovery")
    String fInDispersalRecovery;

    /** ���t�s��(OUT)�ڂ₯ */
    @Column(name = "f_out_dispersal_blurry")
    String fOutDispersalBlurry;

    /** ���t�s��(OUT)���� */
    @Column(name = "f_out_dispersal_separation")
    String fOutDispersalSeparation;

    /** ���t�s��(OUT)�� */
    @Column(name = "f_out_dispersal_recovery")
    String fOutDispersalRecovery;

    /** ���㉺��UP���� */
    @Column(name = "f_alignment_up_separation")
    String fAlignmentUpSeparation;

    /** ���㉺��UP�� */
    @Column(name = "f_alignment_up_recovery")
    String fAlignmentUpRecovery;

    /** ���㉺��DOWN���� */
    @Column(name = "f_alignment_down_separation")
    String fAlignmentDownSeparation;

    /** ���㉺��DOWN�� */
    @Column(name = "f_alignment_down_recovery")
    String fAlignmentDownRecovery;

    /** ���㉺�Έʗ� */
    @Column(name = "f_vertical_angle")
    String fVerticalAngle;

    /** ��R UP�EDOWN�R�[�h */
    @Column(name = "f_updown_cd")
    String fUpdownCd;

    /** ������ */
    @Column(name = "f_dominant_eye")
    String fDominantEye;

    /** ��NPC�ڂ₯ */
    @Column(name = "f_npc_blurry")
    String fNpcBlurry;

    /** ��NPC���� */
    @Column(name = "f_npc_separation")
    String fNpcSeparation;

    /** ��NPC�� */
    @Column(name = "f_npc_recovery")
    String fNpcRecovery;

    /** ������ */
    @Column(name = "far_notes")
    String farNotes;

    /** �ߑ��o�R�[�h */
    @Column(name = "n_other_awareness")
    String nOtherAwareness;

    /** �ߎ��o�R�[�h */
    @Column(name = "n_self_awareness")
    String nSelfAwareness;

    /** �ߐ����Έʗ� */
    @Column(name = "n_horizontal_angle")
    String nHorizontalAngle;

    /** �ߊJ�U��(IN)���� */
    @Column(name = "n_in_dispersal_separation")
    String nInDispersalSeparation;

    /** �ߊJ�U��(IN)�� */
    @Column(name = "n_in_dispersal_recovery")
    String nInDispersalRecovery;

    /** �ߊJ�U��(OUT)�ڂ₯ */
    @Column(name = "n_out_dispersal_blurry")
    String nOutDispersalBlurry;

    /** �ߊJ�U��(OUT)���� */
    @Column(name = "n_out_dispersal_separation")
    String nOutDispersalSeparation;

    /** �ߊJ�U��(OUT)�� */
    @Column(name = "n_out_dispersal_recovery")
    String nOutDispersalRecovery;

    /** �ߏ㉺��UP���� */
    @Column(name = "n_alignment_up_separation")
    String nAlignmentUpSeparation;

    /** �ߏ㉺��UP�� */
    @Column(name = "n_alignment_up_recovery")
    String nAlignmentUpRecovery;

    /** �ߏ㉺��DOWN���� */
    @Column(name = "n_alignment_downm_separation")
    String nAlignmentDownmSeparation;

    /** �ߏ㉺��DOWN�� */
    @Column(name = "n_alignment_down_recovery")
    String nAlignmentDownRecovery;

    /** �ߏ㉺�Έʗ� */
    @Column(name = "n_vertical_angle")
    String nVerticalAngle;

    /** ��R UP�EDOWN�R�[�h */
    @Column(name = "n_updown_cd")
    String nUpdownCd;

    /** �ߗ��� */
    @Column(name = "n_dominant_eye")
    String nDominantEye;

    /** ��NPC�ڂ₯ */
    @Column(name = "near_npc_blur")
    String nearNpcBlur;

    /** ��NPC���� */
    @Column(name = "near_npc_separation")
    String nearNpcSeparation;

    /** ��NPC�� */
    @Column(name = "near_npc_recovery")
    String nearNpcRecovery;

    /** �߃��� */
    @Column(name = "near_notes")
    String nearNotes;

    /** �폜�t���O */
    @Column(name = "del_flg")
    Boolean delFlg;

    /** �o�^���� */
    @Column(name = "create_date")
    LocalDateTime createDate;

    /** �o�^�҃R�[�h */
    @Column(name = "create_id")
    String createId;

    /** �X�V���� */
    @Column(name = "update_date")
    LocalDateTime updateDate;

    /** �X�V�҃R�[�h */
    @Column(name = "update_id")
    String updateId;
}
