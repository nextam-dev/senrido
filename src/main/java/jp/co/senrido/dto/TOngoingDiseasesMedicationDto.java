package jp.co.senrido.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TOngoingDiseasesMedicationDto {

    /** お客様ID */
    private Integer id;

    /** 来店日 */
    private LocalDateTime visitDate;

    /** 治療中の疾病 */
    @Size(max = 2000)
    private String ongoingConditions;

    /** 服用薬 */
    @Size(max = 2000)
    private String medications;

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
