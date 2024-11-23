package jp.co.senrido.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TVisitingHospitalDto {

    /** お客様ID */
    @NotNull
    @MessageName("お客様ID")
    private Integer id;

    /** 来店日 */
    @NotNull
    @MessageName("来店日")
    private LocalDateTime visitDate;

    /** 受診日 */
    @MessageName("受診日")
    private LocalDate consultationDate;

    /** 眼科への通院 */
    @MessageName("眼科への通院")
    private Boolean visitEyeDoctor;

    /** 病歴 */
    @Size(max = 100)
    @MessageName("病歴")
    private String medicalHistory;

    /** 病歴その他 */
    @Size(max = 1000)
    @MessageName("病歴その他")
    private String medicalHistoryOther;

    /** 病歴名称 */
    @Size(max = 2000)
    @MessageName("病歴名称")
    private String medicalHistoryName;

    /** メガネ作製の指示 */
    @MessageName("メガネ作製の指示")
    private Boolean glassesMaking;

    /** 処方箋 */
    @MessageName("処方箋")
    private Boolean prescription;

    /** 眼科医の指示・意見 */
    @Size(max = 2000)
    @MessageName("眼科医の指示・意見")
    private String ophthalmologistInstructions;

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
