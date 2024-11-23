package jp.co.senrido.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Data;

@Entity(listener = TUsageStatusListener.class)
@Table(name = "t_usage_status")
@Data
public class TUsageStatus {

    /** お客様ID */
    @Id
    @Column(name = "id")
    Integer id;

    /** 来店日 */
    @Column(name = "visit_date")
    LocalDateTime visitDate;

    /** メガネ・CL の装用状況-現状 */
    @Column(name = "current_status_cd")
    String currentStatusCd;

    /** メガネ・CL の装用状況-現状名称 */
    @Column(name = "glasses_cl_usage_current_name")
    String glassesClUsageCurrentName;

    /** メガネ・CL の装用状況-CL併用 */
    @Column(name = "combined_use_cl_cd")
    String combinedUseClCd;

    /** メガネ・CL の装用状況-CL併用名称 */
    @Column(name = "glasses_cl_usage_combined_name")
    String glassesClUsageCombinedName;

    /** メガネ用途 */
    @Column(name = "glasses_purpose")
    String glassesPurpose;

    /** メガネ用途名称 */
    @Column(name = "glasses_purpose_name")
    String glassesPurposeName;

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
