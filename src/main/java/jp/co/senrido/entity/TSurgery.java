package jp.co.senrido.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Data;

@Entity(listener = TSurgeryListener.class)
@Table(name = "t_surgery")
@Data
public class TSurgery {

    /** ���q�lID */
    @Id
    @Column(name = "id")
    Integer id;

    /** ���X�� */
    @Column(name = "visit_date")
    LocalDateTime visitDate;

    /** ��p���� */
    @Column(name = "surgery_date")
    LocalDateTime surgeryDate;

    /** ��p�\�莞�� */
    @Column(name = "surgery_planned_Date")
    LocalDateTime surgeryPlannedDate;

    /** ������ */
    @Column(name = "cataract")
    String cataract;

    /** �����ᖼ�� */
    @Column(name = "cataract_name")
    String cataractName;

    /** �Γ��� */
    @Column(name = "glaucoma")
    String glaucoma;

    /** �Γ��ᖼ�� */
    @Column(name = "glaucoma_name")
    String glaucomaName;

    /** ���� */
    @Column(name = "floaters")
    String floaters;

    /** ���ǖ��� */
    @Column(name = "floaters_name")
    String floatersName;

    /** �Ԗ����� */
    @Column(name = "retinal_detachment")
    String retinalDetachment;

    /** �Ԗ��������� */
    @Column(name = "retinal_detachment_name")
    String retinalDetachmentName;

    /** �Ύ� */
    @Column(name = "strabismus")
    String strabismus;

    /** �Ύ����� */
    @Column(name = "strabismus_name")
    String strabismusName;

    /** �Ɏq�� */
    @Column(name = "vitreous_body")
    String vitreousBody;

    /** �Ɏq�̖��� */
    @Column(name = "vitreous_body_name")
    String vitreousBodyName;

    /** ���[�V�b�N */
    @Column(name = "lasik")
    String lasik;

    /** ���[�V�b�N���� */
    @Column(name = "lasik_name")
    String lasikName;

    /** ICL/IOL */
    @Column(name = "icl_iol")
    String iclIol;

    /** ICL/IOL���� */
    @Column(name = "icl_iol_name")
    String iclIolName;

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
