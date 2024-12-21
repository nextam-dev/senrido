package jp.co.senrido.dto;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TGlassesUsageDto {

	/** お客様ID */
    private Integer id;

    /** 来店日 */
    private String visitDate;
    private String visitDateStr;

    /** メガネの装用 */
    @MessageName("メガネの装用")
    private String useGlasses;

}
