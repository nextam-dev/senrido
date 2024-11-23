package jp.co.senrido.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.makino_saiten.goitai.annotation.MessageName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TDiscomfortFatigueDto {

    /** お客様ID */
    @NotBlank
    @MessageName("お客様ID")
    private Integer id;

    /** 来店日 */
    @NotBlank
    @MessageName("来店日")
    private LocalDateTime visitDate;

    /** 見づらさや疲れを感じるとき */
    @Size(max = 200)
    @MessageName("見づらさや疲れを感じるとき")
    private String feelTired;

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
