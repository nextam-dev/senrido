package jp.co.senrido.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TSurgeryDto {

	/** お客様ID */
    private Integer id;

    /** 来店日 */
    private String visitDate;
    private String visitDateStr;

    /** 手術時期 */
    private String surgeryDate;
    private String surgeryDateStr;

    /** 手術予定時期 */
    private String surgeryPlannedDate;
    private String surgeryPlannedDateStr;

    /** 白内障 */
    private List<String> cataract;

    /** 白内障名称 */
    private String cataractName;

    /** 緑内障 */
    private List<String> glaucoma;

    /** 緑内障名称 */
    private String glaucomaName;

    /** 飛蚊症 */
    private List<String> floaters;

    /** 飛蚊症名称 */
    private String floatersName;

    /** 網膜剥離 */
    private List<String> retinalDetachment;

    /** 網膜剥離名称 */
    private String retinalDetachmentName;

    /** 斜視 */
    private List<String> strabismus;

    /** 斜視名称 */
    private String strabismusName;

    /** 硝子体 */
    private List<String> vitreousBody;

    /** 硝子体名称 */
    private String vitreousBodyName;

    /** レーシック */
    private List<String> lasik;

    /** レーシック名称 */
    private String lasikName;

    /** ICL/IOL */
    private List<String> iclIol;

    /** ICL/IOL名称 */
    private String iclIolName;
}
