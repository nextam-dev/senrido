package jp.co.senrido.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TGlareDto {

	/** お客様ID */
    private Integer id;

    /** 来店日 */
    private String visitDate;
    private String visitDateStr;

    /** 眩しさを感じる物事*/
    private List<String> glareSources;

    /** 眩しさを感じる物事その他 */
    private String glareSourcesOther;

    /** 眩しさを感じる物事名称 */
    private String glareSourcesName;

    /**　強い光を感じたとき目に痛み*/
    private String eyePainStrongLight;

}
