/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：U002MenuForm.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package jp.co.senrido.form;

import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import jp.co.senrido.annotation.DatePattern;
import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 眼科への通院 更新用Formクラス
 * @author kurokawa
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class UpdateVisitingHospitalForm extends BaseSearchForm {

	private static final long serialVersionUID = 1L;

    /** 受診日 */
    @MessageName("受診日")
	@DatePattern(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String consultationDate;
    
    /** 眼科名 */
    @MessageName("眼科名")
    private String ophthalmologyName;

    /** 眼科への通院 */
    @MessageName("眼科への通院")
    private String visitEyeDoctor;

    /** 病歴 */
    @Size(max = 100)
    @MessageName("病歴")
    private List<String> medicalHistory;

    /** 病歴その他 */
    @Size(max = 1000)
    @MessageName("病歴その他")
    private String medicalHistoryOther;

    /** 病歴名称 */
    @Size(max = 2000)
    @MessageName("病歴名称")
    private String medicalHistoryName;

    /** メガネ作製の指示 */
    @MessageName("メガネ作製の指示")
    private String glassesMaking;

    /** 処方箋 */
    @MessageName("処方箋")
    private String prescription;

    /** 眼科医の指示・意見 */
    @Size(max = 2000)
    @MessageName("眼科医の指示・意見")
    private String ophthalmologistInstructions;

}
