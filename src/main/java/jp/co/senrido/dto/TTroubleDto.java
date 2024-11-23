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
public class TTroubleDto {

    /** お客様ID */
    @NotNull
    @MessageName("お客様ID")
    private Integer id;

    /** 来店日 */
    @NotNull
    @MessageName("来店日")
    private LocalDateTime visitDate;

    /** メガネトラブル */
    @Size(max = 100)
    @MessageName("メガネトラブル")
    private String glassesIssues;

    /** メガネトラブル名称 */
    @Size(max = 2000)
    @MessageName("メガネトラブル名称")
    private String glassesIssuesName;

    /** フレームトラブル */
    @Size(max = 100)
    @MessageName("フレームトラブル")
    private String frameIssues;

    /** フレームトラブル名称 */
    @Size(max = 2000)
    @MessageName("フレームトラブル名称")
    private String frameIssuesName;

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
