package jp.co.senrido.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Data;

@Entity(listener = TTroubleListener.class)
@Table(name = "t_trouble")
@Data
public class TTrouble {

    /** お客様ID */
    @Id
    @Column(name = "id")
    Integer id;

    /** 来店日 */
    @Column(name = "visit_date")
    LocalDateTime visitDate;

    /** メガネトラブル */
    @Column(name = "glasses_issues")
    String glassesIssues;

    /** メガネトラブル名称 */
    @Column(name = "glasses_issues_name")
    String glassesIssuesName;

    /** フレームトラブル */
    @Column(name = "frame_issues")
    String frameIssues;

    /** フレームトラブル名称 */
    @Column(name = "frame_issues_name")
    String frameIssuesName;

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
