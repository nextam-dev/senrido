package jp.co.senrido.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.makino_saiten.goitai.annotation.MessageName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TSymptomsDto {

    /** お客様ID */
    @NotNull
    @MessageName("お客様ID")
    private Integer id;

    /** 来店日 */
    @NotNull
    @MessageName("来店日")
    private LocalDateTime visitDate;

    /** 眼の症状 */
    @Size(max = 100)
    @MessageName("眼の症状")
    private String eyeSymptoms;

    /** 眼の症状その他 */
    @Size(max = 1000)
    @MessageName("眼の症状その他")
    private String eyeSymptomsOther;

    /** 眼の症状名称 */
    @Size(max = 2000)
    @MessageName("眼の症状名称")
    private String eyeSymptomsName;

    /** 身体の症状 */
    @Size(max = 100)
    @MessageName("身体の症状")
    private String bodySymptoms;

    /** 身体の症状その他 */
    @Size(max = 1000)
    @MessageName("身体の症状その他")
    private String bodySymptomsOther;

    /** 身体の症状名称 */
    @Size(max = 2000)
    @MessageName("身体の症状名称")
    private String bodySymptomsName;

    /** 削除フラグ */
    @NotNull
    @MessageName("削除フラグ")
    private Boolean delFlg;

    /** 登録日時 */
    @NotNull
    @MessageName("登録日時")
    private LocalDateTime createDate;

    /** 登録者コード */
    @NotBlank
    @Size(max = 8)
    @MessageName("登録者コード")
    private String createId;

    /** 更新日時 */
    @NotNull
    @MessageName("更新日時")
    private LocalDateTime updateDate;

    /** 更新者コード */
    @NotBlank
    @Size(max = 8)
    @MessageName("更新者コード")
    private String updateId;
}
