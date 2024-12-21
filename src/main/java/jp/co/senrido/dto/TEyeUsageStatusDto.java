package jp.co.senrido.dto;

import java.util.List;

import javax.validation.constraints.Pattern;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TEyeUsageStatusDto {

	/** お客様ID */
    private Integer id;

    /** 来店日 */
    private String visitDate;
    private String visitDateStr;

    /** 携帯・スマホの使用時間 */
    @MessageName("携帯・スマホの使用時間")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String useTimeMobilePhone;

    /** 携帯・スマホの画面との距離 */
    @MessageName("携帯・スマホの画面との距離")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String distanceMobilePhone;

    /** パソコン種類 */
    private List<String> computerType;

    /** パソコン種類その他 */
    private String computerTypeOther;

    /** パソコン種類名称 */
    private String computerTypeName;

    /** タブレットの使用時間 */
    @MessageName("タブレットの使用時間")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String useTimeTablet;

    /** パソコンの使用時間 */
    @MessageName("パソコンの使用時間")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String useTimePc;

    /** パソコンの使用時間・タブレットの画面との距離 */
    @MessageName("パソコンの使用時間・タブレットの画面との距離")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String monitorDistance;

    /** 読書の時間 */
    @MessageName("読書の時間")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String readingTime;

    /** 読書の習慣 */
    private String readingHabits;

    /** 読書の習慣名称 */
    private String readingHabitsName;

    /** 冊数 */
    @MessageName("冊数")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String numberOfBooks;

    /** 本との距離 */
    @MessageName("本との距離")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String distanceBook;

    /** 字を書く時の距離 */
    @MessageName("字を書く時の距離")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String distanceWriting;

    /** ゲームの時間 */
    private String gameTime;

    /** ゲーム */
    private List<String> gaming;

    /** ゲームその他 */
    private String gamingOther;

    /** ゲーム名称 */
    private String gamingName;

    /** ゲームの環境-距離テレビで */
    @MessageName("ゲームの環境-距離テレビで")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String distanceTvGame;

    /** ゲームの環境-手元で */
    @MessageName("ゲームの環境-手元で")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String distanceGame;

    /** テレビの時間 */
    @MessageName("テレビの時間")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String tvTime;

    /** テレビとの距離 */
    @MessageName("テレビとの距離")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String distanceTv;

    /** テレビの大きさ */
    @MessageName("テレビの大きさ")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String tvSize;
    
    /** 運転の習慣 */
    private String drivingHabits;
    
    /** 運転の習慣名称 */
    private String drivingHabitsName;

    /** 運転 */
    private List<String> driving;

    /** 運転その他 */
    private String drivingOther;

    /** 運転目名称 */
    private String drivingEyeName;

    /** 運転回数 */
    @MessageName("運転回数")
    @Pattern(regexp = "^[0-9]*$", message = "{0}は半角数字で入力してください。")
    private String drivingCount;

    /** 免許種類 */
    private List<String> licenseType;

    /** 免許種類その他 */
    private String licenseTypeOther;

    /** 免許種類名称 */
    private String licenseTypeName;

    /** 次回免許更新日 */
    private String nextLicenseUpdateDate;
    private String nextLicenseUpdateDateStr;

}
