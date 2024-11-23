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

    /** ¨qlID */
    @Id
    @Column(name = "id")
    Integer id;

    /** Xú */
    @Column(name = "visit_date")
    LocalDateTime visitDate;

    /** KlECL Ìpóµ-»ó */
    @Column(name = "current_status_cd")
    String currentStatusCd;

    /** KlECL Ìpóµ-»ó¼Ì */
    @Column(name = "glasses_cl_usage_current_name")
    String glassesClUsageCurrentName;

    /** KlECL Ìpóµ-CL¹p */
    @Column(name = "combined_use_cl_cd")
    String combinedUseClCd;

    /** KlECL Ìpóµ-CL¹p¼Ì */
    @Column(name = "glasses_cl_usage_combined_name")
    String glassesClUsageCombinedName;

    /** Klpr */
    @Column(name = "glasses_purpose")
    String glassesPurpose;

    /** Klpr¼Ì */
    @Column(name = "glasses_purpose_name")
    String glassesPurposeName;

    /** ítO */
    @Column(name = "del_flg")
    Boolean delFlg;

    /** o^ú */
    @Column(name = "create_date")
    LocalDateTime createDate;

    /** o^ÒR[h */
    @Column(name = "create_id")
    String createId;

    /** XVú */
    @Column(name = "update_date")
    LocalDateTime updateDate;

    /** XVÒR[h */
    @Column(name = "update_id")
    String updateId;
}
