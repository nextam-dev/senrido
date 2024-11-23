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

    /** ¨qlID */
    @Id
    @Column(name = "id")
    Integer id;

    /** Xú */
    @Column(name = "visit_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime visitDate;

    /** ófú */
    @Column(name = "consultation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDateTime consultationDate;

    /** áÈÖÌÊ@ */
    @Column(name = "visit_eye_doctor")
    Boolean visitEyeDoctor;

    /** að */
    @Column(name = "medical_history")
    String medicalHistory;

    /** að»Ì¼ */
    @Column(name = "medical_history_other")
    String medicalHistoryOther;

    /** að¼Ì */
    @Column(name = "medical_history_name")
    String medicalHistoryName;

    /** Klì»Ìw¦ */
    @Column(name = "glasses_making")
    Boolean glassesMaking;

    /** ûâ³ */
    @Column(name = "prescription")
    Boolean prescription;

    /** áÈãÌw¦EÓ© */
    @Column(name = "ophthalmologist_instructions")
    String ophthalmologistInstructions;

    /** ítO */
    @Column(name = "del_flg")
    Boolean delFlg;

    /** o^ú */
    @Column(name = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createDate;

    /** o^ÒR[h */
    @Column(name = "create_id")
    String createId;

    /** XVú */
    @Column(name = "update_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime updateDate;

    /** XVÒR[h */
    @Column(name = "update_id")
    String updateId;
}
