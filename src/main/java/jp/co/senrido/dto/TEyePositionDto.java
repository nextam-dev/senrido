package jp.co.senrido.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TEyePositionDto {

	 /** お客様ID */
    private Integer id;

    /** 来店日 */
    private String visitDate;
    private String visitDateStr;
    
    /** 連番 */
    private Integer seq;

    /** 遠他覚コード */
    private String fOtherAwareness;

    /** 遠自覚コード */
    private String fSelfAwareness;

    /** 遠水平斜位量 */
    private String fHorizontalAngle;

    /** 遠開散力(IN)分離 */
    private String fInDispersalSeparation;

    /** 遠開散力(IN)回復 */
    private String fInDispersalRecovery;

    /** 遠輻輳力(OUT)ぼやけ */
    private String fOutDispersalBlurry;

    /** 遠輻輳力(OUT)分離 */
    private String fOutDispersalSeparation;

    /** 遠輻輳力(OUT)回復 */
    private String fOutDispersalRecovery;

    /** 遠上下寄せUP分離 */
    private String fAlignmentUpSeparation;

    /** 遠上下寄せUP回復 */
    private String fAlignmentUpRecovery;

    /** 遠上下寄せDOWN分離 */
    private String fAlignmentDownSeparation;

    /** 遠上下寄せDOWN回復 */
    private String fAlignmentDownRecovery;

    /** 遠上下斜位量 */
    private String fVerticalAngle;

    /** 遠R UP・DOWNコード */
    private String fUpdownCd;

    /** 遠利目 */
    private String fDominantEye;

    /** 遠NPCぼやけ */
    private String fNpcBlurry;

    /** 遠NPC分離 */
    private String fNpcSeparation;

    /** 遠NPC回復 */
    private String fNpcRecovery;

    /** 遠メモ */
    @Size(max = 2000)
    @MessageName("遠メモ ")
    private String farNotes;

    /** 近他覚コード */
    private String nOtherAwareness;

    /** 近自覚コード */
    private String nSelfAwareness;

    /** 近水平斜位量 */
    private String nHorizontalAngle;

    /** 近開散力(IN)分離 */
    private String nInDispersalSeparation;

    /** 近開散力(IN)回復 */
    private String nInDispersalRecovery;

    /** 近開散力(OUT)ぼやけ */
    private String nOutDispersalBlurry;

    /** 近開散力(OUT)分離 */
    private String nOutDispersalSeparation;

    /** 近開散力(OUT)回復 */
    private String nOutDispersalRecovery;

    /** 近上下寄せUP分離 */
    private String nAlignmentUpSeparation;

    /** 近上下寄せUP回復 */
    private String nAlignmentUpRecovery;

    /** 近上下寄せDOWN分離 */
    private String nAlignmentDownSeparation;

    /** 近上下寄せDOWN回復 */
    private String nAlignmentDownRecovery;

    /** 近上下斜位量 */ 
    private String nVerticalAngle;

    /** 近R UP・DOWNコード */  
    private String nUpdownCd;

    /** 近利目 */
    private String nDominantEye;

    /** 近NPCぼやけ */
    private String nearNpcBlur;

    /** 近NPC分離 */
    private String nearNpcSeparation;

    /** 近NPC回復 */
    private String nearNpcRecovery;

    /** 近メモ */
    @Size(max = 2000)
    @MessageName("近メモ ")
    private String nearNotes;
}
