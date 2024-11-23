package jp.co.senrido.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jp.co.senrido.annotation.MessageName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TEyeUsageStatusDto {

    /** お客様ID */
    @NotNull
    @MessageName("お客様ID")
    private Integer id;

    /** 来店日 */
    @NotNull
    @MessageName("来店日")
    private LocalDateTime visitDate;

    /** 携帯・スマホの使用時間 */
    @MessageName("携帯・スマホの使用時間")
    private Integer useTimeMobilePhone;

    /** 携帯・スマホの画面との距離 */
    @MessageName("携帯・スマホの画面との距離")
    private Integer distanceMobilePhone;

    /** パソコン種類 */
    @Size(max = 100)
    @MessageName("パソコン種類")
    private String computerType;

    /** パソコン種類その他 */
    @Size(max = 1000)
    @MessageName("パソコン種類その他")
    private String computerTypeOther;

    /** パソコン種類名称 */
    @Size(max = 2000)
    @MessageName("パソコン種類名称")
    private String computerTypeName;

    /** タブレットの使用時間 */
    @MessageName("タブレットの使用時間")
    private Integer useTimeTablet;

    /** パソコンの使用時間 */
    @MessageName("パソコンの使用時間")
    private Integer useTimePc;

    /** パソコンの使用時間・タブレットの画面との距離 */
    @MessageName("パソコンの使用時間・タブレットの画面との距離")
    private Integer monitorDistance;

    /** 読書の時間 */
    @MessageName("読書の時間")
    private Integer readingTime;

    /** 読書の習慣 */
    @Size(max = 100)
    @MessageName("読書の習慣")
    private String readingHabits;

    /** 読書の習慣名称 */
    @Size(max = 2000)
    @MessageName("読書の習慣名称")
    private String readingHabitsName;

    /** 冊数 */
    @MessageName("冊数")
    private Integer numberOfBooks;

    /** 本との距離 */
    @MessageName("本との距離")
    private Integer distanceBook;

    /** 字を書く時の距離 */
    @MessageName("字を書く時の距離")
    private Integer distanceWriting;

    /** ゲームの時間 */
    @MessageName("ゲームの時間")
    private Integer gameTime;

    /** ゲーム */
    @Size(max = 100)
    @MessageName("ゲーム")
    private String gaming;

    /** ゲームその他 */
    @Size(max = 1000)
    @MessageName("ゲームその他")
    private String gamingOther;

    /** ゲーム名称 */
    @Size(max = 2000)
    @MessageName("ゲーム名称")
    private String gamingName;

    /** ゲームの環境-距離テレビで */
    @MessageName("ゲームの環境-距離テレビで")
    private Integer distanceTvGame;

    /** ゲームの環境-手元で */
    @MessageName("ゲームの環境-手元で")
    private Integer distanceGame;

    /** テレビの時間 */
    @MessageName("テレビの時間")
    private Integer tvTime;

    /** テレビとの距離 */
    @MessageName("テレビとの距離")
    private Integer distanceTv;

    /** テレビの大きさ */
    @MessageName("テレビの大きさ")
    private Integer tvSize;

    /** 運転 */
    @Size(max = 5)
    @MessageName("運転")
    private String driving;

    /** 運転その他 */
    @Size(max = 1000)
    @MessageName("運転その他")
    private String drivingOther;

    /** 運転目名称 */
    @Size(max = 200)
    @MessageName("運転目名称")
    private String drivingEyeName;

    /** 運転回数 */
    @MessageName("運転回数")
    private Integer drivingCount;

    /** 免許種類 */
    @Size(max = 100)
    @MessageName("免許種類")
    private String licenseType;

    /** 免許種類その他 */
    @Size(max = 1000)
    @MessageName("免許種類その他")
    private String licenseTypeOther;

    /** 免許種類名称 */
    @Size(max = 2000)
    @MessageName("免許種類名称")
    private String licenseTypeName;

    /** 次回免許更新日 */
    @MessageName("次回免許更新日")
    private LocalDateTime nextLicenseUpdateDate;

    /** 削除フラグ */
    @NotNull
    @MessageName("削除フラグ")
    private Boolean delFlg;

    /** 登録日時 */
    @NotNull
    @MessageName("登録日時")
    private LocalDateTime createDate;

    /** 登録者コード */
    @NotBlank
    @Size(max = 8)
    @MessageName("登録者コード")
    private String createId;

    /** 更新日時 */
    @NotNull
    @MessageName("更新日時")
    private LocalDateTime updateDate;

    /** 更新者コード */
    @NotBlank
    @Size(max = 8)
    @MessageName("更新者コード")
    private String updateId;
}
