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

    /** お客様ID */
    @Id
    @Column(name = "id")
    Integer id;

    /** 来店日 */
    @Column(name = "visit_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime visitDate;

    /** 受診日 */
    @Column(name = "consultation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDateTime consultationDate;

    /** 眼科への通院 */
    @Column(name = "visit_eye_doctor")
    Boolean visitEyeDoctor;

    /** 病歴 */
    @Column(name = "medical_history")
    String medicalHistory;

    /** 病歴その他 */
    @Column(name = "medical_history_other")
    String medicalHistoryOther;

    /** 病歴名称 */
    @Column(name = "medical_history_name")
    String medicalHistoryName;

    /** メガネ作製の指示 */
    @Column(name = "glasses_making")
    Boolean glassesMaking;

    /** 処方箋 */
    @Column(name = "prescription")
    Boolean prescription;

    /** 眼科医の指示・意見 */
    @Column(name = "ophthalmologist_instructions")
    String ophthalmologistInstructions;

    /** 削除フラグ */
    @Column(name = "del_flg")
    Boolean delFlg;

    /** 登録日時 */
    @Column(name = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createDate;

    /** 登録者コード */
    @Column(name = "create_id")
    String createId;

    /** 更新日時 */
    @Column(name = "update_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime updateDate;

    /** 更新者コード */
    @Column(name = "update_id")
    String updateId;
}
