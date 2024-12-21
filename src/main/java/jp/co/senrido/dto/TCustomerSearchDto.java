package jp.co.senrido.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TCustomerSearchDto {

    /** 店舗 */
    private String shopCd;

    /** 顧客番号 */
    private String customerCd;

    /** お名前 */
    private String name;

    /** お名前カナ */
    private String nameKana;

    /** 主連絡先区分 */
    private String mainContactType;

    /** 電話番号 */
    private String telephone;

    /** 携帯電話番号 */
    private String mobilePhone;

    /** 勤務先電話番号 */
    private String workPhone;

    /** 性別 */
    private String sex;

    /** 来店日（開始） */
    private LocalDate visitDateStart;

    /** 来店日（終了） */
    private LocalDate visitDateEnd;

    /** 摘要 */
    private String outline;

    /** 担当者 */
    private String personInCharge;

    /** 前回来店日 */
    private LocalDate previousVisitDate;

    /** 次回来店日 */
    private LocalDate nextVisitDate;

    /** 前回来店日 */
    private String previousVisitDateStr;

    /** 次回来店日 */
    private String nextVisitDateStr;

    /** 住所 */
    private String address;

    /** 生年月日 */
    private LocalDateTime birthday;

    /** 生年月日 */
    private String birthdayStr;

    /** 生年月日（和暦） */
    private String birthdayNengo;

    /** 担当者名 */
    private String personName;

    /** 時間枠 */
    private String timeSlot;

    /** 開催日（前） */
    private LocalDate eventDateStart;

    /** 開催日（後） */
    private LocalDate eventDateEnd;
}
