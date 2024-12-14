package jp.co.senrido.dto;

import java.util.List;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TUsageStatusDto {

	/** お客様ID */
    @MessageName("お客様ID")
    private Integer id;

    /** 来店日 */
    @MessageName("来店日")
    private String visitDate;
    private String visitDateStr;

    /** メガネ・CL の装用状況-現状 */
    @MessageName("メガネ・CL の装用状況-現状")
    private List<String> currentStatusCd;

    /** メガネ・CL の装用状況-現状名称 */
    @MessageName("メガネ・CL の装用状況-現状名称")
    private String glassesClUsageCurrentName;

    /** メガネ・CL の装用状況-CL併用 */
    @MessageName("メガネ・CL の装用状況-CL併用")
    private List<String> combinedUseClCd;

    /** メガネ・CL の装用状況-CL併用名称 */
    @MessageName("メガネ・CL の装用状況-CL併用名称")
    private String glassesClUsageCombinedName;

    /** メガネ用途 */
    @MessageName("メガネ用途")
    private List<String> glassesPurpose;

    /** メガネ用途名称 */
    @MessageName("メガネ用途名称")
    private String glassesPurposeName;

}
