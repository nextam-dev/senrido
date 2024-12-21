package jp.co.senrido.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TTroubleDto {

	/** お客様ID */
    private Integer id;

    /** 来店日 */
    private String visitDate;
    private String visitDateStr;

    /** メガネトラブル */
    private List<String> glassesIssues;

    /** メガネトラブル名称 */
    private String glassesIssuesName;

    /** フレームトラブル */
    private List<String> frameIssues;

    /** フレームトラブル名称 */
    private String frameIssuesName;

}
