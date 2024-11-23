package jp.co.senrido.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TUsageStatusDto {

    /** お客様ID */
    @NotNull
    @MessageName("お客様ID")
    private Integer id;

    /** 来店日 */
    @NotNull
    @MessageName("来店日")
    private LocalDateTime visitDate;

    /** メガネ・CL の装用状況-現状 */
    @Size(max = 5)
    @MessageName("メガネ・CL の装用状況-現状")
    private String currentStatusCd;

    /** メガネ・CL の装用状況-現状名称 */
    @Size(max = 2000)
    @MessageName("メガネ・CL の装用状況-現状名称")
    private String glassesClUsageCurrentName;

    /** メガネ・CL の装用状況-CL併用 */
    @Size(max = 5)
    @MessageName("メガネ・CL の装用状況-CL併用")
    private String combinedUseClCd;

    /** メガネ・CL の装用状況-CL併用名称 */
    @Size(max = 2000)
    @MessageName("メガネ・CL の装用状況-CL併用名称")
    private String glassesClUsageCombinedName;

    /** メガネ用途 */
    @Size(max = 100)
    @MessageName("メガネ用途")
    private String glassesPurpose;

    /** メガネ用途名称 */
    @Size(max = 2000)
    @MessageName("メガネ用途名称")
    private String glassesPurposeName;

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
