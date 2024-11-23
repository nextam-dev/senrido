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

    /** お客様ID */
    @Id
    @Column(name = "id")
    Integer id;

    /** 来店日 */
    @Column(name = "visit_date")
    LocalDateTime visitDate;

    /** 手術時期 */
    @Column(name = "surgery_date")
    LocalDateTime surgeryDate;

    /** 手術予定時期 */
    @Column(name = "scheduled_surgery_date")
    LocalDateTime scheduledSurgeryDate;

    /** 白内障 */
    @Column(name = "cataract")
    String cataract;

    /** 白内障名称 */
    @Column(name = "cataract_name")
    String cataractName;

    /** 緑内障 */
    @Column(name = "glaucoma")
    String glaucoma;

    /** 緑内障名称 */
    @Column(name = "glaucoma_name")
    String glaucomaName;

    /** 飛蚊症 */
    @Column(name = "floaters")
    String floaters;

    /** 飛蚊症名称 */
    @Column(name = "floaters_name")
    String floatersName;

    /** 網膜剥離 */
    @Column(name = "retinal_detachment")
    String retinalDetachment;

    /** 網膜剥離名称 */
    @Column(name = "retinal_detachment_name")
    String retinalDetachmentName;

    /** 斜視 */
    @Column(name = "strabismus")
    String strabismus;

    /** 斜視名称 */
    @Column(name = "strabismus_name")
    String strabismusName;

    /** 硝子体 */
    @Column(name = "vitreous_body")
    String vitreousBody;

    /** 硝子体名称 */
    @Column(name = "vitreous_body_name")
    String vitreousBodyName;

    /** レーシック */
    @Column(name = "lasik")
    String lasik;

    /** レーシック名称 */
    @Column(name = "lasik_name")
    String lasikName;

    /** ICL/IOL */
    @Column(name = "icl_iol")
    String iclIol;

    /** ICL/IOL名称 */
    @Column(name = "icl_iol_name")
    String iclIolName;

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
