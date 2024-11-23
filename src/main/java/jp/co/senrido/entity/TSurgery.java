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

    /** ¨qlID */
    @Id
    @Column(name = "id")
    Integer id;

    /** Xú */
    @Column(name = "visit_date")
    LocalDateTime visitDate;

    /** èpú */
    @Column(name = "surgery_date")
    LocalDateTime surgeryDate;

    /** èp\èú */
    @Column(name = "scheduled_surgery_date")
    LocalDateTime scheduledSurgeryDate;

    /** àá */
    @Column(name = "cataract")
    String cataract;

    /** àá¼Ì */
    @Column(name = "cataract_name")
    String cataractName;

    /** Îàá */
    @Column(name = "glaucoma")
    String glaucoma;

    /** Îàá¼Ì */
    @Column(name = "glaucoma_name")
    String glaucomaName;

    /** òáÇ */
    @Column(name = "floaters")
    String floaters;

    /** òáÇ¼Ì */
    @Column(name = "floaters_name")
    String floatersName;

    /** Ô£ */
    @Column(name = "retinal_detachment")
    String retinalDetachment;

    /** Ô£¼Ì */
    @Column(name = "retinal_detachment_name")
    String retinalDetachmentName;

    /** Î */
    @Column(name = "strabismus")
    String strabismus;

    /** Î¼Ì */
    @Column(name = "strabismus_name")
    String strabismusName;

    /** ÉqÌ */
    @Column(name = "vitreous_body")
    String vitreousBody;

    /** ÉqÌ¼Ì */
    @Column(name = "vitreous_body_name")
    String vitreousBodyName;

    /** [VbN */
    @Column(name = "lasik")
    String lasik;

    /** [VbN¼Ì */
    @Column(name = "lasik_name")
    String lasikName;

    /** ICL/IOL */
    @Column(name = "icl_iol")
    String iclIol;

    /** ICL/IOL¼Ì */
    @Column(name = "icl_iol_name")
    String iclIolName;

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
