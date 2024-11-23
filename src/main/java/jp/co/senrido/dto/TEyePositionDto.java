package jp.co.senrido.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TEyePositionDto {

    /** お客様ID */
    private Integer id;

    /** 来店日 */
    private LocalDateTime visitDate;

    /** 連番 */
    private Integer seq;

    /** 遠他覚コード */
    @Size(max = 5)
    private String fOtherAwareness;

    /** 遠自覚コード */
    @Size(max = 5)
    private String fSelfAwareness;

    /** 遠水平斜位量 */
    @Size(max = 5)
    private String fHorizontalAngle;

    /** 遠開散力(IN)分離 */
    @Size(max = 5)
    private String fInDispersalSeparation;

    /** 遠開散力(IN)回復 */
    @Size(max = 5)
    private String fInDispersalRecovery;

    /** 遠輻輳力(OUT)ぼやけ */
    @Size(max = 5)
    private String fOutDispersalBlurry;

    /** 遠輻輳力(OUT)分離 */
    @Size(max = 5)
    private String fOutDispersalSeparation;

    /** 遠輻輳力(OUT)回復 */
    @Size(max = 5)
    private String fOutDispersalRecovery;

    /** 遠上下寄せUP分離 */
    @Size(max = 5)
    private String fAlignmentUpSeparation;

    /** 遠上下寄せUP回復 */
    @Size(max = 5)
    private String fAlignmentUpRecovery;

    /** 遠上下寄せDOWN分離 */
    @Size(max = 5)
    private String fAlignmentDownSeparation;

    /** 遠上下寄せDOWN回復 */
    @Size(max = 5)
    private String fAlignmentDownRecovery;

    /** 遠上下斜位量 */
    @Size(max = 5)
    private String fVerticalAngle;

    /** 遠R UP・DOWNコード */
    @Size(max = 5)
    private String fUpdownCd;

    /** 遠利目 */
    @Size(max = 5)
    private String fDominantEye;

    /** 遠NPCぼやけ */
    @Size(max = 5)
    private String fNpcBlurry;

    /** 遠NPC分離 */
    @Size(max = 5)
    private String fNpcSeparation;

    /** 遠NPC回復 */
    @Size(max = 5)
    private String fNpcRecovery;

    /** 遠メモ */
    @Size(max = 2000)
    private String farNotes;

    /** 近他覚コード */
    @Size(max = 5)
    private String nOtherAwareness;

    /** 近自覚コード */
    @Size(max = 5)
    private String nSelfAwareness;

    /** 近水平斜位量 */
    @Size(max = 5)
    private String nHorizontalAngle;

    /** 近開散力(IN)分離 */
    @Size(max = 5)
    private String nInDispersalSeparation;

    /** 近開散力(IN)回復 */
    @Size(max = 5)
    private String nInDispersalRecovery;

    /** 近開散力(OUT)ぼやけ */
    @Size(max = 5)
    private String nOutDispersalBlurry;

    /** 近開散力(OUT)分離 */
    @Size(max = 5)
    private String nOutDispersalSeparation;

    /** 近開散力(OUT)回復 */
    @Size(max = 5)
    private String nOutDispersalRecovery;

    /** 近上下寄せUP分離 */
    @Size(max = 5)
    private String nAlignmentUpSeparation;

    /** 近上下寄せUP回復 */
    @Size(max = 5)
    private String nAlignmentUpRecovery;

    /** 近上下寄せDOWN分離 */
    @Size(max = 5)
    private String nAlignmentDownSeparation;

    /** 近上下寄せDOWN回復 */
    @Size(max = 5)
    private String nAlignmentDownRecovery;

    /** 近上下斜位量 */
    @Size(max = 5)
    private String nVerticalAngle;

    /** 近R UP・DOWNコード */
    @Size(max = 5)
    private String nUpdownCd;

    /** 近利目 */
    @Size(max = 5)
    private String nDominantEye;

    /** 近NPCぼやけ */
    @Size(max = 5)
    private String nearNpcBlur;

    /** 近NPC分離 */
    @Size(max = 5)
    private String nearNpcSeparation;

    /** 近NPC回復 */
    @Size(max = 5)
    private String nearNpcRecovery;

    /** 近メモ */
    @Size(max = 2000)
    private String nearNotes;

    /** 削除フラグ */
    private Boolean delFlg;

    /** 登録日時 */
    private LocalDateTime createDate;

    /** 登録者コード */
    private String createId;

    /** 更新日時 */
    private LocalDateTime updateDate;

    /** 更新者コード */
    private String updateId;
}
