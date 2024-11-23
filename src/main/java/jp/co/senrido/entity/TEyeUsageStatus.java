package jp.co.senrido.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Data;

@Entity(listener = TEyeUsageStatusListener.class)
@Table(name = "t_eye_usage_status")
@Data
public class TEyeUsageStatus {

    /** お客様ID */
    @Id
    @Column(name = "id")
    Integer id;

    /** 来店日 */
    @Column(name = "visit_date")
    LocalDateTime visitDate;

    /** 携帯・スマホの使用時間 */
    @Column(name = "use_time_mobile_phone")
    Integer useTimeMobilePhone;

    /** 携帯・スマホの画面との距離 */
    @Column(name = "distance_mobile_phone")
    Integer distanceMobilePhone;

    /** パソコン種類 */
    @Column(name = "computer_type")
    String computerType;

    /** パソコン種類その他 */
    @Column(name = "computer_type_other")
    String computerTypeOther;

    /** パソコン種類名称 */
    @Column(name = "computer_type_name")
    String computerTypeName;

    /** タブレットの使用時間 */
    @Column(name = "use_time_tablet")
    Integer useTimeTablet;

    /** パソコンの使用時間 */
    @Column(name = "use_time_pc")
    Integer useTimePC;

    /** パソコンの使用時間・タブレットの画面との距離 */
    @Column(name = "monitor_ditance")
    Integer monitorDistance;

    /** 読書の時間 */
    @Column(name = "reading_time")
    Integer readingTime;

    /** 読書の習慣 */
    @Column(name = "reading_habits")
    String readingHabits;

    /** 読書の習慣名称 */
    @Column(name = "reading_habits_name")
    String readingHabitsName;

    /** 冊数 */
    @Column(name = "number_of_books")
    Integer numberOfBooks;

    /** 本との距離 */
    @Column(name = "distance_book")
    Integer distanceBook;

    /** 字を書く時の距離 */
    @Column(name = "distance_wtitting")
    Integer distanceWriting;

    /** ゲームの時間 */
    @Column(name = "game_time")
    Integer gameTime;

    /** ゲーム */
    @Column(name = "gaming")
    String gaming;

    /** ゲームその他 */
    @Column(name = "gaming_other")
    String gamingOther;

    /** ゲーム名称 */
    @Column(name = "gaming_name")
    String gamingName;

    /** ゲームの環境-距離テレビで */
    @Column(name = "distance_tv_game")
    Integer distanceTVGame;

    /** ゲームの環境-手元で */
    @Column(name = "distance_game")
    Integer distanceGame;

    /** テレビの時間 */
    @Column(name = "tv_time")
    Integer tvTime;

    /** テレビとの距離 */
    @Column(name = "distance_tv")
    Integer distanceTV;

    /** テレビの大きさ */
    @Column(name = "tv_size")
    Integer tvSize;

    /** 運転 */
    @Column(name = "driving")
    String driving;

    /** 運転その他 */
    @Column(name = "driving_other")
    String drivingOther;

    /** 運転目名称 */
    @Column(name = "driving_eye_name")
    String drivingEyeName;

    /** 運転回数 */
    @Column(name = "driving_count")
    Integer drivingCount;

    /** 免許種類 */
    @Column(name = "license_type")
    String licenseType;

    /** 免許種類その他 */
    @Column(name = "license_type_other")
    String licenseTypeOther;

    /** 免許種類名称 */
    @Column(name = "license_type_name")
    String licenseTypeName;

    /** 次回免許更新日 */
    @Column(name = "next_license_renewal_date")
    LocalDateTime nextLicenseRenewalDate;

    /** 削除フラグ */
    @Column(name = "del_flg")
    Boolean delFlg;

    /** 登録日時 */
    @Column(name = "create_date")
    LocalDateTime createDate;

    /** 登録者コード */
    @Column(name = "create_id")
    String createId;

    /** 更新日時 */
    @Column(name = "update_date")
    LocalDateTime updateDate;

    /** 更新者コード */
    @Column(name = "update_id")
    String updateId;
}
