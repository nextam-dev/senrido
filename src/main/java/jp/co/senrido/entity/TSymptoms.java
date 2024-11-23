package jp.co.senrido.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Data;

@Entity(listener = TSymptomsListener.class)
@Table(name = "t_symptoms")
@Data
public class TSymptoms {

    /** お客様ID */
    @Id
    @Column(name = "id")
    Integer id;

    /** 来店日 */
    @Column(name = "visit_date")
    LocalDateTime visitDate;

    /** 眼の症状 */
    @Column(name = "eye_symptoms")
    String eyeSymptoms;

    /** 眼の症状その他 */
    @Column(name = "eye_symptoms_other")
    String eyeSymptomsOther;

    /** 眼の症状名称 */
    @Column(name = "eye_symptoms_name")
    String eyeSymptomsName;

    /** 身体の症状 */
    @Column(name = "body_symptoms")
    String bodySymptoms;

    /** 身体の症状その他 */
    @Column(name = "body_symptoms_other")
    String bodySymptomsOther;

    /** 身体の症状名称 */
    @Column(name = "body_symptoms_name")
    String bodySymptomsName;

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
