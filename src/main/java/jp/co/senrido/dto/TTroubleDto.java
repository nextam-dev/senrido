package jp.co.senrido.dto;

import java.util.List;

import javax.validation.constraints.Size;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TTroubleDto {

	/** お客様ID */
    @MessageName("お客様ID")
    private Integer id;

    /** 来店日 */
    @MessageName("来店日")
    private String visitDate;
    private String visitDateStr;

    /** メガネトラブル */
    @MessageName("メガネトラブル")
    private List<String> glassesIssues;

    /** メガネトラブル名称 */
    @MessageName("メガネトラブル名称")
    private String glassesIssuesName;

    /** フレームトラブル */
    @MessageName("フレームトラブル")
    private List<String> frameIssues;

    /** フレームトラブル名称 */
    @MessageName("フレームトラブル名称")
    private String frameIssuesName;

}
