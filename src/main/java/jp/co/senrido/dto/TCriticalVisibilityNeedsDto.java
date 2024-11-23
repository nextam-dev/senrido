package jp.co.senrido.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TCriticalVisibilityNeedsDto {

    /** お客様ID */
    @NotBlank
    @MessageName("お客様ID")
    private Integer id;

    /** 来店日 */
    @NotBlank
    @MessageName("来店日")
    private LocalDateTime visitDate;

    /** 見えないと困るもの */
    @Size(max = 100)
    @MessageName("見えないと困るもの")
    private String whatToSee;

    /** 削除フラグ */
    @NotBlank
    @MessageName("削除フラグ")
    private Boolean delFlg;

    /** 登録日時 */
    @NotBlank
    @MessageName("登録日時")
    private LocalDateTime createDate;

    /** 登録者コード */
    @NotBlank
    @Size(max = 8)
    @MessageName("登録者コード")
    private String createId;

    /** 更新日時 */
    @NotBlank
    @MessageName("更新日時")
    private LocalDateTime updateDate;

    /** 更新者コード */
    @NotBlank
    @Size(max = 8)
    @MessageName("更新者コード")
    private String updateId;
}
