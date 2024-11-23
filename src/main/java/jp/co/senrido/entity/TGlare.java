package jp.co.senrido.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Data;

@Entity(listener = TGlareListener.class)
@Table(name = "t_glare")
@Data
public class TGlare {

    /** お客様ID */
    @Id
    @Column(name = "id")
    Integer id;

    /** 来店日 */
    @Column(name = "visit_date")
    LocalDateTime visitDate;

    /** 眩しさを感じる物事 */
    @Column(name = "glare_sources")
    String glareSources;

    /** 眩しさを感じる物事その他 */
    @Column(name = "glare_sources_other")
    String glareSourcesOther;

    /** 眩しさを感じる物事名称 */
    @Column(name = "glare_sources_name")
    String glareSourcesName;

    /** 強い光を感じたとき目に痛み */
    @Column(name = "eye_pain_strong_light")
    Boolean eyePainStrongLight;

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
