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
public class TSurgeryDto {

    /** お客様ID */
    @NotNull
    @MessageName("お客様ID")
    private Integer id;

    /** 来店日 */
    @NotNull
    @MessageName("来店日")
    private LocalDateTime visitDate;

    /** 手術時期 */
    @MessageName("手術時期")
    private LocalDate surgeryDate;

    /** 手術予定時期 */
    @MessageName("手術予定時期")
    private LocalDate surgeryPlannedDate;

    /** 白内障 */
    @Size(max = 20)
    @MessageName("白内障")
    private String cataract;

    /** 白内障名称 */
    @Size(max = 100)
    @MessageName("白内障名称")
    private String cataractName;

    /** 緑内障 */
    @Size(max = 20)
    @MessageName("緑内障")
    private String glaucoma;

    /** 緑内障名称 */
    @Size(max = 100)
    @MessageName("緑内障名称")
    private String glaucomaName;

    /** 飛蚊症 */
    @Size(max = 20)
    @MessageName("飛蚊症")
    private String floaters;

    /** 飛蚊症名称 */
    @Size(max = 100)
    @MessageName("飛蚊症名称")
    private String floatersName;

    /** 網膜剥離 */
    @Size(max = 20)
    @MessageName("網膜剥離")
    private String retinalDetachment;

    /** 網膜剥離名称 */
    @Size(max = 100)
    @MessageName("網膜剥離名称")
    private String retinalDetachmentName;

    /** 斜視 */
    @Size(max = 20)
    @MessageName("斜視")
    private String strabismus;

    /** 斜視名称 */
    @Size(max = 100)
    @MessageName("斜視名称")
    private String strabismusName;

    /** 硝子体 */
    @Size(max = 20)
    @MessageName("硝子体")
    private String vitreousBody;

    /** 硝子体名称 */
    @Size(max = 100)
    @MessageName("硝子体名称")
    private String vitreousBodyName;

    /** レーシック */
    @Size(max = 20)
    @MessageName("レーシック")
    private String lasik;

    /** レーシック名称 */
    @Size(max = 100)
    @MessageName("レーシック名称")
    private String lasikName;

    /** ICL/IOL */
    @Size(max = 20)
    @MessageName("ICL/IOL")
    private String iclIol;

    /** ICL/IOL名称 */
    @Size(max = 100)
    @MessageName("ICL/IOL名称")
    private String iclIolName;

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
