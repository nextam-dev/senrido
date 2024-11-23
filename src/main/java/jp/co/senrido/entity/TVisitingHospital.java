package jp.co.senrido.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity(listener = TVisitingHospitalListener.class)
@Table(name = "t_visiting_Hospital")
@Data
public class TVisitingHospital {

    /** ���q�lID */
    @Id
    @Column(name = "id")
    Integer id;

    /** ���X�� */
    @Column(name = "visit_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime visitDate;

    /** ��f�� */
    @Column(name = "consultation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDateTime consultationDate;

    /** ��Ȃւ̒ʉ@ */
    @Column(name = "visit_eye_doctor")
    Boolean visitEyeDoctor;

    /** �a�� */
    @Column(name = "medical_history")
    String medicalHistory;

    /** �a�����̑� */
    @Column(name = "medical_history_other")
    String medicalHistoryOther;

    /** �a�𖼏� */
    @Column(name = "medical_history_name")
    String medicalHistoryName;

    /** ���K�l�쐻�̎w�� */
    @Column(name = "glasses_making")
    Boolean glassesMaking;

    /** ����� */
    @Column(name = "prescription")
    Boolean prescription;

    /** ��Ȉ�̎w���E�ӌ� */
    @Column(name = "ophthalmologist_instructions")
    String ophthalmologistInstructions;

    /** �폜�t���O */
    @Column(name = "del_flg")
    Boolean delFlg;

    /** �o�^���� */
    @Column(name = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createDate;

    /** �o�^�҃R�[�h */
    @Column(name = "create_id")
    String createId;

    /** �X�V���� */
    @Column(name = "update_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime updateDate;

    /** �X�V�҃R�[�h */
    @Column(name = "update_id")
    String updateId;
}
