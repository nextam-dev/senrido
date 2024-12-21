package jp.co.senrido.dto;

import javax.validation.constraints.Pattern;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TCustomerInitDto {

	 /** お客様ID */
    private Integer id;

    /** 顧客番号 */
    private String customerCd;

    /** お客様名 */
	@MessageName("お名前")
	private String name;

	/** お客様名カナ */
	@MessageName("お名前（カタカナ）")
	private String nameKana;

    /** 生年月日和暦年号 */
    private String birthdayNengo;

    /** 生年月日 */
	@MessageName("生年月日")
	private String birthday;
    private String birthdayStr;

    /** 性別 */
	@MessageName("性別")
	private String sex;

	/** 性別その他 */
	@MessageName("性別（その他）")
	private String sexOther;
    
    /** 性別名称 */
    private String sexName;

    /** 郵便番号 */
    @MessageName("郵便番号")
	@Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String zipcode;

    /** 都道府県コード */
    private String prefectureCd;

    /** 住所 */
    @MessageName("住所")
    private String address;

    /** 主連絡先区分 */
    private String mainContactType;

    /** 電話番号 */
    @MessageName("電話番号")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String telephone;

    /** 携帯電話番号 */
    @MessageName("携帯電話番号")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String mobilePhone;

    /** 勤務先電話番号 */
    @MessageName("勤務先電話番号")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String workPhone;

    /** 担当者コード */
    private String personInChargeCd;

    /** 紹介者 */
    @MessageName("紹介者")
    private String referrer;

    /** 職業 */
    private String occupation;

    /** メールアドレス */
    @MessageName("メールアドレス")
    private String mail;

    /** 次回来店日 */
    private String nextVisitDate;
    private String nextVisitDateStr;

    /** 前回来店日 */
    private String previousVisitDate;
    private String previousVisitDateStr;
}
