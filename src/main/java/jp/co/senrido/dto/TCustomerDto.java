package jp.co.senrido.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TCustomerDto {

    /** お客様ID */
    private Integer id;

    /** 顧客番号 */
    private String customerCd;

    /** お名前 */
    private String name;

    /** お名前カナ */
    private String nameKana;

    /** 生年月日和暦年号 */
    private String birthdayNengo;

    /** 生年月日 */
    private LocalDate birthday;

    /** 性別 */
    private String sex;

    /** 性別その他 */
    private String sexOther;

    /** 郵便番号 */
    private String zipcode;

    /** 都道府県コード */
    private String prefectureCd;

    /** 住所 */
    private String address;

    /** 主連絡先区分 */
    private String mainContactType;

    /** 電話番号 */
    private String telephone;

    /** 携帯電話番号 */
    private String mobilePhone;

    /** 勤務先電話番号 */
    private String workPhone;

    /** 担当者コード */
    private String personInChargeCd;

    /** 紹介者 */
    private String referrer;

    /** 職業 */
    private String occupation;

    /** メールアドレス */
    private String mail;

    /** 次回来店日 */
    private LocalDate nextVisitDate;
    private String nextVisitDateStr;

    /** 前回来店日 */
    private LocalDate previousVisitDate;
    private String previousVisitDateStr;

    /** 削除フラグ */
    private Boolean delFlg;

    /** 登録日時 */
    private LocalDateTime createDate;

    /** 登録者コード */
    private String createId;

    /** 更新日時 */
    private LocalDateTime updateDate;

    /** 更新者コード */
    private String updateId;
}
